package tt;

class game { //game class to represent the game and the behaviour of the game
    private board gameBoard;
    private player player1; //private variables to store the players and the board
    private player player2;
    private player currentPlayer;

    public game(player player1, player player2){ //constructor to intialize the game with the players and board
        this.player1 = player1;
        this.player2 = player2;
        this.gameBoard = new board();
        this.currentPlayer = player1;
    }

    public void reset(){ //resets the board and sets current player to player 1
        gameBoard.reset();
        currentPlayer = player1;
    }

    public void switchTurn(){ //swicthes the turn between player 1 and player 2
        if (currentPlayer == player1){ 
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }
    }

    public player getCurrentPlayer(){ //returns who's the current player
        return currentPlayer;
    }

    public void gameStart(){ //function responsible for looping the game 
        System.out.print("\033[H\033[2J"); //ANSI code that clears the terminal, will be used so that each new game starts with a clear view
        System.out.flush();

        gameBoard.display(); //displays the empty board

        while (!gameOver()){ //while loop until the game has reached it's end
            System.out.println(currentPlayer.getId()+"'s Turn - Symbol: "+ currentPlayer.getSymbol());

            currentPlayer.makeMove(gameBoard); //makes it so that the current player will overide the method calling and make it so that depending on the object value (player or computer) will make the move according to their move set
                                                //highlights the use of polymorphism 

            switchTurn(); //switches the current player
            System.out.println(" ");
            gameBoard.display(); //display updated board after a move is made
        }
    }

    public boolean gameOver(){
        //hardcoded it for now but if the game condition ends up being (a player wins or tie), then return true
        return false; //else return false while the game continues
    }
}
