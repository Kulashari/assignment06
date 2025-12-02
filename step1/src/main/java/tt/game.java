package tt;

public class game { //game class to represent the game and the behaviour of the game
    private board gameBoard;
    private player player1; //private variables to store the players and the board
    private player player2;
    private String currentPlayer;

    public game(player player1, player player2){ //constructor to intialize the game with the players and board
        this.player1 = player1;
        this.player2 = player2;
        this.gameBoard = new board();
        this.currentPlayer = "player1";
    }

    public void reset(){ //resets the board and which is the current player
        gameBoard.reset();
        currentPlayer = "player1";
    }

    public void switchTurn(){ //swicthes the turn between player 1 and player 2
        if (currentPlayer == "player1"){ 
            currentPlayer = "player2";
        }
        else{
            currentPlayer = "player1";
        }
    }

    public String getCurrentPlayer(){ //returns who's the current player
        return currentPlayer;
    }

    public player getPlayer1(){ //returns player1
        return player1;
    }

    public player getPlayer2(){ //returns player2
        return player2;
    }
}
