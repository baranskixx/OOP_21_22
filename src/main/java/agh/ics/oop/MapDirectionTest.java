package agh.ics.oop;

import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {
    @Test
    public void testNext(){
        MapDirection d = MapDirection.NORTH;
        Assert.assertEquals(d.next(), MapDirection.EAST);

        d = MapDirection.EAST;
        Assert.assertEquals(d.next(), MapDirection.SOUTH);

        d = MapDirection.SOUTH;
        Assert.assertEquals(d.next(), MapDirection.WEST);

        d = MapDirection.WEST;
        Assert.assertEquals(d.next(), MapDirection.NORTH);
    }

    @Test
    public void textPrevious(){
        MapDirection d = MapDirection.NORTH;
        Assert.assertEquals(d.previous(), MapDirection.WEST);

        d = MapDirection.EAST;
        Assert.assertEquals(d.previous(), MapDirection.NORTH);

        d = MapDirection.SOUTH;
        Assert.assertEquals(d.previous(), MapDirection.EAST);

        d = MapDirection.WEST;
        Assert.assertEquals(d.previous(), MapDirection.SOUTH);
    }
}
