package tt;

public class player { //player class to represent a player in the game
    private char symbol;
    private String id; //private variables to store symbol and id of player
    
    public player(char symbol) { //constructor to tell which symbol the player is using
        this.symbol = symbol;
        this.id = "";
    }
    
    public player(char symbol, String id) { //constructor to tell which symbol the player is using and their id to identify them
        this.symbol = symbol;
        this.id = id;
    }
    
    public char getSymbol() { //returns symbol of player
        return symbol;
    }
    
    public void setSymbol(char symbol) { //sets the symbol of player
        this.symbol = symbol;
    }
    
    public String getId() { //returns id of player
        return id;
    }
    
    public void setId(String id) { //sets the id of player
        this.id = id;
    }
}
