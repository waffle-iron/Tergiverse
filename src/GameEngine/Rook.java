package GameEngine;

public class Rook extends Piece{

    public Rook(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){

        super(initialLocation,pieceColor,chessBoard);
        this.pieceSymbol = "R";

    }
}
