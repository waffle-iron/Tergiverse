 /*Creator: Andrew Cowden
 Project Title: Chess-Application
 Date Created: 07/19/2017
 Date Last Modified: 07/24/2017  
 */

/*----------Class Overview------------
This class servers as an abstract class that represents a generic chess piece. 
It contains thebasis for the validation of piece movement based on the piece type as well 
as methods to get the color of the piece and other aspects of the general piece definition.*/

package GameEngine;
import java.util.ArrayDeque;

public abstract class Piece{
    
    //Private Instance Variables
    private final boolean pieceColor;
    private final Coordinate initialLocation;
    private final ArrayDeque<Coordinate> moveList;
    private Coordinate currentLocation;
    
    
    public Piece(boolean pieceColor, Coordinate initialLocation){
        this.pieceColor = pieceColor;
        this.initialLocation = initialLocation;
        this.currentLocation = initialLocation;
        this.moveList = new ArrayDeque();
    }
    
    public boolean getPieceColor(){
        return this.pieceColor;
    }
    
    
    public void setCurrentLocation(Coordinate newLocation){
        this.currentLocation = newLocation;
    }
    
    
    public Coordinate getCurrentLocation(){
        return this.currentLocation;
    }
    
    
    public Coordinate getInitialLocation(){
        return this.initialLocation;
    }
    
    
    public void addToMoves(ArrayDeque<Coordinate> moves){
        this.moveList.addAll(moves);
    }
    
    
    public void clearMoveList(){
         moveList.clear();
    }
    
    
    public abstract void generateMovePattern();
}
