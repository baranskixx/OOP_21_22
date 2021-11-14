package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private int width, height;
    private ArrayList<Animal> animals;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position) && position.equals(position.lowerLeft(new Vector2d(this.width-1, this.height-1)))
                && position.equals(position.upperRight(new Vector2d(0, 0)));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getMapPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : this.animals){
            if (a.getMapPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal a : this.animals){
            if (a.getMapPosition().equals(position)) return a;
        }
        return null;
    }
}
