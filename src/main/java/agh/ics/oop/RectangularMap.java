package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RectangularMap extends AbstractWorldMap{
    protected int width, height;

    public RectangularMap(int width, int height){
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.upperRight(new Vector2d(0, 0)).equals(position)
                && position.lowerLeft(new Vector2d(this.width-1, this.height-1)).equals(position);
    }

//    @Override
//    public boolean isOccupied(Vector2d position) {
//        for (Animal a : this.animals){
//            if (a.getMapPosition().equals(position)) return true;
//        }
//        return false;
//    }

//    @Override
//    public Object objectAt(Vector2d position) {
//        for (Animal a : this.animals){
//            if (a.getMapPosition().equals(position)) return a;
//        }
//        return null;
//    }

//    public String toString(){
//        MapVisualizer visualizer = new MapVisualizer(this);
//        System.out.println();
//        return visualizer.draw(new Vector2d(0, 0), new Vector2d(width-1, height-1));
//    }

    @Override
    public Vector2d[] getCorners() {
        return new Vector2d[]{new Vector2d(0, 0), new Vector2d(this.width-1, this.height-1)};
    }

    public void printAnimals(){
        System.out.println(this.animals);
    }
}
