package agh.ics.oop;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private int grassCnt;
    private int grassBound;
    private ArrayList<Grass> grassPositions;

    public GrassField(int g) {
        super();
        this.grassCnt = g;
        this.grassPositions = new ArrayList<>();

        int x, y;
        this.grassBound = (int) Math.floor(Math.sqrt(this.grassCnt * 10));
        Random rand = new Random();

        for (int i = 0; i < this.grassCnt; i++) {
            do {
                x = rand.nextInt(grassBound);
                y = rand.nextInt(grassBound);
            } while (this.isOccupied(new Vector2d(x, y)));
            this.grassPositions.add(new Grass(new Vector2d(x, y)));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = objectAt(position);
        return obj == null || !obj.getClass().getSimpleName().equals("Animal");
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
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj != null) return obj;
        for (Grass g : this.grassPositions) {
            if (g.getPosition().equals(position)) return g;
        }
        return null;
    }


    public Vector2d[] getCorners() {
        Vector2d lowerLeft = new Vector2d(0, 0), upperRight = new Vector2d(grassBound, grassBound);

        for (Map.Entry<Vector2d, Animal> mapElem : this.animals.entrySet()) {
            Animal a = mapElem.getValue();
            lowerLeft = lowerLeft.lowerLeft(a.getPosition());
            upperRight = upperRight.upperRight(a.getPosition());
        }
        Vector2d[] corners = {lowerLeft, upperRight};
        return corners;
    }
}
