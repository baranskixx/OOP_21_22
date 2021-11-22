package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine {
    private IWorldMap map;
    private MoveDirection[] moves;
    private Animal [] animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        this.animals = new Animal[positions.length];

        for (int i=0; i<positions.length; i++){
            this.animals[i] = new Animal(this.map, positions[i]);
            this.map.place(this.animals[i]);
        }
    }

    @Override
    public void run() {
        int index = 0;
        MoveDirection[] movesTurn;
        while (index < this.moves.length){
             movesTurn = Arrays.copyOfRange(this.moves, index, Math.min(index + this.animals.length, this.moves.length));
             for (int i=0; i<movesTurn.length; i++){
                 this.animals[i].move(movesTurn[i]);
             }
             index += this.animals.length;
        }
    }

    public Animal[] getAnimals() {
        return animals;
    }
}
