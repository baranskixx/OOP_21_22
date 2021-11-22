package agh.ics.oop;

import java.util.ArrayList;

public abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<Animal> animals;

    public AbstractWorldMap(){
        this.animals = new ArrayList<>();
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }   return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal a : this.animals){
            if (a.getPosition().equals(position)) return true;
        }
        return false;
    }

    public boolean canMoveTo(Vector2d position) {
        return this.objectAt(position) == null;
    }

    public Object objectAt(Vector2d position) {
        for (Animal a : this.animals){
            if (a.getPosition().equals(position)) return a;
        }
        return null;
    }

    public abstract Vector2d[] getCorners();

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d corners[] = getCorners();
        return visualizer.draw(corners[0], corners[1]);
    }
}
