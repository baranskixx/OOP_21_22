package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d mapPosition;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.mapPosition = new Vector2d(2, 2);
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getMapPosition() {
        return mapPosition;
    }

    public String toString(){
        return "Kierunek: " + this.direction.toString() + ", pozycja: " + this.mapPosition.toString();
    }

    public void move(MoveDirection direction){
        if (direction == MoveDirection.RIGHT) this.direction = this.direction.next();
        else if (direction == MoveDirection.LEFT) this.direction = this.direction.previous();
        else {
            if (direction == MoveDirection.FORWARD) this.mapPosition = this.mapPosition.add(this.direction.toUnitVector());
             else this.mapPosition = mapPosition.add(this.direction.toUnitVector().opposite());

            this.mapPosition = mapPosition.lowerLeft(new Vector2d(4, 4));
            this.mapPosition = mapPosition.upperRight(new Vector2d(0, 0));
        }
    }
}
