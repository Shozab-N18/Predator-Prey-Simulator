import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field
 * containing Dinosaurs and Plants
 * 
 * @author David J. Barnes, Michael Kölling, Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 2016.02.29 (2)22
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 220;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 150;
    
    // The probability that each Species will appear on the screen.
    private static final double TYRANNOSAURUS_CREATION_PROBABILITY = 0.015;
    private static final double TRICERATOPS_CREATION_PROBABILITY = 0.4;   
    private static final double RAPTOR_CREATION_PROBABILITY = 0.05;  
    private static final double SPINOSAURUS_CREATION_PROBABILITY = 0.075; 
    private static final double BRACHIOSAURUS_CREATION_PROBABILITY = 0.5; 
    private static final double TREE_CREATION_PROBABILITY = 0.075;
    private static final double GRASS_CREATION_PROBABILITY = 0.075; 

    private List<Organism> Organisms;   // List of Organisms in the field.

    private Field field; // The current state of the field.
    // A graphical view of the simulation.
    private SimulatorView view;

    private TimeOfDay timeOfDay;    //The Current Time Of Day

    private Weather weather;    //The current weather

    private long time;      

    private List<TimeOfDay> day; //Stores the cycle of a day

    private int dayNumber;   //Stores the number of days passed

    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        time = System.currentTimeMillis(); // The time that the simulation was created.
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        Organisms = new ArrayList<>();
        field = new Field(depth, width);
        createDay();    //Creates a template for a day

        timeOfDay = new Morning();

        weather = timeOfDay.setWeather();   //Sets the new Weather
        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(Triceratops.class, Color.MAGENTA);
        view.setColor(Tyrannosaurus.class, Color.BLUE);
        view.setColor(Velociraptor.class, Color.BLACK);
        view.setColor(Spinosaurus.class, Color.RED);
        view.setColor(Brachiosaurus.class, Color.CYAN);
        view.setColor(Tree.class, Color.GREEN);
        view.setColor(Grass.class, Color.ORANGE);
        reset();
    }

    /**
     * Main Method, will run a long simulations.
     */
    public static void main(String[] args){
        Simulator simulator = new Simulator();
        simulator.runLongSimulation();
    }

    /**
     * Will create a template for a day, in the right order.
     */
    public void createDay(){
        day = new ArrayList();
        day.add(new Morning());
        day.add(new MidDay());
        day.add(new Evening());
        day.add(new Night());
    }

    public void dayCounter(){
        if(timeOfDay instanceof Morning){
            dayNumber++;
            for(Organism organism : Organisms){
                if(organism instanceof Dinosaurs){
                    Dinosaurs dino = (Dinosaurs) organism;
                    dino.setEating(0);
                }
            }
        }
    }

    /**
     * Method which will iterate through the list of days to check whether to change time of day or not.
     */
    public TimeOfDay simulateDay(){
        long n = System.currentTimeMillis() % timeOfDay.getDurationOfDay();

        for(TimeOfDay time: day){
            if(n<=time.getEndTime() && n>=time.getStartTime()){
                return time;
            }
        }
        return null;
    }

    /**
     * Run the simulation from its current state for a reasonably long period,
     * (60 Seconds).
     */
    public void runLongSimulation()
    {
        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime <= 120000 &&  view.isViable(field))  // Runs for 60 seconds
        {
            simulateOneSecond();
        }
    }

    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneSecond();
            //delay(6000);   // uncomment this to run more slowly

        }
    }

    /**
     * Run the simulation from its current state for a single second.
     * Iterate over the whole field updating the state of each
     * dinosaur and plant.
     */
    public void simulateOneSecond()
    {
        long n = System.currentTimeMillis();
        while((System.currentTimeMillis() - n) < 1000){ //Runs the while loop until 1 second has been completed.
            //timeOfDay = timeOfDay.checkTime(n);
            timeOfDay = simulateDay();
            if(n-time >= 5000)  // Every 5 seconds the Weather can be changed.
            {
                weather = timeOfDay.setWeather();//Time of day has an impact on the weather
                time = n;
                dayCounter();
            }
            getWeather();   //Adds the weather to the GUI

            List<Organism> newOrganisms = new ArrayList<>();    //List for new borns.
            Random rand = new Random();
            for(Iterator<Organism> it = Organisms.iterator(); it.hasNext(); ) {
                Organism organism = (Organism) it.next();
                organism.setWeather(weather);
                if(organism instanceof Dinosaurs && n-time >= 5000)  //Sets the speedfor the Dinosaurs based on the current weather
                {
                    Dinosaurs dino = (Dinosaurs) organism;
                    dino.resetSpeed();
                    dino.setWeatherSpeed();
                    dino.slowDownByDisease();
                    //dino.setEating(dino.getNumberEaten() % dayNumber);

                }   
                organism.incrementAge();
                if(!(timeOfDay.isSleepTime(organism)))  //Dinosaur does not act if it's it sleep time.
                {
                    organism.act(newOrganisms);
                }
                if(weather instanceof Meteor && rand.nextDouble() <= 0.007){   //Catastrophic weather than destroys a lot of the population.
                    organism.setDead();
                }
                if(!organism.isAlive()) {   //If dead, remove from the list
                    it.remove();
                }
            }
            // Add the newly born Organisms to the main lists.
            Organisms.addAll(newOrganisms);
            getTimeOfDay();
            view.showStatus(dayNumber, field);
        }
    }

    /**
     * Used to display the Current Time of Day on the GUI
     */
    public void getTimeOfDay(){
        view.dayString(timeOfDay.toString());
    }

    /**
     * Used to display the Current Weather on the GUI
     */
    public void getWeather()
    {
        view.weatherString(weather.toString());
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        dayNumber = 0;
        Organisms.clear();
        populate();
        getTimeOfDay();
        getWeather();

        // Show the starting state in the view.
        view.showStatus(dayNumber, field);
    }

    /**
     * Randomly populate the field with Organisms
     */
    private void populate()
    {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= TYRANNOSAURUS_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Tyrannosaurus trex = new Tyrannosaurus();//, field, location);
                    trex.setRandomly();
                    trex.setField(field);
                    trex.setLocation(location);
                    Organisms.add(trex);
                }
                else if(rand.nextDouble() <= TRICERATOPS_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Triceratops triceratops = new Triceratops();
                    triceratops.setRandomly();
                    triceratops.setField(field);
                    triceratops.setLocation(location);
                    Organisms.add(triceratops);
                }else if(rand.nextDouble() <= BRACHIOSAURUS_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Brachiosaurus brac = new Brachiosaurus();
                    brac.setRandomly();
                    brac.setField(field);
                    brac.setLocation(location);
                    Organisms.add(brac);
                }
                else if(rand.nextDouble() <= RAPTOR_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Velociraptor raptor = new Velociraptor();
                    raptor.setRandomly();
                    raptor.setField(field);
                    raptor.setLocation(location);
                    if(rand.nextDouble() <= 0.01){              //Some organisms can spawn with a disease
                        raptor.setDisease(new Cholera());
                    }
                    Organisms.add(raptor);
                }else if(rand.nextDouble() <= SPINOSAURUS_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Spinosaurus spinosaurus = new Spinosaurus();
                    spinosaurus.setRandomly();
                    spinosaurus.setField(field);
                    spinosaurus.setLocation(location);
                    if(rand.nextDouble() <= 0.01){
                        spinosaurus.setDisease(new Cholera());
                    }
                    Organisms.add(spinosaurus);
                }else if(rand.nextDouble() <= TREE_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Tree tree = new Tree();
                    tree.setRandomly();
                    tree.setField(field);
                    tree.setLocation(location);
                    Organisms.add(tree);
                }else if(rand.nextDouble() <= GRASS_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Grass grass = new Grass();
                    grass.setRandomly();
                    grass.setField(field);
                    grass.setLocation(location);
                    Organisms.add(grass);
                }
            }
        }
    }

    /**
     * Pause for a given time.
     * @param millisec  The time to pause for, in milliseconds
     */
    private void delay(int millisec)
    {
        try {
            Thread.sleep(millisec);
        }
        catch (InterruptedException ie) {
            // wake up
        }
    }
}
