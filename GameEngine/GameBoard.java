
package GameEngine;

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
    @param Coordinate location
    @return Desired Piece at the Given Location: null if there is no piece
    */
    public Piece getPieceAt(Coordinate location){
        return chessArray[location.getX()][location.getY];
    }
    
    /**Sees if the space at the given location is empty
    @param Coordinate location
    @return true if empty, false otherwise
    */
    public boolean isEmptySpace(Coordiante location){
        return getPieceAt(location) == null;
    }
    
     /**Sees if the space at the given location is occupied with a black piece
     @param Coordinate location
     @return true if black piece occupied, false otherwise
     */
    public boolean isBlackOccupiedSpace(Coordinate location){
        return getPieceAt(location).getColor() == false;
    }
    
    /**Sees if the space at the given location is occupied with a white piece
    @param Coordinate location
    @return true if white piece occupied, false otherwise
    */
    public boolean isWhiteOccupiedSpace(Coordinate location){
        return getPieceAt(location).getColor();
    }
    
    /**Sees if the space at the given location is occupied with the wanted color
    @param Coordinate location, boolean color
    @return true if location is a piece of desired color, false if otherwise
    */
    public boolean isDesiredOccupiedSpace(Coordinate location, boolean color){
        return getPieceAt(location).getColor == color;
    }
    
    /**Purpose is to check if the desired move location is within the board and the space
    is not occupied by a Piece of the same color
    @param Coordinate location, boolean color
    @return true if the given piece is able to move to the location based on the board, false
    if it cannot.
    NOTE: This does not involve move possibilites based on piece type, just occupied spaces and Bounds
    */
    public boolean hasNoBoardConflicts(Coordinate location, boolean color){
        int x = location.getX();
        int y = location.getY();
        
        if(!outOfBounds(location)){
            if(chessArray[x][y] == null){
                return true;
            }else{
                return chessArray[x][y].getColor() != color;    //If the piece at x,y is the same color as
            }                                                   // move owner, their is a conflict with the move on the board
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
}
