package barbiegame;

import java.util.Random;
/**
 * This class represents a pear entity.
 * the pear can determine if a given 
 * Entity has interacted with it.
 * @author Peter MacAulay
 * @version April 20, 2024
 */
public class Pear extends Entity{

    /**
     * Pear constructor.
     * calls the superclass constructor.
     * @param grid
     */
    public Pear(IGrid grid) {
        super(grid, new Random());
    }

    /**
     * returns the x positions
     * @return xPosition
     */
    @Override
    public int getXPosition() {
        return super.getXPosition();
    }

    /**
     * returns the y positions
     * @return yPosition
     */
    @Override
    public int getYPosition() {
        return super.getYPosition();
    }

    /**
     * sets the x positon
     */
    @Override
    public void setXPosition(int newX) {
        super.setXPosition(newX);
    }

    /**
     * sets the y positon
     */
    @Override
    public void setYPosition(int newY) {
        super.setYPosition(newY);
    }

    /**
     * checks to see if Entity interacts with pear
     * @return true if pear should be collected, else false
     */
    public boolean pearCollectCheck(Entity entity){
        if(super.getXPosition() == entity.getXPosition() && super.getYPosition() == entity.getYPosition()){
            return true;
        }
        return false;
    }

    @Override
    void accept(EntityVisitor visitor) {
        visitor.visit(this);
    }


}
