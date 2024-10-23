
/**
 * Sun Inherits from Weather
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Sun extends Weather
{
    private static final double SPEED_CHANGE = 1.0; //Speed Change based on the weather

    private static final int SUNLIGHT_LEVEL = 80;
    private static final int WATER_LEVEL = 10;

    /**
     * Constructor for objects of class Sun
     */
    public Sun()
    {
        
    }

    /**
     * @return The speed change based on the weather.
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
