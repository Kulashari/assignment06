package tt;

public class app { //main class that calls all the other classes and handles the logic
    public static void main(String[] args) {
        // board gameBoard = new board();
        // gameBoard.display();
        // gameBoard.placeMarker(1, 1, 'X');
        // gameBoard.display();

        player p1 = new player('X', "Player 1"); //hardcoded for testing
        player p2 = new player('O', "Player 2");
        
        game playGame = new game(p1, p2);
        playGame.gameStart();

    }
}
