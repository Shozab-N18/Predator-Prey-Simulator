import java.util.List;
import java.util.Random;

/**
 * Write a description of class Producer here.
 * 
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public abstract class Producer extends Organism
{
    //The current water level of the Producer.
    private int waterLevel;
    //The current sunlight level of the Producer.
    private int sunLightLevel;
    //The current glucose level of the producer.
    private int glucose;
    /**
     * Constructor for objects of class Producer
     */
    public Producer()
    {
        if(rand.nextDouble() <= 0.3){
            setDisease(new Canker());
        }
        setSleepTime(new Night());
        glucose = 100;
    }

    /**
     * This is what the Producer does most of the time: 
     * grows, creates its own food. 
     * @param newOrganism
     */
    public void act(List<Organism> newOrganism){
        if(rand.nextDouble() <= getGrowthRate()){
            incrementAge();
        }

        if(waterLevel >= getMaxWaterLevel()){
            waterLevel += getWeather().getWaterLevel();
        }
        
        if(sunLightLevel >= getMaxSunlightLevel()){
            sunLightLevel += getWeather().getWaterLevel();
        }

        if(waterLevel >= getMaxWaterLevel() && sunLightLevel >= getMaxSunlightLevel()){
            glucose = 400;
            sunLightLevel = sunLightLevel - 200;
            waterLevel = waterLevel - 200;
        }
    }

    /**
     * Return's the food value that an animal gets from eating a Producer.
     */
    public int getFoodValue(){
        return glucose;
    }
    
    /**
     * Set's the current glucose level to a particular value.
     * @param newGlucose
     */
    public void setGlucose(int newGlucose){
        glucose = newGlucose;
    }

    //abstract methods below
    
    abstract public double getGrowthRate();

    abstract public int getEatableAge();

    abstract public int getMaxWaterLevel();

    abstract public int getMaxSunlightLevel();
}