import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Write a description of class Secondary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Secondary extends Dinosaurs
{
    /**
     * Constructor for objects of class Secondary
     */
    public Secondary()
    {
        
    }

    /**
     * Look for prey adjacent to the current location.
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
            if(organism instanceof Primary && (getMaxEating() > getNumberEaten())) {
                if(organism.isAlive()) { 
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
            
            if(organism instanceof Secondary && organism.getDisease() != null ) {
                if(rand.nextDouble() <= 1){
                    setDisease(organism.getDisease());
                    return;
                }
            }
        }
    }

    abstract public int getMaxAge();

    abstract public int getFoodValue();

    abstract public double getBreedingProbability();

    abstract public int getMaxLitterSize();

    abstract public int getBreedingAge();

    abstract public boolean instance(Dinosaurs dino);

    abstract public int getMaxBreeding();

    abstract public int getMaxEating();

    abstract public double getBaseSpeed();
}
