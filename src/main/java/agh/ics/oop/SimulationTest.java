package agh.ics.oop;

import org.junit.Assert;
import org.junit.Test;

public class SimulationTest {
    private OptionsParser parser = new OptionsParser();

    private IWorldMap map1 = new RectangularMap(3, 3);
    private Vector2d[] p1 = {new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 0)};
    private String[] m1 = {"f", "f", "f", "f", "f", "f", "f", "f", "f"};
    private String ans1 =
            " y\\x  0 1 2\n" +
            "  3: -------\n" +
            "  2: |N|N|N|\n" +
            "  1: | | | |\n" +
            "  0: | | | |\n" +
            " -1: -------\n";

    @Test
    public void test1() {
        SimulationEngine engine = new SimulationEngine(parser.parse(m1), map1, p1);
        engine.run();

        Animal[] a = engine.getAnimals();

        Assert.assertTrue(a[0].getMapPosition().equals(new Vector2d(0, 2)));
        Assert.assertTrue(a[1].getMapPosition().equals(new Vector2d(1, 2)));
        Assert.assertTrue(a[2].getMapPosition().equals(new Vector2d(2, 2)));

        Assert.assertEquals(map1.toString(), ans1);
    }

    private IWorldMap map2 = new RectangularMap(3, 3);
    private Vector2d[] p2 = {new Vector2d(0, 0), new Vector2d(1, 1)};
    private String[] m2 = {"f", "l", "r", "l", "f", "l", "l", "l", "f", "l", "r", "l", "f", "l", "r", "l", "f", "l", "l", "l", "f", "l",
            "r", "l", "f", "l", "r", "l", "f", "l", "l", "l", "f", "l", "r", "l", "f", "l", "r", "l", "f", "l"};
    private String ans2 =
            " y\\x  0 1 2\n" +
            "  3: -------\n" +
            "  2: | | | |\n" +
            "  1: | |W| |\n" +
            "  0: | |N| |\n" +
            " -1: -------\n";

    @Test
    public void test2() {
        SimulationEngine engine = new SimulationEngine(parser.parse(m2), map2, p2);
        engine.run();

        Animal[] a = engine.getAnimals();

        Assert.assertTrue(a[0].getMapPosition().equals(new Vector2d(1, 0)));
        Assert.assertTrue(a[1].getMapPosition().equals(new Vector2d(1, 1)));

        Assert.assertEquals(map2.toString(), ans2);
    }

    private IWorldMap map3 = new RectangularMap(3, 3);
    private Vector2d[] p3 = {new Vector2d(0, 0), new Vector2d(2, 2)};
    private String[] m3 = {"f", "r", "f", "r", "r", "r", "f", "f", "f", "f", "f", "f"};
    private String ans3 =
            " y\\x  0 1 2\n" +
            "  3: -------\n" +
            "  2: | |E|W|\n" +
            "  1: | | | |\n" +
            "  0: | | | |\n" +
            " -1: -------\n";

    @Test
    public void test3() {
        SimulationEngine engine = new SimulationEngine(parser.parse(m3), map3, p3);
        engine.run();

        Animal[] a = engine.getAnimals();

        System.out.println(a[0].getMapPosition().toString());

        Assert.assertTrue(a[0].getMapPosition().equals(new Vector2d(1, 2)));
        Assert.assertTrue(a[1].getMapPosition().equals(new Vector2d(2, 2)));

        Assert.assertEquals(map3.toString(), ans3);
    }
}