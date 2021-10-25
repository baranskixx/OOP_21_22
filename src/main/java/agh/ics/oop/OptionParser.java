package agh.ics.oop;

import java.util.ArrayList;

public class OptionParser {
    public ArrayList<MoveDirection> parse(String[] instructions){
        ArrayList<MoveDirection> moves = new ArrayList<>();

        for (String i : instructions){
            switch (i) {
                case "f", "forward" -> moves.add(MoveDirection.FORWARD);
                case "b", "backward" -> moves.add(MoveDirection.BACKWARD);
                case "r", "right" -> moves.add(MoveDirection.RIGHT);
                case "l", "left" -> moves.add(MoveDirection.LEFT);
                default -> {
                }
            }
        }
        return moves;
    }
}
