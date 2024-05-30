package junit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import barbiegame.Entity;
import barbiegame.IGrid;
import barbiegame.Grid;
import barbiegame.Barbie;
import barbiegame.Zombie;
import barbiegame.Pear;
import barbiegame.RenderVisitor;

public class VisitorTest {
    
    @Test
    public void TestRenderVisitor(){
        ArrayList<Entity> entities = new ArrayList<>();
        IGrid grid = new Grid(10);
        Barbie barbie = new Barbie(grid);
        Zombie zombie = new Zombie(grid);
        Pear pear = new Pear(grid);
        entities.add(barbie);
        entities.add(zombie);
        entities.add(pear);

        //Test visit Barbie
        RenderVisitor renderVisitor = new RenderVisitor();
        renderVisitor.visit(barbie);
        assertEquals(renderVisitor.getResult(),"B");

        //Test visit Zombie
        renderVisitor = new RenderVisitor();
        renderVisitor.visit(zombie);
        assertEquals(renderVisitor.getResult(),"Z");

        //Test visit Pear
        renderVisitor = new RenderVisitor();
        renderVisitor.visit(pear);
        assertEquals(renderVisitor.getResult(),"P");

        //Test visit Barbie, Zombie, and Pear all at once
        renderVisitor = new RenderVisitor();
        renderVisitor.visit(barbie);
        renderVisitor.visit(zombie);
        renderVisitor.visit(pear);
        assertEquals(renderVisitor.getResult(),"BZP");
    }
}
