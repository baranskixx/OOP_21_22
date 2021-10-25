package agh.ics.oop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AnimalMovementTest {
    @Test
    public void orientationTest(){
        Animal jaguar = new Animal();
        jaguar.move(MoveDirection.RIGHT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.EAST);
        jaguar.move(MoveDirection.RIGHT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.SOUTH);
        jaguar.move(MoveDirection.RIGHT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.WEST);
        jaguar.move(MoveDirection.LEFT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.SOUTH);
        jaguar.move(MoveDirection.LEFT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.EAST);
        jaguar.move(MoveDirection.LEFT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.NORTH);
        jaguar.move(MoveDirection.LEFT);
        Assert.assertEquals(jaguar.getDirection(), MapDirection.WEST);
    }
    @Test
    public void limitsTest(){
        Animal jaguar = new Animal();
        Animal kangaroo = new Animal();

        jaguar.move(MoveDirection.FORWARD);
        jaguar.move(MoveDirection.FORWARD);
        jaguar.move(MoveDirection.FORWARD);
        jaguar.move(MoveDirection.LEFT);
        jaguar.move(MoveDirection.FORWARD);
        jaguar.move(MoveDirection.FORWARD);
        jaguar.move(MoveDirection.FORWARD);

        kangaroo.move(MoveDirection.RIGHT);
        kangaroo.move(MoveDirection.FORWARD);
        kangaroo.move(MoveDirection.FORWARD);
        kangaroo.move(MoveDirection.FORWARD);
        kangaroo.move(MoveDirection.RIGHT);
        kangaroo.move(MoveDirection.FORWARD);
        kangaroo.move(MoveDirection.FORWARD);
        kangaroo.move(MoveDirection.FORWARD);

        Assert.assertTrue(jaguar.getMapPosition().equals(new Vector2d(0, 4)));
        Assert.assertTrue(kangaroo.getMapPosition().equals(new Vector2d(4, 0)));
    }
}
