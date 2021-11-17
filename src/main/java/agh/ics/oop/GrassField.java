package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField implements IWorldMap{
    private int grassCnt;
    private int grassBound;
    private Grass [] grassPositions;
    private ArrayList<Animal> animals;

    public GrassField(int g){
        this.grassCnt = g;
        this.grassPositions = new Grass[this.grassCnt];

        int x, y;

        Random rand = new Random();
        for(int i=0; i<this.grassCnt; i++){
            do {
                x = rand.nextInt((int) Math.floor(Math.sqrt(this.grassCnt * 10) + 1));
                y = rand.nextInt((int) Math.floor(Math.sqrt(this.grassCnt * 10) + 1));
            } while(this.isOccupied(new Vector2d(x, y)));
            this.grassPositions[i] = new Grass(new Vector2d(x, y));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!this.isOccupied(animal.getMapPosition())) {
            this.animals.add(animal);
            return true;
        }   return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals){
            if (animal.getMapPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: this.animals){
            if (animal.getMapPosition().equals(position)) return animal;
        }
        for(Grass g: this.grassPositions){
            if (g.getPosition().equals(position)) return g;
        }
        return null;
    }

    public String toString(){
        Vector2d lowLeft = new Vector2d(0, 0), upperRight = new Vector2d();

        for (Animal animal : this.animals){
            if (animal.getMapPosition().lo)
        }


        return new MapVisualizer().draw()
    }
}
