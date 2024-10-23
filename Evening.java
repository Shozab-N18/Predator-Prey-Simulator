import java.util.ArrayList;

/**
 * Evening inherits from TimeOfDay
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Evening extends TimeOfDay
{
    //Start and End time of the Evening
    private final static int START = 7000;
    private final static int END = 10000;
    
    //Probability for Weather
    private final static double SUN_PROBABILITY = 0.4;
    private final static double RAIN_PROBABILITY = 0.6;

    /**
     * Constructor for objects of class Morning
     */
    public Evening()
    {

    }
    
    
    /**
     * @return Start time of this time period.
     */
    public int getStartTime(){
        return START;
    }
    
    /**
     * @return End time of this time period
     */
    public int getEndTime(){
        return END;
    }
    
    
    /**
     * Sets the weather based on the current weather and probability
     */    
    public Weather setWeather()
    {
        if(randomise() <= SUN_PROBABILITY)
        {
            return (new Sun());
        }
        else
        {
            return (new Rain());
        }
    }

}
