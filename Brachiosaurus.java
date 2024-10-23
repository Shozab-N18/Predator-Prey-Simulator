/**
 * A simple model of a Brachiosaurus.
 * Brachiosaurus age, move, eat prey, and die.
 * 
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Brachiosaurus extends Primary
{
    // The age at which a Brachiosaurus can start to breed.
    private static final int BREEDING_AGE = 100;
    // The age to which a Brachiosaurus can live.
    private static final int MAX_AGE = 1000;
    // The likelihood of a Brachiosaurus breeding.
    private static final double BREEDING_PROBABILITY = 0.85;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 8;
    // The food value of that the Brachiosaurus gets from eating an organism. 
    // In effect, this is the number of steps a Brachiosaurus can go before it has to eat again.
    private static final int FOOD_VALUE = 450;
    // The maximum breeding of a Brachiosaurus.
    private static final int MAX_BREEDING =300;
    // The maximum eating of a Brachiosaurus.
    private static final int MAX_EATING = 50;
    // The base speed of a Brachiosaurus.
    private double baseSpeed = 50;

    /**
     * Constructor for objects of class Brachiosaurus
     */
    public Brachiosaurus(){
        resetSpeed();
        setSleepTime(new Night());
    }

    /**
     * The max age of the Brachiosaurus.
     * @return int
     */
    public int getMaxAge(){
        return MAX_AGE;
    }

    /**
     * The food Value of the Brachiosaurus.
     * @return int
     */
    public int getFoodValue(){
        return FOOD_VALUE;
    }

    /**
     * The breeding probability of the Brachiosaurus.
     * @return double
     */
    public double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }

    /**
     * The max litter size of the Brachiosaurus.
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
     * The maximum amount of times that the Brachiosaurus can breed.
     * @return int
     */
    public int getMaxBreeding(){
        return MAX_BREEDING;
    }

    /**
     * Return whether the parameter is of the type Brachiosaurus.
     * @param dino
     * @return boolean 
     */
    public boolean instance(Dinosaurs dino)
    {
        return dino instanceof Brachiosaurus;
    }

    /**
     * Return's the base speed of the Brachiosaurus.
     * @return double
     */
    public double getBaseSpeed()
    {
        return baseSpeed;
    }

    /**
     * Set the base speed of the Brachiosaurus to a certain value.
     * @param newBase
     */
    public void setBaseSpeed(double newBase)
    {
        baseSpeed = newBase;
    }
}