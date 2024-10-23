
/**
 * Snow Inherits from Weather
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Snow extends Weather
{
    private static final double SPEED_CHANGE = 2; //Speed Change due to Snow
    
    private static final int SUNLIGHT_LEVEL = 50;
    private static final int WATER_LEVEL = 60;
    
    /**
     * Constructor for objects of class Snow
     */
    public Snow()
    {
        
    }

    /**
     * @return The Speed Change based on the Weather
     */
    public double getSpeedChange()
    {
        return SPEED_CHANGE;
    }
    
    /**
     * @return The sunlight level during the rain. 
     */
    public int getSunlightLevel(){
        return SUNLIGHT_LEVEL;
    }

    /**
     * @return The water level during the rain.
     */
    public int getWaterLevel(){
        return WATER_LEVEL;
    }
}
