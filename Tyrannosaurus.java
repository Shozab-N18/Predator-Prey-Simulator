/**
 * A simple model of a Tyrannosaurus.
 * T-Rex age, move, eat prey, and die.
 * 
 * @author David J. Barnes, Michael Kölling, Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 2016.02.29 (2)
 */
public class Tyrannosaurus extends Tertiary
{
    // The age at which a Tyrannosaurus can start to breed.
    private static final int BREEDING_AGE = 300;
    // The age to which a Tyrannosaurus can live.
    private static final int MAX_AGE = 2000;
    // The likelihood of a Tyrannosaurus breeding.
    private static final double BREEDING_PROBABILITY = 0.25;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of that the Tyrannosaurus gets from eating an organism. 
    // In effect, this is the number of steps a Tyrannosaurus can go before it has to eat again.
    private static final int FOOD_VALUE = 150;
    // The maximum breeding of a Tyrannosaurus.
    private static final int MAX_BREEDING = 3;
    // The maximum eating of a Tyrannosaurus.
    private static final int MAX_EATING = 3;
    // The base speed of a Tyrannosaurus.
    private double baseSpeed = 220;

    /**
     * Create a Tyrannosaurus. A Tyrannosaurus is created as a new born (age zero
     * and not hungry).
     */
    public Tyrannosaurus()
    {
        resetSpeed(); 
        setSleepTime(new Evening());
    }

    /**
     * The max age of the Tyrannosaurus.
     * @return int
     */
    public int getMaxAge(){
        return MAX_AGE;
    }

    /**
     * The food Value of the Tyrannosaurus.
     * @return int
     */
    public int getFoodValue(){
        return FOOD_VALUE;
    }

    /**
     * The breeding probability of the Tyrannosaurus.
     * @return double
     */
    public double getBreedingProbability(){
        return BREEDING_PROBABILITY;
    }

    /**
     * The max litter size of the Tyrannosaurus.
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
     * The maximum amount of times that the Tyrannosaurus can breed.
     * @return int
     */
    public int getMaxBreeding(){
        return MAX_BREEDING;
    }
    
    /**
     * Return whether the parameter is of the type Tyrannosaurus.
     * @param dino
     * @return boolean 
     */
    public boolean instance(Dinosaurs dino)
    {
        return dino instanceof Tyrannosaurus;
    }
    
    /**
     * Return's the base speed of the Tyrannosaurus.
     * @return double
     */
    public double getBaseSpeed()
    {
        return baseSpeed;
    }

    /**
     * Set the base speed of the Tyrannosaurus to a certain value.
     * @param newBase
     */
    public void setBaseSpeed(double newBase)
    {
        baseSpeed = newBase;
    }
}
