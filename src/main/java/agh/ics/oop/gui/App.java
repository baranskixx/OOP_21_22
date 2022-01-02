package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import java.util.HashSet;
import java.util.Set;


public class App extends Application {

    private GrassField map;
    private SimulationEngine engine;
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
        map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        this.engine = new SimulationEngine(directions, map, positions);

        Thread mainThread = new Thread(engine);
    }
}
