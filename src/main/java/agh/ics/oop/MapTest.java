package agh.ics.oop;

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

        Assert.assertTrue(map.isOccupied(a1.getMapPosition()));
        Assert.assertTrue(map.isOccupied(a2.getMapPosition()));
        Assert.assertFalse(map.isOccupied(new Vector2d(0 ,0)));

        Assert.assertFalse(map.canMoveTo(a1.getMapPosition()));
        Assert.assertFalse(map.canMoveTo(a2.getMapPosition()));
        Assert.assertTrue(map.canMoveTo(new Vector2d(0 ,0)));

        Assert.assertEquals(a1, map.objectAt(a1.getMapPosition()));
        Assert.assertEquals(a2, map.objectAt(a2.getMapPosition()));
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

        Assert.assertTrue(map.isOccupied(a1.getMapPosition()));
        Assert.assertTrue(map.isOccupied(a2.getMapPosition()));
        Assert.assertFalse(map.isOccupied(new Vector2d(0 ,0)));

        Assert.assertFalse(map.canMoveTo(a1.getMapPosition()));
        Assert.assertFalse(map.canMoveTo(a2.getMapPosition()));
        Assert.assertTrue(map.canMoveTo(new Vector2d(0 ,0)));

        Assert.assertEquals(a1, map.objectAt(a1.getMapPosition()));
        Assert.assertEquals(a2, map.objectAt(a2.getMapPosition()));
        Assert.assertNull(map.objectAt(new Vector2d(0, 0)));

        System.out.println(map.toString());
    }
}
