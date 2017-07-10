package GameEngine;

public class Queen extends Piece{

    public Queen(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){

        super(initialLocation,pieceColor,chessBoard);
        this.pieceSymbol = "Q";

    } 
}