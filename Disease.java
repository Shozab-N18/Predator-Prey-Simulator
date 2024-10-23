
/**
 * Disease Interface which holds abstract methods for all diseases.
 *  
 * @author Shozab Anwar Siddique & Krishna Prasanna Kumar
 * @version 1
 */
public interface Disease
{
    // Abstract Methods below.
    
    boolean checkAnimal(Organism organism);

    double getDeathRate();

    double getRecoveryRate();

    double getSlowRate();
}
