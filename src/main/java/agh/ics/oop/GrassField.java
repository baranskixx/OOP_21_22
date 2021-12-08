package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    protected int grassCnt;
    protected int grassBound;
    protected LinkedHashMap<Vector2d, Grass> grass = new LinkedHashMap<>();

    public GrassField(int g) {
        super();
        this.grassCnt = g;

        int x, y;
        this.grassBound = (int) Math.floor(Math.sqrt(this.grassCnt * 10));
        Random rand = new Random();

        for (int i = 0; i < this.grassCnt; i++) {
            do {
                x = rand.nextInt(grassBound);
                y = rand.nextInt(grassBound);
            } while (this.isOccupied(new Vector2d(x, y)));
            this.grass.put(new Vector2d(x, y), new Grass(new Vector2d(x, y)));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !super.isOccupied(position);
    }

//    @Override
//    public boolean place(Animal animal) {
//        if (!this.isOccupied(animal.getMapPosition())) {
//            super.animals.add(animal);
//            return true;
//        }   return false;
//    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) return true;
        return this.grass.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj != null) return obj;
        return this.grass.get(position);
    }

    public Vector2d[] getCorners() {
        Vector2d lowerLeft = new Vector2d(0, 0), upperRight = new Vector2d(grassBound, grassBound);

        for (Vector2d position : this.animals.keySet()) {
            lowerLeft = lowerLeft.lowerLeft(position);
            upperRight = upperRight.upperRight(position);
        }
        return new Vector2d[]{lowerLeft, upperRight};
    }
}
