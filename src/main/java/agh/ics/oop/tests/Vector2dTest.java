package agh.ics.oop.tests;

import agh.ics.oop.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {
    Vector2d v1 = new Vector2d(1, 2);
    Vector2d v2 = new Vector2d(3, 3);
    Vector2d v3 = new Vector2d(2, 1);
    Vector2d v4 = new Vector2d(3, 3);

    @Test
    public void testEquals(){
        Assert.assertFalse(v1.equals(v2));
        Assert.assertFalse(v3.equals(v1));
        Assert.assertFalse(v4.equals(v1));
        Assert.assertTrue(v4.equals(v2));
        Assert.assertTrue(v2.equals(v4));
    }
    @Test
    public void testToString(){
        Assert.assertEquals(v1.toString(), "(1,2)");
        Assert.assertEquals(v2.toString(), "(3,3)");
        Assert.assertEquals(v4.toString(), v2.toString());
    }
    @Test
    public void testPrecedes(){
        Assert.assertFalse(v1.precedes(v3));
        Assert.assertTrue(v1.precedes(v2));
        Assert.assertFalse(v4.precedes(v3));
        Assert.assertTrue(v4.precedes(v2));
    }
    @Test
    public void testFollows(){
        Assert.assertFalse(v3.follows(v2));
        Assert.assertTrue(v1.follows(v1));
        Assert.assertFalse(v1.follows(v3));
        Assert.assertTrue(v4.follows(v1));
    }

    @Test
    public void testUpperRight(){
        Assert.assertTrue(v3.upperRight(v4).equals(v4));
        Assert.assertTrue(v1.upperRight(v3).equals(new Vector2d(2, 2)));
    }

    @Test
    public void testLowerLeft(){
        Assert.assertTrue(v3.lowerLeft(v4).equals(v3));
        Assert.assertFalse(v1.lowerLeft(v2).equals(v2));
    }

    @Test
    public void testAdd(){
        Assert.assertTrue(v1.add(v3).equals(v4));
        Assert.assertFalse(v4.add(v2).equals(v1));
        Assert.assertTrue(v2.add(v4).equals(new Vector2d(6, 6)));
    }
    @Test
    public void testSubtract(){
        Assert.assertTrue(v2.subtract(v1).equals(v3));
        Assert.assertTrue(v2.subtract(v3).equals(v1));
    }

    @Test
    public void testOpposite(){
        Assert.assertTrue(v1.opposite().equals(new Vector2d(-1, -2)));
        Assert.assertTrue(v2.opposite().equals(new Vector2d(-3, -3)));
        Assert.assertTrue(v3.opposite().equals(new Vector2d(-2, -1)));
    }
}
