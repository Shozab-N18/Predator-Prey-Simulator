
/**
 * Rain inherits from Weather
 *
 * * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Rain extends Weather
{
    private static final double SPEED_CHANGE = 0.75; //The speed change based on the weather

    private static final int SUNLIGHT_LEVEL = 10;
    private static final int WATER_LEVEL = 80; 

    /**
     * Constructor for objects of class Rain
     */
    public Rain()
    {
    }

    /**
     * @return The speed change based on the Weather
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
