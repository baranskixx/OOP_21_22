package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends javafx.application.Application{

    GridPane grid = new GridPane();
    Scene scene = new Scene(this.grid, 400, 400);
    Vector2d [] corners;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MoveDirection[] directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
        GrassField map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());

        this.corners = map.getCorners();

        int minX = this.corners[0].x;
        int maxX = this.corners[1].x;
        int minY = this.corners[0].y;
        int maxY = this.corners[1].y;

        Label label = new Label("y/x");
        Object o;

        this.grid.add(label, 0, 0);

        for (Integer x=minX; x <= maxX; x++) {
            label = new Label(x.toString());
            this.grid.add(label, 1 + (x-minX), 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }
        for (Integer y=minY, yGrid = maxY; y <= maxY; y++, yGrid--) {
            label = new Label(yGrid.toString());
            this.grid.add(label, 0, 1+(y-minY));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int x=minX; x <= maxX; x++){
            for (int y=minY; y <= maxY; y++){
                int gridX = 1 + (x - minX);
                int gridY = 1 + (maxY - y);
                o = map.objectAt(new Vector2d(x, y));
                if (o != null) label = new Label(o.toString());
                else label = new Label(" ");
                this.grid.add(label, gridX, gridY);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }

        grid.getColumnConstraints().add(new ColumnConstraints((20)));
        grid.getRowConstraints().add(new RowConstraints(20));
        this.grid.setGridLinesVisible(true);
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}
