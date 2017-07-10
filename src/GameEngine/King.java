package GameEngine;

public class King extends Piece{

    public King(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){
        super(initialLocation,pieceColor,chessBoard);
        this.pieceSymbol = "K";
    }
}