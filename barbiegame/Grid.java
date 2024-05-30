package barbiegame;

import java.util.ArrayList;

/**
 * The class represents a grid that can be used 
 * to display the locations of entites.
 * Holds a side length.
 * @author Peter MacAulay
 * @version April 20, 2024
 */


public class Grid implements IGrid{

    //instance variables
    private int sideLength;

    /**
     * Constructor for Grid class.
     * sets side length
     * @param sideLength
     */
    public Grid(int sideLength){
        this.sideLength = sideLength;
    }

    /**
     * gets the side legnth of the grid
     * @return int
     */
    @Override
    public int getSideLength(){
        return sideLength;
    }

     /**
     * displays the location of all entities in the grid
     */
    @Override
    public void displayGrid(ArrayList<Entity> entities) {
        boolean entityFound = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sideLength; i++) {
            sb.append("\n");
            for (int j = 0; j < sideLength; j++) {
                entityFound = false;
                sb.append("[");

                RenderVisitor visitor = new RenderVisitor();
                for (Entity entity : entities) {
                    if (entity.getXPosition() == j && entity.getYPosition() == i) {
                        entity.accept(visitor);
                        entityFound = true;
                    }
                }
                if (!entityFound) {
                    sb.append(" ");
                } else {
                    sb.append(visitor.getResult());
                }
                sb.append("]");
            }
        }
        System.out.println(sb.toString());
    }
}
