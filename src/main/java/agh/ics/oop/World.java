package agh.ics.oop;

import java.util.ArrayList;

public class World{
    public static void main(String[] args){
        System.out.println("Start.");

        ArrayList<Direction> dirs = toDirection(args);
        run(dirs);

        System.out.println("Stop.");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

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
            switch(instruction){
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    break;
            }
        }
    }
}

