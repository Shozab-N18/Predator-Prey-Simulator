
/**
 * Covid Inherits from Disease
 *
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Covid implements Disease
{
    private static final double DEATH_RATE = 0.05; //Death rate of the disease
    private static final double RECOVERY_RATE = 0.7; //Recovery rate of the disease
    private static final double SLOW_DOWN = 1.3 ; // Slow down rate on organism caused by disease
    /**
     * Constructor for objects of class Covid
     */
    public Covid()
    {

    }

    /**
     * @return The death rate of the disease.
     */
    public double getDeathRate(){
        return DEATH_RATE;
    }

    /**
     * @return The recovery rate of the disease.
     */
    public double getRecoveryRate()
    {
        return RECOVERY_RATE;
    }

    /**
     * @return The slow down rate on the organism by the disease.
     */
    public double getSlowRate(){
        return SLOW_DOWN;
    }

    /**
     * @return Boolean, true if the organism can catch the disease.
     */
    public boolean checkAnimal(Organism organism)
    {
        return organism instanceof Dinosaurs;
    }
}
