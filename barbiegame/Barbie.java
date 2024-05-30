package barbiegame;

import java.util.Random;

/**
 * This class represents a Barbie.
 * Barbie can move in the direction given.
 * Barbie's health can be set and returned
 * @author Peter MacAulay
 * @version April 20,2024
 */
public class Barbie extends Entity{
    //instance variables
    private int health;
    private int gridLength;
    private int collectedPears;
    private final int ONE_ADJUSTMENT = 1;
    private final int DEFAULT_HEALTH = 100;
    private final int DEFAULT_COLLECTED_PEARS = 0;
    private final int ZERO = 0;

    
    /**
     * Barbie constructor.
     * sets width and height to grid width and height.
     * assigns collectedPears to 0
     */
    public Barbie(IGrid grid){
        super(grid, new Random());
        gridLength = grid.getSideLength() - ONE_ADJUSTMENT;
        collectedPears = DEFAULT_COLLECTED_PEARS;
        setHealth(DEFAULT_HEALTH);
    }

    /**
     * gets Barbie health value
     * @return int
     */
    public int getHealth(){
        return health;
    }

    /**
     * sets Barbie health value
     * @param health
     */
    public void setHealth(int health){
        this.health = health;
    }

    /**
     * Specialized movement method for Barbie.
     * takes in direction form the user.
     * Barbie can go left, right, up, or down
     * @param direction
     */
    public void move(String direction){
        
        //move left
        if(direction.equals("a")){
            if((getXPosition() - ONE_ADJUSTMENT)>= ZERO){
                setXPosition( getXPosition() - ONE_ADJUSTMENT);
            }
        }

        //move right
        else if(direction.equals("d")){
            if((getXPosition() + ONE_ADJUSTMENT)<= gridLength){
                setXPosition( getXPosition() + ONE_ADJUSTMENT);
            }
        }

        //move up
        else if(direction.equals("w")){
            if((getYPosition() - ONE_ADJUSTMENT) >= 0){
                setYPosition( getYPosition() - ONE_ADJUSTMENT);
            }
        }        

        //move down
        else if(direction.equals("s")){
            if((getYPosition() + ONE_ADJUSTMENT) <= gridLength){
                setYPosition( getYPosition() + ONE_ADJUSTMENT);
            }
        }        
        else{
            //Enter a valid direction
            System.out.println("Please enter a valid direction");
        }
    }

    /**
     * gets number of collected pears
     * @return int
     */
    public int getCollectedPears(){
        return collectedPears;
    }

    /**
     * adds one to collectedPears when called
     */
    public void collectPear(){
        collectedPears++;
    }

    /**
     * gets the x positons
     * @return x position
     */
    @Override
    public int getXPosition() {
        return super.getXPosition();
    }

    /**
     * gets the y positons
     * @return y position
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
     * sets the y position
     */
    @Override
    public void setYPosition(int newY) {
        super.setYPosition(newY);
    }

    /**
     * changes the health of Barbie by the given amount
     * @param healthAddition -amount to be added to Barbies health
     */
    public void changeHealthBy(int healthAddition){
        health += healthAddition;
    }

    @Override
    void accept(EntityVisitor visitor) {
        visitor.visit(this);
    }
    

}

