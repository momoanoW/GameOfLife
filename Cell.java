package abgaben.gameoflife0503.meins;
public class Cell {

    private boolean isAlive;

    // Konstruktor mit einem boolean-Parameter
    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void printSymbol(){
        if (this.isAlive) {
            System.out.println('*');} // für lebendige Sternchen ausgeben
        else if (!this.isAlive) {
                System.out.println('.');} // für tote Punkt ausgeben
    }

    public boolean computeNextState(int numberOfNeighborsAlive){
        if (this.isAlive) { //wenn aktuelle Zelle lebendig
            if (numberOfNeighborsAlive <= 2) { //und wenn lebendigeNachbarn weniger / gleich 2
                return false; // Nachfahre tot.
            } else if (numberOfNeighborsAlive  == 2 || numberOfNeighborsAlive == 3) { // und wenn lebendigeNachbarn = 2 oder 3
                return true; // Nachfahre lebendig.
            } else { // ansonsten wenn lebendigeNachbarn mehr als 3
                return false; // Nachfahre tot.
            }
        } else if (!this.isAlive){ //wenn aktuelle Zelle tot
            if (numberOfNeighborsAlive  == 3) { // und wenn lebendigeNachbarn = genau 3
                return true;
            } else {
                return false;
            }
        }
    }


}
