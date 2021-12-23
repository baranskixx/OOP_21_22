package agh.ics.oop;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

public interface IMapElement {
    public Vector2d getPosition();
    public String toString();
    public Image getImage();
}
