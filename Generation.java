package abgaben.gameoflife0503.meins;

import abgaben.gameoflife0503.musterloesung.Zelle;

import java.util.Random;

public class Generation {
    Cell[][] grid; // verschachteltes Array aus Cells, gleichzeitig Variable des Objekts der Klasse Generation
    private String gridString = ""; // Instanz außerhalb der Methode deklarieren


    //Konstruktor
    public Generation(int length) {
        this.grid = new Cell[length][length];
        fillRandomly();
    }

    public Cell[][] fillArrayRandomly(Cell[][] grid) {
        Random r = new Random(); // Erzeuge ein Random-Objekt, um Zufallszahlen zu generieren
        // Durchlaufe die Arrays und fülle sie mit zufälligen boolean Werten
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = r.nextBoolean(); // Setze das aktuelle Element auf einen zufälligen boolean Wert
            }
        }
        return grid;
    }

    public void computeNextGeneration(int numberOfNeighborsAlive) { // nächste Generation berechnen anhand der jetzigen
        Cell[][] nextGrid = new Cell[grid.length][grid.length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                // anzahl der Nachbarn zählen
                int numberOfNeighborsAlive = Cell.numberOfNeighborsAlive(row, column);
                // Zelle nach nächsten STatus fragen
                Cell cellOfCurrentGrid = grid[row][column];
                Cell cellOfNextGrid = cellOfCurrentGrid.computeNextState(numberOfNeighborsAlive);
                nextGrid[row][column] = cellOfNextGrid;
            }
        }
        grid = nextGrid;
    }

    private int computeAliveNeighbors(int row, int column, boolean isAlive) {
        int numberOfNeighborsAlive = 0;
        for (int testRow = -1; testRow <= 1; testRow++) {
            for (int testColumn = -1; testColumn <= 1; testColumn++) {
                int neighborRow = row + testRow;
                int neighborColumn = column + testColumn;
                if (isPartOfArray(neighborRow, neighborColumn)) {
                    if (isNeighbor(row, column, neighborRow, neighborColumn)) {
                        if (grid[neighborRow][neighborColumn] == Cell.isAlive) {
                            numberOfNeighborsAlive++;
                        }
                    }
                }
            }
        }
        return numberOfNeighborsAlive;
    }

    private boolean isPartOfArray(int neighborRow, int neighborColumn) {
        return neighborRow >= 0 && neighborColumn >= 0
                && neighborRow < grid.length && neighborColumn < grid.length;
    }

    private static boolean isNeighbor(int row, int column, int neighborRow, int neighborColumn) {
        return !(neighborRow == row && neighborColumn == column);
    }

    @Override
    public String toString() {
        gridString = ""; // Innerhalb der Methode nur neu deklarieren, siehe globale Variable oben
        for (int row = 0; row < grid.length; row++) { //jede Zellen-Zeile ablaufen
            for (int column = 0; column < grid[row].length; column++) { //jede Zellen-Spalte ablaufen
                gridString = gridString + grid[row][column].printSymbol(); // Verwendung der isAlive Variable in der printSymbol Methode
            }
            gridString = gridString + "\n"; // Neue Zeile für jedes Zeilenende
        }
        return gridString;
    }


}


}
