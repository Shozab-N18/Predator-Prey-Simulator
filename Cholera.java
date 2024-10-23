
/**
 * Cholera inherits from Disease
 * @author Krishna Prasanna Kumar & Shozab Anwar Siddique
 * @version 1
 */
public class Cholera implements Disease
{
    private static final double DEATH_RATE = 0.05; //Death rate of the disease
    private static final double RECOVERY_RATE = 0.5; //Recovery Rate of the disease
    private static final double SLOW_DOWN = 1.5; // Slow down rate caused by the disease

    /**
     * Constructor for objects of class Cholera
     */
    public Cholera()
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
     * @return Boolean, true if the organism in the parameter can catch this disease.
     */
    public boolean checkAnimal(Organism organism)
    {
        return organism instanceof Secondary || organism instanceof Tertiary;
    }
}
