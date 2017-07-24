
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
    
    public Piece getPieceAt(Coordinate location){
        return chessArray[location.getX()][location.getY];
    }
    
    public boolean outOfBounds(Coordinate location){
        int x = location.getX();
        int y = location.getY();
        
        return !(x < BOARD_LENGTH && x >= 0 && y < BOARD_LENGTH && y >= 0); //If it is in bounds, return false
    }
                
}
