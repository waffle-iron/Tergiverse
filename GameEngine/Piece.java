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

public abstract class Piece{  
    private final boolean pieceColor; 
    private final Coordinate initialLocation; 
    private Coordinate currentLocation;  
    
    public Piece(pieceColor, initialLocation){  
        this.pieceColor = pieceColor;  
        this.initialLocation = initialLocation;
    }
    
    public boolean getPieceColor(){
         return this.pieceColor;
    }  
    
    //Abstract Piece Methods public abstract getPieceDescription();
    public abstract getPieceDescription();
    
    public abstract move(Coordinate newLocation);
    
    private abstract validatePieceMove(Coordinate newLocation);} 
}

