
package GameEngine;
import java.util.Stack;

public class GameBoard implements GameBoard_Interface{
    
    private Piece[][] gameArrayArray;        //Represents game board and piece location
    private PieceGenerator arrayInit;        //Fills chess board array with pieces
    private Coordinate whiteKingLocation;    //Used for Corruption Generation Check
    private Coordinate blackKingLocation;    //Used for Corruption Generation Check
    
    public GameBoard(){
        this.arrayInit = new PieceGenerator();
        this.chessArray = arrayInit.initializeGameArray();
        this.whiteKingLocation = new Coordinate(0,0);   //NEEDS TO BE CHANGED
        this.blackKingLocation = new Coordinate(0,0);   //NEEDS TO BE CHANGED
    }
    
    
    /**
     * Purpose is to Allow Outside Classes to Interact with Pieces
     * @param location
     * @return Desired Piece at the Given Location: null if there is no piece
    */
    public Piece getPieceAt(Coordinate location){
        return chessArray[location.getX()][location.getY()];
    }
    
    
    /**
     * Gives the side alignment of the given location: "white" "black" "empty"
     * @param Coordinate
     * @return String
    */
    public int getSpaceAlignment(Coordinate location){
       Piece tempPiece = getPieceAt(location);
        
       if(tempPiece == null){               //Empty Space
           return EMPTY_SPACE;
       }else if(tempPiece.getAlignment()){  //White Occupied Space
           return WHITE_SIDE;
       }else{
           return BLACK_SIDE;               //Black Occupied Space
       }
    }
    
    
    /**
    * Activates Piece to either move to the wanted location or to take 
    * over the enemy piece at the wanted location
    * @param Coordinate
    * @param Coordinate
    * @return boolean
    */
    public booean activatePiece(Coordinate intialLocation, Coordinate newLocation){
        int attackerAlignment = getSpaceAlighnemt(initalLocation);    //Alighnment of active piece
        int newSpaceAlighment = getSpaceAlighnment(newLocation);      //Alighnment of specified location
        
        if(attackerAlighment == newSpaceAlighnment || outOfBounds(newLocation)){   //Out of Bounds or Same Color 
            return false;
        }else{
            if(newSpaceAlignment == EMPTY_SPACE){                    //Empty Position
                return movePiece(initalLocation, newLocation);
            }else{
                return capturePiece(newLocation, attackerAlighment); //Capture Enemy Piece
            }
        }
    }
    
    /**
    * Moves the Selected Piece to a new Location
    * @param Coordinate
    * @param Coordinate
    * @return boolean
    */
    private boolean movePiece(Coordinate initalLocation, Coordinate newLocation){
        int oldX = initialLocation.getX();
        int oldY = initialLocation.getY();
        int newX = initialLocation.getX();
        int newY = initialLocation.getY();
        
        gameArray[newX][newY] = gameArray[oldX][oldY];
        gameArray[oldX][oldY] = null;
        
        return true;
    }
    
    private boolean capturePiece(Coordinate location, int attackerAlighnment){
        getPieceAt(location).setAlighment(attackerAlighnment);
        return true;
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
