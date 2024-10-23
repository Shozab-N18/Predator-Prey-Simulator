/**
 * A simple model of a Triceratops.
 * Triceratops age, move, eat rabbits, and die.
 * 
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Grass extends Producer
{
    // The age to which a Grass can live.
    private static final int MAX_AGE = 1000000;
    // The rate at which the Grass ages.
    private static final double Grass_GROWTH_RATE = 0.7;
    //The age at which a Grass can be eaten by another organism.
    private static final int EATABLE_AGE = 3;
    //The maximum water level.
    private static final int MAX_WATER_LEVEL = 300;
    //The maximum sunlight level.
     private static final int MAX_SUNLIGHT_LEVEL = 300;
    /**
     * Constructor for objects of class Grass
     */
    public Grass()
    {
        
    }
    
    /**
     * The max age of the Grass.
     * @return int
     */
    public int getMaxAge(){
        return MAX_AGE;
    }
    
    /**
     * Return's the growth rate of the Grass.
     * @return double
     */
    public double getGrowthRate(){
        return Grass_GROWTH_RATE;
    }
    
    /**
     * Return's the age at which the plant can be eaten.
     * @return int
     */
    public int getEatableAge(){
        return EATABLE_AGE;
    }
    
    /**
     * Return's the maximum water level for a Grass.
     * @return int
     */
    public int getMaxWaterLevel()
    {
        return MAX_WATER_LEVEL;
    }
    
    /**
     * Return's the maximum sunlight level of a Grass.
     * @return int
     */
    public int getMaxSunlightLevel()
    {
        return MAX_SUNLIGHT_LEVEL;
    }
}
