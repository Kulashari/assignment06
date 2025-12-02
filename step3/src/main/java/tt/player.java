package tt;

import java.util.Random;
import java.util.Scanner;

abstract class player { //abstract class for player in order to create a blueprint for the different player subclasses (computer or human)
    protected char symbol;
    protected String id; // variables to store symbol and id of player
    protected Scanner input = new Scanner(System.in);
    
    public player(char symbol, String id) { // constructor to tell which symbol the player is using and their id to identify them
        this.symbol = symbol;
        this.id = id;
    }
    
    public char getSymbol() { // returns symbol of player
        return symbol;
    }
    
    public String getId() { // returns id of player
        return id;
    }

    public abstract void makeMove(board gameBoard); //the different players will decide how they will make a move through polymorphism as since the method is abstract, it can't use it directly from the parent class
}

class human extends player { //human player subclass that input's the it coordinates manually
    public human(char symbol, String id) {
        super(symbol, id); //be able to use the instance variables from parent class
    }

    @Override //override annotation makes sure that the makeMove method is intended to overide the parent class method, so that depending on the player object, it makes the right move as intended
    public void makeMove(board gameBoard) {
        boolean marked = false;
        while (!marked) { // keep asking until a valid move is made
            int[] coords = userInput(); //be able to get the return array from getUserInput, having the x and y values
            marked = gameBoard.placeMarker(coords[0], coords[1], symbol); //gets the boolean values to see if the user placed a marker in a valid spot
            if (!marked) {
                System.out.println("Try again"); //if it's not valid, then prints feedback
            }
        }
    }

    private int[] userInput() { ///function that takes the user coords, checks for validation, then returns the coords in a integer array
        while (true) {
            System.out.print("Please enter coordinates in (x,y) or x,y format: ");
            String userInput = input.nextLine().trim(); // gets the user input through a string and trims trailing white spaces
    
            if (!userInput.matches("\\(?[1-3]\\s*,\\s*[1-3]\\)?")) { // if the userInput doesn't match the regex for the specific formatting then gives feedback
                System.out.println("Use the x,y or (x,y) format with numbers 1-3");
                continue; //continues by skipping the bottom code and creating a new iteration
            }
    
            if (userInput.startsWith("(")) { // removes the leading bracket if any
                userInput = userInput.substring(1);
            }
            if (userInput.endsWith(")")) { // removes the trailing bracket if any
                userInput = userInput.substring(0, userInput.length() - 1);
            }
    
            String[] stringParts = userInput.split(","); // sets the x and y value into a string array on index 0 and 1 respectively
            // returns a new initialised array, with the x and y coordinates in the right indexes by parseinting the string numbers into integer values
            return new int[] { Integer.parseInt(stringParts[0].trim()), Integer.parseInt(stringParts[1].trim()) };
        }
    }
}

class computer extends player { //computer player subclass that randomly chooses a move
    private Random random = new Random(); //calling the random object for random move in the board

    public computer(char symbol, String id) { //inheriting the instance variables from parent class
        super(symbol, id);
    }

    @Override
    public void makeMove(board gameBoard) { //overide the makeMove method from the parent class for polymorphism and handling the actions dynamically for the computer subclass
        char[][] grid = gameBoard.getBoard(); //get's the current iteration of the gameboard

        int emptySpace = 0; //count how many empty spaces their are

        for (int i = 0;i<grid.length;i++){ //goes through the current board and counts through nested for loop
            for (int j = 0;j<grid[0].length;j++){
                if (grid[i][j] == ' '){
                    emptySpace++;
                }
            }
        }

        if (emptySpace == 0) { //if there are no more empty cells then nothing is possible
            return;
        }

        int[][] emptyCells = new int[emptySpace][2]; //stores the coordinates of the empty spaces in a 2d int array
        int index = 0;
        for (int i = 1;i<=grid.length;i++){ //bruteforce the board 
            for (int j=1;j<=grid[0].length;j++){
                if (grid[i-1][j-1] == ' '){ //and see's if theirs an empty space
                    emptyCells[index][0] = i; //notes the x coordinate of the empty space (x starts from 1)
                    emptyCells[index][1] = j; //notes the y coordinate of the empty space (y starts from 1)
                    index++; //increments the index by one to go to the next row after finding the x and y coordinate
                }
            }
        }

        int randomIndex = random.nextInt(emptySpace); //picks a random empty space between index 0 and uptill emptycount-1
        int[] coordinateArray = emptyCells[randomIndex]; //obtains the random x and y coordinate from all the empty spaces that was avaliable through a 1d integer array

        gameBoard.placeMarker(coordinateArray[0], coordinateArray[1], symbol); //able to place down a move in random x and y coords
        System.out.println(id + " made a move at ("+coordinateArray[0]+","+coordinateArray[1]+")"); //outputs that the computer made a move at random x and y values
    }
}


