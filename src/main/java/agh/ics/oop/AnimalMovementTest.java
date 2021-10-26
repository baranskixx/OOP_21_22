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
    public void positionTest(){
        Animal jaguar = new Animal();
        Animal owl = new Animal();

        jaguar.move(MoveDirection.FORWARD);
        jaguar.move(MoveDirection.RIGHT);
        jaguar.move(MoveDirection.FORWARD);

        Assert.assertTrue(jaguar.getMapPosition().equals(new Vector2d(3, 3)));

        owl.move(MoveDirection.BACKWARD);
        owl.move(MoveDirection.RIGHT);
        owl.move(MoveDirection.FORWARD);

        Assert.assertTrue(owl.getMapPosition().equals(new Vector2d(3, 1)));

        jaguar.move(MoveDirection.LEFT);
        jaguar.move(MoveDirection.BACKWARD);
        jaguar.move(MoveDirection.BACKWARD);

        Assert.assertTrue(jaguar.getMapPosition().equals(new Vector2d(3, 1)));

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

    @Test
    public void parseTest(){
        OptionParser parser = new OptionParser();

        String [] t1 = {"f", "forward", "l", "left", "r", "right", "backward", "b"};
        String [] t2 = {"1", "f", "2", "r"};
        String [] t3 = {"foward", "baward", "l", "r"};

        ArrayList<MoveDirection> ans1 = new ArrayList<>();
        ans1.add(MoveDirection.FORWARD);
        ans1.add(MoveDirection.FORWARD);
        ans1.add(MoveDirection.LEFT);
        ans1.add(MoveDirection.LEFT);
        ans1.add(MoveDirection.RIGHT);
        ans1.add(MoveDirection.RIGHT);
        ans1.add(MoveDirection.BACKWARD);
        ans1.add(MoveDirection.BACKWARD);

        ArrayList<MoveDirection> ans2 = new ArrayList<>();
        ans2.add(MoveDirection.FORWARD);
        ans2.add(MoveDirection.RIGHT);

        ArrayList<MoveDirection> ans3 = new ArrayList<>();
        ans3.add(MoveDirection.LEFT);
        ans3.add(MoveDirection.RIGHT);

        Assert.assertEquals(ans1, parser.parse(t1));
        Assert.assertEquals(ans2, parser.parse(t2));
        Assert.assertEquals(ans3, parser.parse(t3));

    }
}
