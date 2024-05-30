package junit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import barbiegame.Grid;
import barbiegame.IGrid;
import barbiegame.Pear;

public class PearTest {

    @Test
    public void testGetAndSetPosition() {
        IGrid grid = new Grid(10);
        Pear pear = new Pear(grid);
        int x = pear.getXPosition();
        int y = pear.getYPosition();

        assertTrue(x >= 0 && x < grid.getSideLength());
        assertTrue(y >= 0 && y < grid.getSideLength());
    }
}

