package barbiegame;

import java.util.ArrayList;

/**
 * Represents a grid that can hold a side length
 * and display the locations of entities on the grid
 */
public interface IGrid {

    public int getSideLength();

    public void displayGrid(ArrayList<Entity> entities);
}
