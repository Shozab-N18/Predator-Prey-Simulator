
/**
 * Write a description of class Weather here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Weather
{
    /**
     * Constructor for objects of class Weather
     */
    public Weather()
    {
        // initialise instance variables
    }
    
    public String toString(){
        Class test = this.getClass();
        return test.getName();
    }
    
    abstract public double getSpeedChange();
    
    abstract public int getWaterLevel();
    
    abstract public int getSunlightLevel();
}
