import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * A class representing shared characteristics of organism.
 * 
 * @author David J. Barnes, Michael Kölling, Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 2016.02.29 (2)
 */
public abstract class Organism
{
    // A shared random number generator.
    protected static final Random rand = Randomizer.getRandom();

    // Whether the organism is alive or not.
    private boolean alive;
    // The organism's field.
    private Field field;
    // The organism's position in the field.
    private Location location;

    // The age of the organism.
    private int age;
    //The food level of the organism.
    private int foodLevel;// may change later
    //Used to determine time till the organism's event.
    private long timeLastActed;
    //The disease organism has.
    private Disease disease;
    //Used to set the time at which an organism sleeps.
    private TimeOfDay timeOfDay;
    //Used to set weather during which any particular action is to be performed.
    private Weather currentWeather;
    
    private List<Disease> immuneDiseases;
    /**

     * Create a new organism at location in field. Initiate appropriate food levels and age. 
     * 
     */
    public Organism()
    {
        alive = true;        
        age = 0;
        foodLevel = getFoodValue();
        timeLastActed = System.currentTimeMillis();// time of organism's creation
        immuneDiseases = new ArrayList();
    }

    /**
     * Generates a random age and food level. Used in the populate() method in Simulator.
     */
    protected void setRandomly(){
        age = rand.nextInt(getMaxAge());
        foodLevel = rand.nextInt(1000);//use get foodvalue
    }

    /**
     * Increase the age. This could result in the organism's death.
     */
    protected void incrementAge()
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }

    /**
     * Make this organism more hungry. This could result in the organism's death.
     */
    protected void incrementHunger()
    {
        foodLevel -= 5;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    /**
     * Look for food adjacent to the current location.
     * Only the first live food found is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    public Location findFood()
    {
        return null;
    }

    /**
     * Changes the timeLastActed field. Used in act(List<Organism> newFoxes) to set the time to 
     * current system time after the act method is called. 
     * @param newTime the new time value.
     */
    protected void setTime(long newTime)
    {
        timeLastActed = newTime;
    }

    /**
     * Returns the time that the organism has last acted.
     * @return timeLastActed
     */
    protected long getTime()
    {
        return timeLastActed;
    }

    /**
     * Set the time of day to a TimeOfDay object.
     * @param dayTime the object that is to be set to timeOfDay field.
     */
    protected void setSleepTime(TimeOfDay dayTime)
    {
        timeOfDay = dayTime;
    }

    /**
     * @return Name of timeOfDay class
     */
    protected Class getSleepTime()
    {
        return timeOfDay.getClass();
    }

    /**
     * Kills an organism or removes its disease according to their respective probabilities
     */
    protected void checkDeathByDisease(){
        if(getDisease() == null){
            return;
        }
        //double num = rand.nextDouble();
        if(rand.nextDouble() <= getDisease().getDeathRate()){
            setDead();
        }
        else if(rand.nextDouble() <= getDisease().getRecoveryRate())
        {
            setDisease(null);
            immuneDiseases.add(getDisease());
        }
    }

    /**
     * Check whether the organism is alive or not.
     * @return true if the organism is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the organism is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the organism's location.
     * @return The organism's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the organism at the new location in the given field.
     * @param newLocation The organism's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Return the organism's field.
     * @return The organism's field.
     */
    protected Field getField()
    {
        return field;
    }

    /**
     * Sets the input disease to this organism.
     * @param disease
     */
    public void setDisease(Disease disease){
        disease = disease;
    }

    /**
     * Return's the disease that the current.
     * @return disease.
     */
    public Disease getDisease(){
        return disease;
    }

    /**
     * Sets the current weather to the input weather
     * @param The weather to be set
     */
    public void setWeather(Weather weather){
        currentWeather = weather;
    }

    /**
     * Return's the current weather
     * @return currentWeather.
     */
    protected Weather getWeather()
    {
        return currentWeather;
    }

    /**
     * Used to set the field of a new organism object.
     * @param newField 
     */
    public void setField(Field newField){
        field = newField;
    }

    /**
     * Return age of the organism.
     * @return age 
     */
    protected int getAge(){
        return age;
    }

    /**
     * Set the age of an organism to a certain value.
     * @param newAge
     */
    protected void setAge(int newAge){
        age = newAge;
    }

    /**
     * Return's the food level of the organism.
     * @return foodLevel
     */
    protected int getFoodLevel(){
        return foodLevel;
    }

    /**
     * Set food value to input amount.
     * @param newFoodLevel
     */
    protected void setFoodLevel(int newFoodLevel){
        foodLevel = newFoodLevel;
    }

    /**
     * Return list of immune diseases.
     * @ immuneDiseases
     */
    protected List<Disease> getImmuneDiseases(){
        return immuneDiseases;
    }
    
    /**
     * Return's whether or not the current organism is immune from the disease that it would catch from eating the prey.
     * @return boolean 
     */
    public boolean isImmune(Organism organism){
        List<Disease> immuneDiseases = getImmuneDiseases();
        for(int i = 0; i < immuneDiseases.size(); i++){
            if(immuneDiseases.get(i).getClass() == organism.getDisease().getClass()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Overriden in primary,secondary,tertiary classes.
     */
    public void takeDisease(){}
    
    // abstract methods below
    
    abstract public int getMaxAge();

    abstract public int getFoodValue();

    abstract public void act(List<Organism> newOrganism);
}
