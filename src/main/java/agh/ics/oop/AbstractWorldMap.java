package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class AbstractWorldMap implements IWorldMap {
    protected LinkedHashMap <Vector2d, Animal> animals;
    protected MapVisualizer visualizer;

    public AbstractWorldMap(){
        this.animals = new LinkedHashMap<>();
        this.visualizer = new MapVisualizer(this);
    }

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            this.animals.put(animal.getPosition(), animal);
            return true;
        }   return false;
    }

    public boolean isOccupied(Vector2d position) {
        return this.animals.containsKey(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return this.objectAt(position) == null;
    }

    public Object objectAt(Vector2d position){ return this.animals.get(position); }

    public abstract Vector2d[] getCorners();

    public String toString(){
        Vector2d corners[] = this.getCorners();
        return this.visualizer.draw(corners[0], corners[1]);
    }
}
