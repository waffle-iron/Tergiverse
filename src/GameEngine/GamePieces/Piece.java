 /*Creator: Andrew Cowden
 Project Title: Tergiverse
 Date Created: 07/19/2017
 Date Last Modified: 08/11/2017  
 */

/*----------Class Overview------------
This class servers as an abstract class that represents a generic game piece. 
It contains the basis for the validation of piece movement based on the piece type as well 
as methods to get the color of the piece and other aspects of the general piece definition.*/

package GameEngine.GamePieces;
import GameEngine.Coordinate;
import java.util.ArrayDeque;

public abstract class Piece{
    
    //Private Instance Variables
    private final ArrayDeque<Coordinate> moveList;
    private boolean clan;
    private Coordinate currentLocation;
    
    
    public Piece(boolean clan, Coordinate initialLocation){
        this.clan = clan;
        this.currentLocation = initialLocation;
        this.moveList = new ArrayDeque();
    }
    
	
	/**
	* This method returns the player's clan of the game piece
	* @return boolean
	*/
    public boolean getClan(){
        return this.clan;
    }
 	
	
	/**
	* This will allow for the player clan of the game piece
	* to be changed in the event of a capture
	* @param clan
	*/
    public void setClan(boolean clan){
      	this.clan = clan;
    }
    
    
	/**
	* Allows for the current location of the piece to be 
	* changed when the piece moves
	* @param newLocation
	*/
    public void setCurrentLocation(Coordinate newLocation){
        this.currentLocation = newLocation;
    }
    
    
	/**
	* Gets the current location of the game piece
	* @return Coordinate
	*/
    public Coordinate getCurrentLocation(){
        return this.currentLocation;
    }
    
	
    /**
	* Adds al of the possible moves of the game piece to the 
	* total encompassing move ArrayDeque for easier and 
	* faster processing of movement patterns
        * @param moves
	*/
    public void addToMoves(ArrayDeque<Coordinate> moves){
        this.moveList.addAll(moves);
    }
    
    
	/**
	* Clears all of the possible moves in the move list
	*/
    public void clearMoveList(){
         moveList.clear();
    }
    
	
    /**
	* Generates all possible movement locations of a given piece when called
	*/
    public abstract void generateMovePattern();
}
