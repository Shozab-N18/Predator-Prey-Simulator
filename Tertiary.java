import java.util.List;
import java.util.Iterator;
/**
 * Write a description of class Predator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Tertiary extends Dinosaurs
{
    /**
     * Constructor for objects of class Tertiary
     */
    public Tertiary()
    {
        
    }

    /**
     * Look for prey adjacent to the current location of the organism.
     * Only the first live prey found is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    public Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Organism organism = (Organism) field.getObjectAt(where);
            if((organism instanceof Secondary || organism instanceof Primary) && (getMaxEating() > getNumberEaten())) {
                if(organism.getDisease() instanceof Cholera && !isImmune(organism)){
                    setDisease(new Cholera());
                }
                
                if(organism.isAlive()){ 
                    incrementNumberEaten();
                    setFoodLevel(organism.getFoodValue());
                    organism.setDead();
                    return where;
                }
            }
        }
        return null;
    }

    /**
     * Get's the disease from an nearby animal and determines if the current animal 
     * should get it aswell.
     */
    public void takeDisease(){
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Organism organism = (Organism) field.getObjectAt(where);
            
            if(isImmune(organism) == true){
                return;
            }
            
            if(organism instanceof Tertiary && organism.getDisease() != null ) {
                if(rand.nextDouble() <= 0.1){
                    setDisease(organism.getDisease());
                    return;
                }
            }
        }
    }
    
    //abtract methods below
    
    abstract public int getMaxAge();

    abstract public int getFoodValue();

    abstract public double getBreedingProbability();

    abstract public int getMaxLitterSize();

    abstract public int getBreedingAge();
    
    abstract public int getMaxBreeding();
    
    abstract public int getMaxEating();
    
    abstract public boolean instance(Dinosaurs dino);
    
    abstract public double getBaseSpeed();
}
