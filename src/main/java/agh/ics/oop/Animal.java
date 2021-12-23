package agh.ics.oop;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Animal implements IMapElement{
    protected MapDirection direction;
    protected Vector2d mapPosition;
    protected IWorldMap worldMap;
    protected ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.mapPosition = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map){
        this.worldMap = map;
        this.addObserver((IPositionChangeObserver) map);
        this.direction = MapDirection.NORTH;
        this.mapPosition = new Vector2d(1, 1);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.worldMap = map;
        this.direction = MapDirection.NORTH;
        this.mapPosition = initialPosition;
    }


    public MapDirection getDirection() {
        return this.direction;
    }

    public Vector2d getPosition() {
        return this.mapPosition;
    }

    public String toString(){
        return switch (this.direction) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            default -> "W";
        };
    }

    public void move(MoveDirection direction){
        if (direction == MoveDirection.RIGHT) this.direction = this.direction.next();
        else if (direction == MoveDirection.LEFT) this.direction = this.direction.previous();
        else {
            Vector2d m = new Vector2d(this.mapPosition.x, this.mapPosition.y);
            m = direction == MoveDirection.FORWARD? m.add(this.direction.toUnitVector()) : m.add(this.direction.toUnitVector().opposite());
            if (this.worldMap.canMoveTo(m)) {
                this.positionChanged(m);
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Vector2d newPos){
        Vector2d oldPos = this.mapPosition;
        this.mapPosition = newPos;
        for (IPositionChangeObserver o : this.observers){
            o.positionChanged(oldPos, newPos);
        }
    }

    @Override
    public Image getImage() {
        try {
            String path = "src/main/resources/";
            return switch (this.direction) {
                case NORTH -> new Image(new FileInputStream("src/main/resources/up.png"));
                case SOUTH -> new Image(new FileInputStream("src/main/resources/down.png"));
                case EAST -> new Image(new FileInputStream("src/main/resources/right.png"));
                case WEST -> new Image(new FileInputStream("src/main/resources/left.png"));
            };
        }
        catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
