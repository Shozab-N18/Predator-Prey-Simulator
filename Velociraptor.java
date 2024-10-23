/**
 * A simple model of a Velociraptor.
 * Velociraptor age, move, eat prey, and die.
 * 
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Velociraptor extends Secondary
{
    // The age at which a Velociraptor can start to breed.
    private static final int BREEDING_AGE = 300;
    // The age to which a Velociraptor can live.
    private static final int MAX_AGE = 1000;
    // The likelihood of a Velociraptor breeding.
    private static final double BREEDING_PROBABILITY = 0.41;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 3;
    // The food value of that the Velociraptor gets from eating an organism. 
    // In effect, this is the number of steps a Velociraptor can go before it has to eat again.
    private static final int FOOD_VALUE = 550;
    // The maximum breeding of a Velociraptor.
    private static final int MAX_BREEDING = 3;
    // The maximum eating of a Velociraptor.
    private static final int MAX_EATING = 3;
    // The base speed of a Velociraptor.
    private double baseSpeed = 220;

    /**
     * Constructor for objects of class Velociraptor
     */
    public Velociraptor(){
        resetSpeed();
        setSleepTime(new Morning());
    }

    /**
     * The max age of the Velociraptor.
     * @return int
     */
    public int getMaxAge(){
        return MAX_AGE;
    }

    /**
     * The food Value of the Velociraptor.
     * @return int
     */
    public int getFoodValue(){
        return FOOD_VALUE;
    }

    /**
     * The breeding probability of the Velociraptor.
     * @return double
     */
    public double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }

    /**
     * The max litter size of the Velociraptor.
     * @return int
     */
    public int getMaxLitterSize(){
        return MAX_LITTER_SIZE;
    }

    /**
     * The breeding age 
     * @return int
     */
    public int getBreedingAge(){
        return BREEDING_AGE;
    }

    /**
     * The maximum allowed of food intake.
     * @return int
     */
    public int getMaxEating(){
        return MAX_EATING;
    }

    /**
     * The maximum amount of times that the Velociraptor can breed.
     * @return int
     */
    public int getMaxBreeding(){
        return MAX_BREEDING;
    }
    
    /**
     * Return whether the parameter is of the type Velociraptor.
     * @param dino
     * @return boolean 
     */
    public boolean instance(Dinosaurs dino)
    {
        return dino instanceof Velociraptor;
    }
    
    /**
     * Return's the base speed of the Velociraptor.
     * @return double
     */
    public double getBaseSpeed()
    {
        return baseSpeed;
    }

    /**
     * Set the base speed of the Velociraptor to a certain value.
     * @param newBase
     */
    public void setBaseSpeed(double newBase)
    {
        baseSpeed = newBase;
    }
}
