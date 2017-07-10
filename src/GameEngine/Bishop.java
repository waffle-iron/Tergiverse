package GameEngine;

public class Bishop extends Piece{

    public Bishop(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){
        super(initialLocation,pieceColor,chessBoard);
        this.pieceSymbol = "B";
    }
}
