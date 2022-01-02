package agh.ics.oop;

import agh.ics.oop.gui.App;
import agh.ics.oop.gui.GUIObserver;
import agh.ics.oop.gui.MapGUI;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine<mapGUI> implements IEngine, Runnable {
    protected AbstractWorldMap map;
    protected MoveDirection[] moves;
    protected Animal [] animals;
    private int index = 0;
    private MapGUI gui;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = (AbstractWorldMap) map;
        this.animals = new Animal[positions.length];
        for (int i=0; i<positions.length; i++){
            this.animals[i] = new Animal(this.map, positions[i]);
            this.map.place(this.animals[i]);
        }
        this.gui = new MapGUI(this.map, positions);
        this.gui.setEngine(this);
    }

    @Override
    public void run(){
        while (this.index < this.moves.length){
            MoveDirection[] movesTurn = Arrays.copyOfRange(this.moves, index, Math.min(index + this.animals.length, this.moves.length));
             for (int i=0; i<movesTurn.length; i++){
                 this.animals[i].move(movesTurn[i]);
             }
             index += this.animals.length;
            Platform.runLater(() -> {
                this.gui.refresh(this.map.getCorners());
            });
             try {
                 Thread.sleep(MapGUI.moveDelay);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
    }

    public Animal [] getAnimals(){
        return this.animals;
    }

    public void setNewCommands(MoveDirection [] directions){
        this.moves = directions;
        this.index = 0;
    }
}
