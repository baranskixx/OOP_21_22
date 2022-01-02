package agh.ics.oop.gui;

import agh.ics.oop.IPositionChangeObserver;
import agh.ics.oop.Vector2d;

import java.util.*;

public class GUIObserver implements IPositionChangeObserver {
    HashSet<Vector2d> animalPositions = new HashSet<>();

    public GUIObserver(Vector2d [] positions){
        Collections.addAll(animalPositions, positions);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        animalPositions.remove(oldPosition);
        animalPositions.add(newPosition);
    }

    public HashSet<Vector2d> getPosSet(){
        return this.animalPositions;
    }
}
