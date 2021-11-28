package agh.ics.oop.tests;

import agh.ics.oop.Animal;
import agh.ics.oop.GrassField;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void testRectMap(){
        RectangularMap map = new RectangularMap(5, 5);

        Animal a1 = new Animal(map, new Vector2d(1, 1));
        Animal a2 = new Animal(map, new Vector2d(3, 3));

        map.place(a1);
        map.place(a2);

        Assert.assertTrue(map.isOccupied(a1.getPosition()));
        Assert.assertTrue(map.isOccupied(a2.getPosition()));
        Assert.assertFalse(map.isOccupied(new Vector2d(0 ,0)));

        Assert.assertFalse(map.canMoveTo(a1.getPosition()));
        Assert.assertFalse(map.canMoveTo(a2.getPosition()));
        Assert.assertTrue(map.canMoveTo(new Vector2d(0 ,0)));

        Assert.assertEquals(a1, map.objectAt(a1.getPosition()));
        Assert.assertEquals(a2, map.objectAt(a2.getPosition()));
        Assert.assertNull(map.objectAt(new Vector2d(0, 0)));

        System.out.println(map.toString());
    }

    @Test
    public void testGrassField(){
        GrassField map = new GrassField(10);
        Animal a1 = new Animal(map, new Vector2d(1, 1));
        Animal a2 = new Animal(map, new Vector2d(3, 3));

        map.place(a1);
        map.place(a2);

        Assert.assertTrue(map.isOccupied(a1.getPosition()));
        Assert.assertTrue(map.isOccupied(a2.getPosition()));
        Assert.assertFalse(map.isOccupied(new Vector2d(0 ,0)));

        Assert.assertFalse(map.canMoveTo(a1.getPosition()));
        Assert.assertFalse(map.canMoveTo(a2.getPosition()));
        Assert.assertTrue(map.canMoveTo(new Vector2d(0 ,0)));

        Assert.assertEquals(a1, map.objectAt(a1.getPosition()));
        Assert.assertEquals(a2, map.objectAt(a2.getPosition()));
        Assert.assertNull(map.objectAt(new Vector2d(0, 0)));

        System.out.println(map.toString());
    }
}
