package barbiegame;

import java.util.Random;

/**
 * This is the parent class for all entities in the game.
 * ex: Barbie, Zombie, and Pear.
 * This class could also be used for future entities.
 * @author Peter MacAulay
 * @varsion April 20, 2024
 */

public abstract class Entity{
    private int xPosition;
    private int yPosition;

    public Entity(IGrid grid, Random random){
        xPosition = random.nextInt(grid.getSideLength());
        yPosition = random.nextInt(grid.getSideLength());
    }

    /**
     * gets x vlaue
     * @return int
     */
    public int getXPosition(){
        return xPosition;
    }

    /**
     * gets y value
     * @return int
     */
    public int getYPosition(){
        return yPosition;
    }

    /**
     * sets x value
     * @param newX
     */
    public void setXPosition(int newX){
        xPosition = newX;
    }

    /**
     * sets y value
     * @param newY
     */
    public void setYPosition(int newY){
        yPosition = newY;
    }

    abstract void accept(EntityVisitor visitor);
}

