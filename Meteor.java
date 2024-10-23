
/**
 * Meteor Class Inherits from Weather
 * Rare weather that causes a lot of the organisms to die.
 *
 * @author Shozab Anwar Siddique & Krishna Prasanna Kumar
 * @version 1
 */
public class Meteor extends Weather
{
    private static final double SPEED_CHANGE = 0.0000004; //Speed change based on the weather

    private static final int SUNLIGHT_LEVEL = 70;
    private static final int WATER_LEVEL = 10;

    /**
     * Constructor for objects of class Meteor
     */
    public Meteor()
    {
        
    }

    /**
     * @return The Speed change based on the weather.
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
