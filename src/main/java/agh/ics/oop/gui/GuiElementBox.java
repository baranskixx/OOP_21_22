package agh.ics.oop.gui;


import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import agh.ics.oop.IWorldMap;
import agh.ics.oop.Vector2d;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class GuiElementBox{
    public final VBox vBox;

    public GuiElementBox(IMapElement e){
        Image image = e.getImage();
        Label label;
        if (e instanceof Animal) label = new Label(e.getPosition().toString());
        else label = new Label("Trawa");

        ImageView imgView = new ImageView(image);
        imgView.setFitHeight(20);
        imgView.setFitWidth(20);

        this.vBox = new VBox();
        this.vBox.getChildren().addAll(imgView, label);
        this.vBox.setAlignment(Pos.CENTER);
    }

    VBox getVBox(){
        return this.vBox;
    }
}
