package tt;

class board { //board class that represents the board
    private char[][] grid; //intialize 2d char array that represents the board
    
    public board() { //constructor of the class
        grid = new char[3][3]; //3x3 board for now
        initializeBoard(); //calls the intializeBoard function when creating the class object
    }
    
    private void initializeBoard() { //creates a empty board
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }
    
    public void display() { //displays the baord pattern, with filled or non filled squares
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) { //goes through the 2d char array in a nested for loop
                System.out.print(" " + grid[i][j] + " "); //places the player symbol in the according row and column
                if (j < 3 - 1) { //if it's not the last column it prints vertical separator between cells
                    System.out.print("|");
                }
            }
            System.out.println(); //goes to next row
            if (i < 3 - 1) { //if it;s not the last row it prints horizontal separator between rows
                System.out.println("-----------");
            }
        }
        System.out.println(); //goes to next line after the board is printed
    }
    
    public boolean placeMarker(int row, int col, char symbol) { //places the marked symbol in the corresponding row and column
        if (row < 1 || row >= 4 || col < 1 || col >= 4) { //if it's beyond the board return false
            return false;
        }
        if (grid[row-1][col-1] != ' ') { //if their's already a symbol in the cell return false
            return false;
        }
        grid[row-1][col-1] = symbol; //else place the symbol in the corresponding row and column (row starts at 1 and column starts at 1)
        return true;
    } 

    public char[][] getBoard(){ //returns the 2d arrray (board)
        return grid;
    }

    public void reset(){ //resets the board by making all cells in the board empty by calling the initializeBoard 
        initializeBoard();
    }
}
