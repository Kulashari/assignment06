package tt;

public class app { //main class that calls all the other classes and handles the logic
    public static void main(String[] args) {

        player p1 = new human('X', "Player 1"); //hardcoded for testing
        player p2 = new computer('O', "Computer");
        
        game playGame = new game(p1, p2);
        playGame.gameStart();

    }
}