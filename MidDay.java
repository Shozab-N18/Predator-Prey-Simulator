
/**
 * MidDay Inherits from TimeOfDay
 *
 * @author Shozab Anwar Siddique & Krishna Prasanna Kumar
 * @version 1
 */
public class MidDay extends TimeOfDay
{
    //Start and End times of MidDay
    private final static int START = 5000;
    private final static int END = 7000;
    
    //Probability of the weather during this Time of day
    private final static double SUN_PROBABILITY = 0.4;
    private final static double RAIN_PROBABILITY = 0.6;

    /**
     * Constructor for objects of class Morning
     */
    public MidDay()
    {

    }

     /**
     * @return The start time of MidDay
     */
    public int getStartTime(){
        return START;
    }

     /**
     * @return The end time of MidDay
     */
    public int getEndTime(){
        return END;
    }

     /**
     * Set the weather based on the probability
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
