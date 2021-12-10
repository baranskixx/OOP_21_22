package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected LinkedHashMap<Vector2d, Animal> animals = new LinkedHashMap<>();
    protected MapBoundary boundary = new MapBoundary(this);;

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animal.addObserver(this);
            animal.addObserver(this.boundary);
            this.animals.put(animal.getPosition(), animal);
            this.boundary.addObject(animal);
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
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d corners[] = this.getCorners();
        return visualizer.draw(corners[0], corners[1]);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal a = this.animals.remove(oldPosition);
        this.animals.put(newPosition, a);
    }
}
