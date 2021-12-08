package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected HashMap<Vector2d, Animal> animals = new HashMap<>();

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animal.addObserver(this);
            this.animals.put(animal.getPosition(), animal);
            return true;
        }   throw new IllegalArgumentException(animal.getPosition().toString() + " is not valid place position");
    }

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return objectAt(position) == null;
    }

    public Object objectAt(Vector2d position){ return animals.get(position); }

    public abstract Vector2d[] getCorners();

    public String toString(){
        System.out.println("Odpalono visualizer.");
        System.out.println("Ilość zwierząt: " + animals.size());
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d corners[] = this.getCorners();
        return visualizer.draw(corners[0], corners[1]);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal a = this.animals.remove(oldPosition);
        this.animals.put(newPosition, a);
    }
}
