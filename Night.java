
/**
 * Night Inherits from TimeOfDay
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Night extends TimeOfDay
{
    //Start and end time of the Night
    private final static int START = 10000;
    private final static int END = 15000;
    
    //Probability for weather during the night
    private final static double SNOW_PROBABILITY = 0.45;
    private final static double RAIN_PROBABILITY = 0.55;
    
    
    /**
     * Constructor for objects of class Morning
     */
    public Night()
    {

    }
    
    /**
     * @return The Start time of the night
     */
    public int getStartTime(){
        return START;
    }
    
    /**
     * @return The End time of the night
     */
    public int getEndTime(){
        return END;
    }
    

    /**
     * Sets the weather based on probability
     */
    public Weather setWeather()
    {
        if(randomise() <= SNOW_PROBABILITY)
        {
            return (new Snow());
        }
        else
        {
            return (new Rain());
        }
    }
}
