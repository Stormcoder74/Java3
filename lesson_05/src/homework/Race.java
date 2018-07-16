package homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    private Car winner;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public synchronized void winDetermination(Car win){
        if (winner == null){
            winner = win;
            System.out.println(winner.getName() + " WIN");
        }
    }
}
