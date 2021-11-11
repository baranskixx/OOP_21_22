package agh.ics.oop;

public class Animal {
    private MapDirection direction;
    private Vector2d mapPosition;
    private IWorldMap worldMap;

    public Animal(){
        this.direction = MapDirection.NORTH;
        this.mapPosition = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map){
        this.worldMap = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.worldMap = map;
        this.mapPosition = initialPosition;
    }


    public MapDirection getDirection() {
        return direction;
    }

    public Vector2d getMapPosition() {
        return mapPosition;
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

            m = (direction == MoveDirection.FORWARD)? m.add(this.direction.toUnitVector()) : m.add(this.direction.toUnitVector().opposite());
            if (worldMap.canMoveTo(m))
                this.mapPosition = m;

            this.mapPosition = mapPosition.lowerLeft(new Vector2d(4, 4));
            this.mapPosition = mapPosition.upperRight(new Vector2d(0, 0));
        }
    }
}
