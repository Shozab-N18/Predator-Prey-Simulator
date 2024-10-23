import java.util.List;

/**
 * Dinosaurs inherit directly from organism class. 
 * Hold different methods that allow organism to breeding and move around.
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1.0
 */
public abstract class Dinosaurs extends Organism
{
    //Stores whether the dinosaur is a male or not (female).
    private boolean isMale;
    //Keeps track of how many times a dinosaur has breeded in its lifetime.
    private int breedNumber;
    //Keeps track of animals eaten per day.
    private int numberEaten;

    private double speed;

    /**
     * Constructor for objects of class Dinosaurs
     */
    public Dinosaurs()
    {
        isMale = rand.nextBoolean();
        breedNumber = 0;
    }

    /**
     * This is what the dinosaur does most of the time: it hunts for
     * prey. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param newOrganism A list to return newly born species.
     */
    public void act(List<Organism> newOrganism)
    {
        if(System.currentTimeMillis() - getTime() >= speed)
        {//checks if  the current time - time organism last acted is more than the speed of the animal.
            incrementHunger();
        }
        else
        {
            resetSpeed();
            return;
        }

        checkDeathByDisease();

        if(isAlive()){
            setTime(System.currentTimeMillis());
            takeDisease();
            giveBirth(newOrganism);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Check whether or not this dinosaur is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born dinosaur.
     */
    public void giveBirth(List<Organism> newOrganism)
    {
        Field field = getField();

        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Dinosaurs young;
            if(this instanceof Triceratops){
                young = new Triceratops();//,field,loc);
                young.setField(field);
                young.setLocation(loc);
            }else if(this instanceof Tyrannosaurus){
                young = new Tyrannosaurus();//,field,loc);
                young.setField(field);
                young.setLocation(loc);
            }else if(this instanceof Velociraptor) {
                young = new Velociraptor();//,field,
                young.setField(field);
                young.setLocation(loc);
            }else if(this instanceof Spinosaurus){
                young = new Spinosaurus();//,field,loc)
                young.setField(field);
                young.setLocation(loc);
            }else{
                young = new Brachiosaurus();//,field,loc);
                young.setField(field);
                young.setLocation(loc);
            }

            if(rand.nextDouble() <= 0.9)
            {
                young.setBaseSpeed(getSpeed()*0.9);
                young.setSpeed(getSpeed()*0.9);
            }
            young.setDisease(getDisease());
            newOrganism.add(young);
        }
    }

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    public int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
            breedNumber++;
        }
        return births;
    }

    /**
     * A dinosaur can give offspring if it has reached the breeding age, is not a male,
     * if the dinosaur adjacent is of the same dinosaur type and if they have opposite genders.
     */
    public boolean canBreed()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        if(breedNumber >= getMaxBreeding() || isMale()){
            return false;
        }

        if(getNumberEaten() < 2) // needs to eat twice otherwise animals will overbreed.
        {
            return false;
        }

        for(Location loc : adjacent){
            if(field.getObjectAt(loc) instanceof Dinosaurs){
                Dinosaurs dino = (Dinosaurs) field.getObjectAt(loc);
                if(instance(dino) && (isMale() != dino.isMale()) && getAge() >= getBreedingAge()){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sets the speed of the current dinosaur to an certain value.
     * @param newSpeed
     */
    protected void setSpeed(double newSpeed){
        speed = newSpeed;
    }

    /**
     * @return The current speed of the dinosaur.
     */
    protected double getSpeed()
    {
        return speed;
    }

    /**
     * Return's whether the current dinosaur is a Male or not.
     * @return boolean 
     */
    public boolean isMale(){
        return isMale;
    }

    /**
     * Return's the number of animals that the dinosaur has eaten in a day.
     * @int numberEaten
     */
    protected int getNumberEaten(){
        return numberEaten;
    }

    /**
     * Increases the number of animals that a dinosaur has eaten by one.
     */
    protected void incrementNumberEaten(){
        numberEaten++;
    }

    /**
     * Reduces the speed of the dinosaur if the animal has a disease.
     * The rate at which it slows down is dependant on the disease type.
     */
    protected void slowDownByDisease(){
        if(getDisease() != null){
            setSpeed(getSpeed()*getDisease().getSlowRate());
        }
    }

    /**
     * Used to reset the number of animals that a dinosaur has eaten every day.
     * @param newEatingValue 
     */
    public void setEating(int newEatingValue){
        numberEaten = newEatingValue;
    }    

    /**
     * Used to set the current speed of the animal to the current speed.
     */
    public void resetSpeed()
    {
        setSpeed(getBaseSpeed());
    }

    /**
     * Changes the current speed of the dinosaur. This value is different for every subclass of weather.
     */
    public void setWeatherSpeed()
    {
        setSpeed(getSpeed()*(getWeather().getSpeedChange()));
    }
    
    // abstract methods below

    public void takeDisease(){}

    abstract public boolean instance(Dinosaurs dino);

    abstract public int getBreedingAge();

    abstract public int getMaxLitterSize();

    abstract public double getBreedingProbability();

    abstract public int getFoodValue();

    abstract public int getMaxBreeding();

    abstract public int getMaxEating();

    abstract public double getBaseSpeed();

    abstract public void setBaseSpeed(double newBase);
}
