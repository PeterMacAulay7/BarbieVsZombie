package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import barbiegame.Barbie;
import barbiegame.Grid;
import barbiegame.IGrid;

public class BarbieTest {

    @Test
    public void testGetAndSetHealth() {
        IGrid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        int newHealth = 80;
        barbie.setHealth(newHealth);

        assertEquals(newHealth, barbie.getHealth());
    }

    @Test
    public void testMove() {
        Grid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);

        //reset position
        barbie.setXPosition(4);
        barbie.setYPosition(4);
        int initialX = barbie.getXPosition();
        int initialY = barbie.getYPosition();

        barbie.move("d"); // Move right
        int newX = barbie.getXPosition();
        int newY = barbie.getYPosition();

        assertEquals(initialX + 1, newX);
        assertEquals(initialY, newY);

        //reset position
        barbie.setXPosition(4);
        barbie.setYPosition(4);
        initialX = barbie.getXPosition();
        initialY = barbie.getYPosition();

        barbie.move("a"); // Move left
        newX = barbie.getXPosition();
        newY = barbie.getYPosition();

        assertEquals(initialX - 1, newX);
        assertEquals(initialY, newY);

        //reset position
        barbie.setXPosition(4);
        barbie.setYPosition(4);
        initialX = barbie.getXPosition();
        initialY = barbie.getYPosition();

        barbie.move("w"); // Move up
        newX = barbie.getXPosition();
        newY = barbie.getYPosition();

        assertEquals(initialX, newX);
        assertEquals(initialY - 1, newY);

        //reset position
        barbie.setXPosition(4);
        barbie.setYPosition(4);
        initialX = barbie.getXPosition();
        initialY = barbie.getYPosition();

        barbie.move("s"); // Move down
        newX = barbie.getXPosition();
        newY = barbie.getYPosition();

        assertEquals(initialX, newX);
        assertEquals(initialY + 1, newY);
    }

    @Test
    public void testCollectPear() {
        Grid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        int initialPears = barbie.getCollectedPears();

        barbie.collectPear();
        
        assertEquals(initialPears + 1, barbie.getCollectedPears());
    }

    @Test
    public void testEdgeMovement(){
        Grid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);

        //Test moving past right edge
        barbie.setXPosition(10);
        barbie.move("d");
        //barbie should not have moved
        assertEquals(barbie.getXPosition(), 10);

        //Test moving past left edge
        barbie.setXPosition(0);
        barbie.move("a");
        //barbie should not have moved
        assertEquals(barbie.getXPosition(), 0);

        //Test moving past top edge
        barbie.setYPosition(0);
        barbie.move("w");
        //barbie should not have moved
        assertEquals(barbie.getYPosition(), 0);

        //Test moving past bottom edge
        barbie.setYPosition(10);
        barbie.move("s");
        //barbie should not have moved
        assertEquals(barbie.getYPosition(), 10);
    }
}

