
/**
 * Morning, inherits from TimeOfDay
 *
 * @author Shozab Anwar Siddique & Krishna Prasanna Kumar
 * @version 1
 */
public class Morning extends TimeOfDay
{
    //Start and end times of the Morning
    private final static int START = 0;
    private final static int END = 5000;
    
    //Probability for weather
    private final static double SUN_PROBABILITY = 0.599;  
    private final static double RAIN_PROBABILITY = 0.4;
    private final static double METEOR_PROBABILITY = 0.001;
    /**
     * Constructor for objects of class Morning
     */
    public Morning()
    {

    }
    
    /**
     * @return Start time of this time period
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
     * Sets the weather based on probability and the current Time of Day
     */
    public Weather setWeather()
    {
        if(randomise() <= METEOR_PROBABILITY)
        {
            return (new Meteor());
        }
        else if(randomise() <= (METEOR_PROBABILITY + RAIN_PROBABILITY))
        {
            return (new Rain());
        }
        else
        {
            return (new Sun());
        }
    }
}
