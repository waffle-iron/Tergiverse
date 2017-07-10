package GameEngine;

public class Knight extends Piece{

    public Knight(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){

        super(initialLocation,pieceColor,chessBoard);
        this.pieceSymbol = "N";
    }
}
