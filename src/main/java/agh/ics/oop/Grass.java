package agh.ics.oop;

import javafx.scene.image.Image;
import java.io.FileInputStream;

public class Grass implements IMapElement{

    protected Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return "*";
    }

    @Override
    public Image getImage() {
        try {
            return new Image(new FileInputStream("src/main/resources/grass.png"));
        }
        catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
