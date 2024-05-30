package barbiegame;

import java.util.Random;
/**
 * This class represents a Zombie.
 * Zombie can move and target a given Entity it they are close enough to Zombie.
 * Zombie can determine if they are adjacent to or at the same location as an entity.
 * @author Peter MacAulay
 * @version APril 20, 2024
 */
public class Zombie extends Entity{

    //instance variables
    private int gridLength;
    private int targetRadius;
    private final int SCALE_FACTOR = 5;
    private final double RANDOM_X_MODIFIER = 0.4;
    private final double RANDOM_Y_MODIFIER = 0.7;
    private final int RANDOM_X_Y_BOUND = 3;
    private final int ONE = 1;
    private final int ZERO = 0;
    private Random random;
    
    /**
     * Constructor for Zombie
     * calls the superclass constructor.
     * sets the grid length.
     * determines the target radius based on grid length
     * @param grid
     * @param barbie
     */
    public Zombie(IGrid grid){
        super(grid, new Random());
        random = new Random();
        gridLength = grid.getSideLength();
        targetRadius = gridLength / SCALE_FACTOR;
    } 
    
    /**
     * This is a move method for Zombie objects.
     * Zombies can target an Entity using its location if it is close enough.
     * Zombies can only move in one direction at a time.
     */
    public void move(Entity entity) {
        int targetX = entity.getXPosition();
        int targetY = entity.getYPosition();
    
        int newX = targetX - getXPosition();
        int newY = targetY - getYPosition();
    
        boolean withinRange = isWithinRange(newX, newY);
    
        if (withinRange) {
            moveTowardsBarbie(newX, newY);
        } else {
            moveRandomly();
        }
    }
    
    /**
     * determines if the Entity is within the targetRadius of Zombie
     * @param newX -distance from Entity in x direction
     * @param newY -distance from Entity in y direction
     * @return if Zombie is within targetRadius of Entity
     */
    private boolean isWithinRange(int newX, int newY) {
        return Math.abs(newX) <= targetRadius && Math.abs(newY) <= targetRadius;
    }
    
    /**
     * moves Zombie in either an x or y direction towards the Entity
     * or does nothing at all.
     * @param newX -distance from Entity in x direction
     * @param newY -distance from Entity in y direction
     */
    private void moveTowardsBarbie(int newX, int newY) {
        // Randomly choose whether to move in the X or Y direction or nothing at all
        if (random.nextDouble() < RANDOM_X_MODIFIER) {
            // Move in the X direction
            if (newX != ZERO) {
                // Move one step closer to Barbie in the X direction, within grid bounds
                setXPosition(Math.max(ZERO, Math.min(getXPosition() + Integer.compare(newX, ZERO), gridLength - ONE)));
            }
        } else if (random.nextDouble() > RANDOM_Y_MODIFIER) {
            // Move in the Y direction
            if (newY != ZERO) {
                // Move one step closer to Barbie in the Y direction, within grid bounds
                setYPosition(Math.max(0, Math.min(getYPosition() + Integer.compare(newY, ZERO), gridLength - ONE)));
            }
        }
    }
    
    /**
     * Moves the Zombie randomly in either x or y direction
     */
    private void moveRandomly() {
        // If Barbie is not within range, randomly choose whether to move in X or Y direction
        if (random.nextBoolean()) {
            // Move in the X direction
            int randomX = random.nextInt(RANDOM_X_Y_BOUND) - ONE; // Random value between -1, 0, 1
            int newXPosition = Math.max(ZERO, Math.min(getXPosition() + randomX, gridLength - ONE));
            setXPosition(newXPosition);
        } else {
            // Move in the Y direction
            int randomY = random.nextInt(RANDOM_X_Y_BOUND) - ONE; // Random value between -1, 0, 1
            int newYPosition = Math.max(ZERO, Math.min(getYPosition() + randomY, gridLength - ONE));
            setYPosition(newYPosition);
        }
    }

    /**
     * checks to see if an Entity object interacts with a zombie and 
     * @return damage- whether the Zombie should do damage or not
     */
    public boolean zombieDamageCheck(Entity entity){

        //set damage to false by default
        boolean damage = false;

        //if Barbie's x and y equal the given zombie's x and y
        if(entity.getXPosition() == getXPosition() && entity.getYPosition() == getYPosition()){
            damage = true;
        }
        //if barbie is to the left of a zombie
        else if(entity.getXPosition() + 1 == getXPosition() && entity.getYPosition() ==  getYPosition()){
            damage = true;
        }
        //if barbie is to the right of a zombie
        else if(entity.getXPosition() -1 == getXPosition() && entity.getYPosition() ==  getYPosition()){
            damage = true;
        } 
        //if barbie is above a zombie
        else if(entity.getYPosition() + 1 ==  getYPosition() && entity.getXPosition() == getXPosition()){
            damage = true;
        }
        //if barbie is below a zombie   
        else if(entity.getYPosition() - 1 ==  getYPosition() && entity.getXPosition() == getXPosition()){
            damage = true;
        }

        //return whether the Zombie shoudl do damage or not
        return damage;
    }

    /**
     * gets the x positions
     * @return xPosition
     */
    @Override
    public int getXPosition() {
        return super.getXPosition();
    }

    /**
     * gets the y positions
     * @return yPosition
     */
    @Override
    public int getYPosition() {
        return super.getYPosition();
    }

    /**
     * sets the x position
     */
    @Override
    public void setXPosition(int newX) {
        super.setXPosition(newX);
    }

    /**
     * sets the x position
     */
    @Override
    public void setYPosition(int newY) {
        super.setYPosition(newY);
    }

    @Override
    void accept(EntityVisitor visitor) {
        visitor.visit(this);
    }
}
