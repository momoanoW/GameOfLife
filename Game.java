package abgaben.gameoflife0503.meins;

public class Game {
    private Generation grid;
    private int numberOfGrids; // VARIABLE

    public Game(int numberOfGenerations) { // CONSTRUCTOR
        grid = new Generation();
        this.numberOfGrids = numberOfGrids;
    }


    public void simulate() { // SIMULATE-METHOD
        for (int i = 0; i < numberOfGrids; i++) {
            grid.computeNextGeneration();
            System.out.println(grid); // Print the current generation
        }
    }
}
