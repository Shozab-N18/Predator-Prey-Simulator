import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 * Abstract Class for the Times of Dat
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public abstract class TimeOfDay
{
    private final static long DAY_DURATION = 15000; // How long a day should last in milliseconds
    

    /**
     * Constructor for objects of class TimeOfDay
     */
    public TimeOfDay()
    {
        
    }

    /**
     * @return Duration of 1 day
     */
    public long getDurationOfDay(){
        return DAY_DURATION;
    }

    /**
     * Method to get the name of a class in String format
     */
    public String toString(){
        Class test = this.getClass();
        return test.getName();
    }

    /**
     * @return A random decimal number between 0 and 1.
     */
    protected double randomise()
    {
        Random rand = Randomizer.getRandom();
        return rand.nextDouble();
    }

    /**
     * @return Check if the current Time of day is the sleep time.
     */
    public boolean isSleepTime(Organism organism){
        return this.getClass() == (organism.getSleepTime());
    }

    /**
     * Abstract Methods below
     */
    abstract public Weather setWeather();
    abstract public int getStartTime();
    abstract public int getEndTime();
}