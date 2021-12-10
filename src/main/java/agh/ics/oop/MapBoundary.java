package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private Comparator<IMapElement> comparatorType = (Comparator<IMapElement>) (o1, o2) -> {
        String s1 = o1.toString();
        String s2 = o2.toString();

        if (s1.equals("*")) return 1;
        if (s2.equals("*")) return -1;
        return 0;
    };

    private Comparator<IMapElement> comparatorX = (Comparator<IMapElement>) (o1, o2) -> {
        Vector2d pos1 = o1.getPosition();
        Vector2d pos2 = o2.getPosition();
        if (pos1.x < pos2.x) return -1;
        else if (pos1.x > pos2.x) return 1;
        else {
            if (pos1.y < pos2.y) return -1;
            else if (pos1.y > pos2.y) return 1;
            return this.comparatorType.compare(o1, o2);
        }
    };

    private Comparator<IMapElement> comparatorY = (Comparator<IMapElement>) (o1, o2) -> {
        Vector2d pos1 = o1.getPosition();
        Vector2d pos2 = o2.getPosition();
        if (pos1.y < pos2.y) return -1;
        else if (pos1.y > pos2.y) return 1;
        else {
            if (pos1.x < pos2.x) return -1;
            else if (pos1.x > pos2.x) return 1;
            return this.comparatorType.compare(o1, o2);
        }
    };

    private SortedSet<IMapElement> setX = new TreeSet<>(this.comparatorX);
    private SortedSet<IMapElement> setY = new TreeSet<>(this.comparatorY);

    private AbstractWorldMap map;

    public MapBoundary(AbstractWorldMap m){
        this.map = m;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement o = (IMapElement)this.map.objectAt(newPosition);
        this.setX.remove(o);
        this.setY.remove(o);

        this.setX.add(o);
        this.setY.add(o);
    }

    public void addObject(IMapElement o){
        this.setX.add(o);
        this.setY.add(o);
    }

    public Vector2d[] getBounds(){
        Vector2d lowerLeft = this.setX.first().getPosition().lowerLeft(this.setY.first().getPosition());
        Vector2d upperRight = this.setX.last().getPosition().upperRight(this.setY.last().getPosition());
        return new Vector2d[] {lowerLeft, upperRight};
    }
}
