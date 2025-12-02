package tt;
import java.util.Scanner;

public class game { //game class to represent the game and the behaviour of the game
    private board gameBoard;
    private player player1; //private variables to store the players and the board
    private player player2;
    private player currentPlayer;
    private Scanner input = new Scanner(System.in);

    public game(player player1, player player2){ //constructor to intialize the game with the players and board
        this.player1 = player1;
        this.player2 = player2;
        this.gameBoard = new board();
        this.currentPlayer = player1;
    }

    public void reset(){ //resets the board and which is the current player
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
        System.out.print("\033[H\033[2J"); //ANSI code that clears the terminal, will be used to delete old board screens so it updates real time for a cleaner view
        System.out.flush();

        gameBoard.display(); //displays the empty board

        while (!gameOver()){ //while loop until the game has reached it's end
            char symbol = currentPlayer.getSymbol(); //get's the symbol for the current player(1 or 2)
            System.out.println(currentPlayer.getId()+"'s Turn - Symbol: "+symbol);

            boolean marked = false;
            while(!marked){ //while loop to see if the player has marked the board
                int[] arrayCoords = userInput(); //stores the integer array
                marked = gameBoard.placeMarker(arrayCoords[0], arrayCoords[1], symbol); //place the marker on the coords and with the right symbol
                if (!marked){ //if the place marker method returns a false (invalid placement) then gives feedback
                    System.out.println("Try again");
                }          
            }

            switchTurn(); //switches the current player
            System.out.print("\033[H\033[2J"); 
            System.out.flush();

            gameBoard.display();
        }
        input.close();
    }

    public boolean gameOver(){
        //hardcoded it for now but if the game condtion ends up being (a player wins or tie), then return true
        return false; //else return false while the game continues
    }

    public int[] userInput(){ //function that takes the user coords, checks for validation, then returns the coords in a integer array
        while (true) {
            System.out.print("Please enter coordinates in (x,y) or x,y format: ");
            String userInput = input.nextLine().trim(); //gets the user input through a string and trims trailing white spaces
    
            if (!userInput.matches("\\(?[1-3]\\s*,\\s*[1-3]\\)?")) { //if the userInput doesn't match the regex for the specific formatting then gives feedback
                System.out.println("Use the x,y or (x,y) format with numbers 1-3");
                continue;
            }
    
            if (userInput.startsWith("(")){ //removes the leading bracket if any
                userInput = userInput.substring(1);
            }
            if (userInput.endsWith(")")){ //removes the trailing bracket if any
                userInput = userInput.substring(0, userInput.length()-1);
            }
    
            String[] stringParts = userInput.split(","); //sets the x and y value into a string array on index 0 and 1 respectively
            
            //returns a new instialized array, with the x and y coordinates in the right indexes by parse inting the string numbers into integer values
            return new int[]{Integer.parseInt(stringParts[0].trim()), Integer.parseInt(stringParts[1].trim())};
        }
    }
}
