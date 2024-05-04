package abgaben.gameoflife0503.meins;

public class MainGameOfLife {

    public static void main(String[] args) {
        int numberOfGenerations = 10; // SETTER
        Game game = new Game(numberOfGenerations);
        game.simulate(); // Start the simulation
    }
}
