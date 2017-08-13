/*Creator: Andrew Cowden
  Project Title: Tergiverse
  Date Created: 07/19/2017
  Date Last Modified: 08/12/2017
*/

/*----------Class Overview------------
This class servers as a representation of the game board used to store
and physically move the game pieces. Its major attribute is the gameArray
which holds the actual pieces. The major methods are the execute piece method
and the move and capture piece methods*/


package GameEngine;

import static GameEngine.ConstantValues.*;
import GameEngine.GamePieces.*;

public class GameBoard{
    
    private final Piece[][] gameArray;         //Represents game board and piece location
    private final PieceGenerator arrayInit;   //Fills chess board array with pieces
    private final KingWatcher kingSpy;        //Keeps track of kings for corruption use
    
    public GameBoard(){
        this.arrayInit = new PieceGenerator();
        this.gameArray = arrayInit.initializeGameArray();
        this.kingSpy = new KingWatcher();
    }
    
    
    /**
     * Purpose is to Allow Outside Classes to Interact with Pieces
     * @param location
     * @return Desired Piece at the Given Location: null if there is no piece
    */
    public Piece getPieceAt(Coordinate location){
        return gameArray[location.getX()][location.getY()];
    }

    
    /**
     * Activates Piece to either move to the wanted location or to take 
     * over the enemy piece at the wanted location
     * @param initialLocation
     * @param newLocation
     * @return boolean
    */
    public boolean executePiece(Coordinate initialLocation, Coordinate newLocation){
        Piece attacker = getPieceAt(initialLocation);
        Piece defender = getPieceAt(newLocation);
        
        if(!outOfBounds(newLocation)){
            if(defender instanceof King){
                kingSpy.killKing(defender.getClan());
                movePiece(initialLocation, newLocation);
                
            }else if(defender == null){
                return movePiece(initialLocation, newLocation); 
                
            }else if(attacker.getClan() != defender.getClan()){
                tryCapturePiece(attacker, defender);
                return true;
            }
        }
        return false;
    }
    
    
    /**
    * Moves the Selected Piece to a new Location
    * @param Coordinate
    * @param Coordinate
    * @return boolean
    */
    private boolean movePiece(Coordinate initialLocation, Coordinate newLocation){
        int oldX = initialLocation.getX();
        int oldY = initialLocation.getY();
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        
        gameArray[newX][newY] = gameArray[oldX][oldY];
        gameArray[oldX][oldY] = null;
        
        return true;
    }
    
    
    /**
     * If the attacker king is alive the piece at the given location
     * is now owned by the attacker If not, it is just a normal move
     * @param location
     * @param attackerAlignment
     * @return boolean
     * @throws Exception 
     */
    private boolean tryCapturePiece(Piece attacker, Piece defender){
        if(kingSpy.isKingAlive(attacker.getClan())){
            defender.setClan(attacker.getClan());
            return true;    //Captured Piece
            
        }else{
            movePiece(attacker.getCurrentLocation(), defender.getCurrentLocation());
            return false;   //Did not capture, just killed
        }  
    }
    
    
    /**
    * Checks to see if the given location is within the board range
    * @param Coordinate location
    * @return true if it is OUT OF BOUNDS, false if it is within the board
    */
    private boolean outOfBounds(Coordinate location){
        int x = location.getX();
        int y = location.getY();
        
        return !(x < BOARD_LENGTH && x >= 0 && y < BOARD_LENGTH && y >= 0); //If it is in bounds, return false
    }  
}

