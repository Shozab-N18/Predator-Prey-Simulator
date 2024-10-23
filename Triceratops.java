/**
 * A simple model of a Triceratops.
 * Triceratops age, move, eat prey, and die.
 * 
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Triceratops extends Primary
{
    // The age at which a Triceratops can start to breed.
    private static final int BREEDING_AGE = 100;
    // The age to which a Triceratops can live.
    private static final int MAX_AGE = 1000;
    // The likelihood of a Triceratops breeding.
    private static final double BREEDING_PROBABILITY = 0.6;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 7;
    // The food value of that the Triceratops gets from eating an organism. 
    // In effect, this is the number of steps a Triceratops can go before it has to eat again.
    private static final int FOOD_VALUE = 450;
    // The maximum breeding of a Triceratops.
    private static final int MAX_BREEDING = 300;
    // The maximum eating of a Triceratops.
    private static final int MAX_EATING = 7;
    // The base speed of a Triceratops.
    private double baseSpeed = 50;

    /**
     * Constructor for objects of class Triceratops
     */
    public Triceratops(){
        resetSpeed();
        setSleepTime(new Night());
    }

    /**
     * The max age of the Triceratops.
     * @return int
     */
    public int getMaxAge(){
        return MAX_AGE;
    }

    /**
     * The food Value of the Triceratops.
     * @return int
     */
    public int getFoodValue(){
        return FOOD_VALUE;
    }

    /**
     * The breeding probability of the Triceratops.
     * @return double
     */
    public double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }

    /**
     * The max litter size of the Triceratops.
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
     * The maximum amount of times that the Triceratops can breed.
     * @return int
     */
    public int getMaxBreeding(){
        return MAX_BREEDING;
    }

    /**
     * Return whether the parameter is of the type Triceratops.
     * @param dino
     * @return boolean 
     */
    public boolean instance(Dinosaurs dino)
    {
        return dino instanceof Triceratops;
    }

    /**
     * Return's the base speed of the Triceratops.
     * @return double
     */
    public double getBaseSpeed()
    {
        return baseSpeed;
    }

    /**
     * Set the base speed of the Triceratops to a certain value.
     * @param newBase
     */
    public void setBaseSpeed(double newBase)
    {
        baseSpeed = newBase;
    }
}
