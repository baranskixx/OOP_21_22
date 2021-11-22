package agh.ics.oop;

import java.util.ArrayList;

public class World{
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
    }

    public static ArrayList<Direction> toDirection(String[] args){
        ArrayList<Direction> dirList = new ArrayList<Direction>();

        for (String dir : args){
            switch (dir){
                case "f":
                    dirList.add(Direction.FORWARD);
                    break;
                case "b":
                    dirList.add(Direction.BACKWARD);
                    break;
                case "r":
                    dirList.add(Direction.RIGHT);
                    break;
                case "l":
                    dirList.add(Direction.LEFT);
                    break;
                default:
                    break;
            }
        }
        return dirList;
    }

    static void run(ArrayList<Direction> dirs){
        System.out.println("Zwierzak idzie do przodu");

        int len = dirs.size();
        int cnt = 0;

        for (Direction instruction: dirs){
            cnt++;
            System.out.print(instruction);

            if (cnt != len) System.out.print(", ");
        }

        for (Direction instruction : dirs){
            switch (instruction) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                default -> {
                }
            }
        }
    }
}

