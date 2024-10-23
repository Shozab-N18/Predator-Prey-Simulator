import java.util.List;
import java.util.Iterator;
/**
 * Write a description of class Prey here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Primary extends Dinosaurs
{
    /**
     * Constructor for objects of class Primary
     */
    public Primary()
    {
        
    }

    /**
     * Look for Producers adjacent to the current location of the dinosaur.
     * Only the first producer is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    public Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Organism organism= (Organism) field.getObjectAt(where);
            if(organism instanceof Producer ){
                Producer producer = (Producer) organism;
                if(organism.getAge() > producer.getEatableAge() && getMaxEating() > getNumberEaten()){
                    if(producer.getDisease() != null && !isImmune(organism)){
                        setDisease(new Covid());
                    }
                    incrementNumberEaten();
                    setFoodLevel(organism.getFoodValue());
                    producer.setAge(0);
                    producer.setGlucose(350);
                    return null;
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
            
            if(organism instanceof Primary && organism.getDisease() != null ) {
                if(rand.nextDouble() <= 0.1){
                    setDisease(organism.getDisease());
                    return;
                }
            }
        }
    }

    // abstract methods below
    
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
