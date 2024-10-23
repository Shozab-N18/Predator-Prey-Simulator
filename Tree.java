import java.util.List;

/**
 * A simple model of a Triceratops.
 * Triceratops age, move, eat rabbits, and die.
 * 
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Tree extends Producer
{
    // The age to which a Tree can live.
    private static final int MAX_AGE = 1000000;
    // The rate at which the tree ages.
    private static final double TREE_GROWTH_RATE = 0.7;
    //The age at which a tree can be eaten by another organism.
    private static final int EATABLE_AGE = 3;
    //The maximum water level.
    private static final int MAX_WATER_LEVEL = 300;
    //The maximum sunlight level.
     private static final int MAX_SUNLIGHT_LEVEL = 300;
    /**
     * Constructor for objects of class Grass
     */
    public Tree()
    {
        
    }
    
    /**
     * The max age of the Tree.
     * @return int
     */
    public int getMaxAge(){
        return MAX_AGE;
    }
    
    /**
     * Return's the growth rate of the Tree.
     * @return double
     */
    public double getGrowthRate(){
        return TREE_GROWTH_RATE;
    }
    
    /**
     * Return's the age at which the plant can be eaten.
     * @return int
     */
    public int getEatableAge(){
        return EATABLE_AGE;
    }
    
    /**
     * Return's the maximum water level for a tree.
     * @return int
     */
    public int getMaxWaterLevel()
    {
        return MAX_WATER_LEVEL;
    }
    
    /**
     * Return's the maximum sunlight level of a tree.
     * @return int
     */
    public int getMaxSunlightLevel()
    {
        return MAX_SUNLIGHT_LEVEL;
    }
}
