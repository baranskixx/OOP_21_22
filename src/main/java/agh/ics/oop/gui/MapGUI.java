package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MapGUI {
    private GridPane grid = new GridPane();
    private Scene scene;
    private final Stage stage = new Stage();

    private Button runBtn = new Button("Run!");
    private TextField textField = new TextField();
    private HBox btnBox = new HBox(runBtn, textField);

    private final VBox mainHBox = new VBox(grid, btnBox);
    private GrassField map;
    private final GUIObserver animalPositionsObserver;
    private final Set<Vector2d> grassPos;

    private SimulationEngine engine;

    public static final int moveDelay = 500;

    public MapGUI(IWorldMap map, Vector2d [] pos){
        this.map = (GrassField) map;
        grassPos = this.map.getGrassPositions();
        animalPositionsObserver = new GUIObserver(pos);
        for (Vector2d v : pos){
            ((Animal)this.map.objectAt(v)).addObserver(animalPositionsObserver);
        }
        this.scene = new Scene(mainHBox, 800, 800);
        refresh(this.map.getCorners());

        this.runBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String [] commands = textField.getText().split(" ");
                engine.setNewCommands(new OptionsParser().parse(commands));
                new Thread(engine).start();
            }
        });
    }

    public void drawMap(Vector2d [] corners){
        int minX = corners[0].x;
        int maxX = corners[1].x;
        int minY = corners[0].y;
        int maxY = corners[1].y;

        Label label = new Label("y/x");
        Object o;
        this.grid = new GridPane();
        this.grid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);

        for (Integer x=minX; x <= maxX; x++) {
            label = new Label(x.toString());
            this.grid.add(label, 1 + (x-minX), 0);
            GridPane.setHalignment(label, HPos.CENTER);
            this.grid.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (Integer y=minY, yGrid = maxY; y <= maxY; y++, yGrid--) {
            label = new Label(yGrid.toString());
            this.grid.add(label, 0, 1+(y-minY));
            GridPane.setHalignment(label, HPos.CENTER);
            this.grid.getRowConstraints().add(new RowConstraints(40));
        }
        this.grid.getRowConstraints().add(new RowConstraints(40));
        this.grid.getColumnConstraints().add(new ColumnConstraints(40));

        HashSet<Vector2d> set = this.animalPositionsObserver.getPosSet();
        set.addAll(this.grassPos);

        for (Vector2d v : set){
            GuiElementBox box = new GuiElementBox((IMapElement) this.map.objectAt(v));
            int gridX = 1 + v.x - minX;
            int gridY = 1 + maxY - v.y;
            this.grid.add(box.getVBox(), gridX, gridY);
        }

        grid.setGridLinesVisible(true);
        scene = new Scene(new VBox(grid, btnBox), 800, 800);
        stage.setScene(scene);
        stage.show();
    }

    public void refresh(Vector2d [] mapCorners){
        grid.getChildren().clear();
        this.drawMap(mapCorners);
    }

    public void setMap(GrassField map){
        this.map = map;
    }

    public void setEngine(SimulationEngine engine){
        this.engine = engine;
    }


}
