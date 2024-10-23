/**
 *  Canker inherits from Disease
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Canker implements Disease
{
    /**
     * Constructor for objects of class Canker
     */
    public Canker()
    {
        
    }

    /**
     * @return The death rate of the disease.
     */
    public double getDeathRate(){
        return 0;
    }

    /**
     * @return The recovery rate of the disease.
     */
    public double getRecoveryRate()
    {
        return 0.005;
    }
    
    /**
     * The slow down rate on the organism by the disease.
     */
    public double getSlowRate(){
        return 1.0;
    }
    
    /**
     * @return Boolean, true if the Organism can catch the disease.
     */
    public boolean checkAnimal(Organism organism)
    {
        return organism instanceof Producer;
    }
}