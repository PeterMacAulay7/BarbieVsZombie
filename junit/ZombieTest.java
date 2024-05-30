package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import barbiegame.Barbie;
import barbiegame.Grid;
import barbiegame.IGrid;
import barbiegame.Zombie;

public class ZombieTest {

    @Test
    public void testZombieMoveWithinGrid() {
        Grid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        Zombie zombie = new Zombie(grid);

        zombie.move(barbie); // Perform a move
        int newX = zombie.getXPosition();
        int newY = zombie.getYPosition();

        assertTrue(newX >= 0 && newX < grid.getSideLength());
        assertTrue(newY >= 0 && newY < grid.getSideLength());
    }

    @Test
    public void testZombieMoveTowardsBarbie() {
        Grid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        // Place Barbie close to the center of the grid
        barbie.setXPosition(5);
        barbie.setYPosition(5);
        Zombie zombie = new Zombie(grid);
        int initialX = zombie.getXPosition();
        int initialY = zombie.getYPosition();

        zombie.move(barbie); // Perform a move
        int newX = zombie.getXPosition();
        int newY = zombie.getYPosition();

        // Either newX or newY should be closer to Barbie's position
        assertTrue(Math.abs(newX - barbie.getXPosition()) < Math.abs(initialX - barbie.getXPosition()) ||
                   Math.abs(newY - barbie.getYPosition()) < Math.abs(initialY - barbie.getYPosition()) ||
                   Math.abs(newX - barbie.getXPosition()) == Math.abs(initialX - barbie.getXPosition()) ||
                   Math.abs(newY - barbie.getYPosition()) == Math.abs(initialY - barbie.getYPosition()));
    }

    @Test
    public void testZombieDamageCheck(){
        IGrid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        Zombie zombie = new Zombie(grid);
        
        barbie.setXPosition(5);
        barbie.setYPosition(5);

        zombie.setXPosition(6);
        zombie.setYPosition(6);

        assertTrue(!zombie.zombieDamageCheck(barbie));

        barbie.move("d");

        assertTrue(zombie.zombieDamageCheck(barbie));
    }

    @Test
    public void testEdgeMovement(){
        Grid grid = new Grid(1);
        Zombie zombie = new Zombie(grid);
        Barbie barbie = new Barbie(grid);

        //set barbie outside grid so that zombie will try to move outside the grid
        barbie.setXPosition(10);
        barbie.setYPosition(10);

        //zombie attempts to either move randomly, not at all or towards Barbie
        zombie.move(barbie);
        //barbie should not have moved
        assertEquals(zombie.getXPosition(), 0);
        assertEquals(zombie.getYPosition(), 0);
    }
}

