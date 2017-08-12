
package GameEngine;
import java.util.Stack;

public class GameBoard {
    public final int BOARD_LENGTH = 8;
    private Piece[][] chessArray;            //Represents chess board and piece location
    private PieceGenerator arrayInit;        //Fills chess board array with pieces
    private Coordinate whiteKingLocation;    //Used for Check and Checkmate methods
    private Coordinate blackKingLocation;    //Used for Check and Checkmate methods
    
    public GameBoard(){
        this.arrayInit = new PieceGenerator();
        this.chessArray = arrayInit.initializeChessArray();
        this.whiteKingLocation = new Coordinate(0,0);   //NEEDS TO BE CHANGED
        this.blackKingLocation = new Coordinate(0,0);   //NEEDS TO BE CHANGED
    }
    
    
    /**Purpose is to Allow Outside Classes to Interact with Pieces
     * @param location
     * @return Desired Piece at the Given Location: null if there is no piece
    */
    public Piece getPieceAt(Coordinate location){
        return chessArray[location.getX()][location.getY()];
    }
    
    
    /**Sees if the space at the given location is empty
     * @param location
     * @return true if empty, false otherwise
    */
    public boolean isEmptySpace(Coordinate location){
        return getPieceAt(location) == null;
    }
    
    
    /**Sees if the space at the given location is occupied with a black piece
    * @param location
    * @return true if black piece occupied, false otherwise
    */
    public boolean isBlackOccupiedSpace(Coordinate location){
        return getPieceAt(location).getPieceColor() == false;
    }
    
    
    /**Sees if the space at the given location is occupied with a white piece
     * @param location
     * @return true if white piece occupied, false otherwise
    */
    public boolean isWhiteOccupiedSpace(Coordinate location){
        return getPieceAt(location).getPieceColor();
    }
    
    
    /**Sees if the space at the given location is occupied with the wanted color
     * @param location
     * @param color
     * @return true if location is a piece of desired color, false if otherwise
    */
    public boolean isDesiredOccupiedSpace(Coordinate location, boolean color){
        return getPieceAt(location).getPieceColor() == color;
    }
    
    
    /**Purpose is to complete the final step in the piece movement process by assigning the
    specified Piece to the new location after move validation methods
     * @param initialLocation
     * @param newLocation
     * @return boolean: true if the move is sucessful, false otherwise
    */
    public boolean movePiece(Coordinate initialLocation, Coordinate newLocation){
        int oldX = initialLocation.getX();
        int oldY = initialLocation.getY();
        int newX = initialLocation.getX();
        int newY = initialLocation.getY();
        
        chessArray[newX][newY] = chessArray[oldX][oldY];
        killPiece(initialLocation);
        return true;
    }
    
    
    /**Purpose is to check if the desired move location is within the board and the space
    is not occupied by a Piece of the same color
     * @param location
     * @param color
     * @return true if the given piece is able to move to the location based on the board, false
     * if it cannot. NOTE: This does not involve move possibilites based on piece type, just occupied spaces and Bounds
    */
    public boolean hasNoBoardConflicts(Coordinate location, boolean color){
        int x = location.getX();
        int y = location.getY();
        
        if(!outOfBounds(location)){
            if(chessArray[x][y] == null){
                return true;
            }else{
                return chessArray[x][y].getPieceColor() != color;    //If the piece at x,y is the same color as
            }                                                        // move owner, their is a conflict with the move on the board
        }else{                                                 
            return false;
        }   
    }
    
    
    /**Checks to see if the given location is within the board range
    @param Coordinate location
    @return true if it is OUT OF BOUNDS, false if it is within the board
    */
    private boolean outOfBounds(Coordinate location){
        int x = location.getX();
        int y = location.getY();
        
        return !(x < BOARD_LENGTH && x >= 0 && y < BOARD_LENGTH && y >= 0); //If it is in bounds, return false
    }  
    
    
    /**Purpose is to convert the piece at the capture location to the color of the attacker
    *  @param Coordinate
    *  @param boolean
    */
    private void capturePiece(Coordinate captureLocation, boolean color){
        int x = captureLocation.getX();
        int y = captureLocation.getY();
       
        chessArray[x][y].getPieceAt(captureLocation).setColor(color);
    }
}
