package barbiegame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * this class sets up and runs the Barbie vs Zombie game
 * @author Peter MacAulay
 * @version April 20, 2024
 */
public class Game {

    //instance variables
    private IGrid grid;
    private Barbie barbie; 
    private ArrayList<Pear> pears; //list of all pears
    private ArrayList<Zombie> zombies; //list of all zombies
    private ArrayList<Entity> entities; //list of all entities on grid
    private int gridLength;
    private Scanner scanner;
    private final int BARBIE_HEALTH_MODIFIER = 10; //qunatity to adjust Barbie's health by
    private boolean pearCollected;
    private boolean zombiePassed;


    /**
     * Constructor for game class
     * initializes pears, and zombies ArrayLists, as well as scanner
     */
    public Game(){
        pears = new ArrayList<>();
        zombies = new ArrayList<>();
        entities = new ArrayList<>();
        scanner = new Scanner(System.in);       
    }
    
    /**
     * plays a round of the game
     * Player can move
     * Zombies move
     * Calls update game
     */
    public void play(){

        //while there are still pears and Barbie has health points; continue the game
        while(barbie.getCollectedPears() < gridLength && barbie.getHealth()>0){

            //player gets their turn to move

            //displays possible moves for the user
            System.out.println("Enter direction using the following letters w(up), a(left), s(down), d(right): ");

            //takes in users move
            String playerAction = scanner.nextLine().toLowerCase();
            
            //calls move method in Barbie class
            barbie.move(playerAction); 

            //moves all zombies
            for(Zombie zombie: zombies){
                zombie.move(barbie);
            }

            //calls update game to update the game given new data
            updateGame();
        }

        //if Barbie still has health. Barbie wins!
        if(barbie.getHealth() > 0){
            System.out.println("You Have Won!");
        }
        else{
            //if Barbie does not have health left. Barbie loses.
            System.out.println("Barbie Has Died! :(");
        }
    }

    /**
     * Updates the game to account for any changes.
     * Calls zombieDamageCheck and pearCollectCheck on all Pears and Zombies.
     * Displays the grid.
     * Prints Barbies health and the status of collected pears compared to all pears
     */
    public void updateGame(){
        //resets pearCollected and zombiePassed
        pearCollected = false;
        zombiePassed = false;

        //checks to see if a zombie has interacted with Barbie
        for(Zombie zombie: zombies){
            if(zombie.zombieDamageCheck(barbie)){
                barbie.changeHealthBy(-BARBIE_HEALTH_MODIFIER);
                zombiePassed = true;
            }
        }

        //checks to see if Barbie has interacted with a pear
        Iterator<Pear> iterator = pears.iterator();
        while(iterator.hasNext()){
            Pear pear = iterator.next();
            if(pear.pearCollectCheck(barbie)){
                iterator.remove();
                entities.remove(pear);
                barbie.collectPear();
                barbie.changeHealthBy(BARBIE_HEALTH_MODIFIER);
                pearCollected = true;
            }
        }


        //displays the location of all entities
        grid.displayGrid(entities);

        //displays Barbie's health
        System.out.println("Barbie's health is at " + barbie.getHealth());
        System.out.println("Barbie has collected: " + barbie.getCollectedPears() + "/" + gridLength + " pears");
        
        //if zombie passed print statement
        if(zombiePassed){
            System.out.println("Barbie has lost " + BARBIE_HEALTH_MODIFIER + " health points");
        }
         //if pear collected print statement
        else if( pearCollected){
            System.out.println("Barbie has Collected a pear and gained " + BARBIE_HEALTH_MODIFIER + " health points!");
        }
    }

    /**
     * adds a Zombie to zombies ArrayList
     * @param zombie -zombie to be added to zombies
     */
    public void addZombie(Zombie zombie){
        zombies.add(zombie);
    }

    /**
     * adds a Zombie to zombies ArrayList
     * @param zombie -zombie to be added to zombies
     */
    public void addPear(Pear pear){
        pears.add(pear);
    }

    /**
     * adds a Entity to entites ArrayList
     * @param zombie enity to be added to entities
     */
    public void addEntity(Entity entity){
        entities.add(entity);
    }

    /**
     * sets the Grid variable for the game
     * @param grid to be used for entire game
     */
    public void setGrid(IGrid grid){
        this.grid = grid;
    }

    /**
     * sets Barbie variable for the game
     * @param barbie to be used for entire game
     */
    public void setBarbie(Barbie barbie){
        this.barbie = barbie;
    }

    /**
     * sets the gridLength variable
     * @param gridLength -length of game grid
     */
    public void setGridLength(int gridLength){
        this.gridLength = gridLength;
    }
}
