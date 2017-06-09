package GameEngine;

public class King extends Piece{

    public King(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){

        super(initialLocation,pieceColor,chessBoard);
        this.pieceSymbol = "K";

    }//End of default constructor for King class

}//End of public class King