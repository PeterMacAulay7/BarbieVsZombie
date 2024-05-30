package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import barbiegame.Barbie;
import barbiegame.Grid;
import barbiegame.Pear;
import barbiegame.Zombie;

public class GridTest {

    @Test
    public void testGetSideLength() {
        Grid grid = new Grid(10);
        assertEquals(10, grid.getSideLength());
    }

    /**
     * tests to see if all entities show up on the grid
     */
    @Test
    public void testDisplayGrid(){
        Grid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        Zombie zombie = new Zombie(grid);
        Pear pear = new Pear(grid);

        barbie.setXPosition(5);
        barbie.setYPosition(5);

        zombie.setXPosition(6);
        zombie.setYPosition(6);

        pear.setXPosition(2);
        pear.setYPosition(2);

        assertEquals(barbie.getXPosition(), 5);
        assertEquals(barbie.getYPosition(), 5);

        assertEquals(zombie.getXPosition(), 6);
        assertEquals(zombie.getYPosition(), 6);

        assertEquals(pear.getXPosition(), 2);
        assertEquals(pear.getYPosition(), 2);
    }
}

