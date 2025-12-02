package tt;

public class app { //main class that calls all the other classes and handles the logic
    public static void main(String[] args) {
        board gameBoard = new board();
        gameBoard.display();
        gameBoard.placeMarker(1, 1, 'X');
        gameBoard.display();

    }
}
