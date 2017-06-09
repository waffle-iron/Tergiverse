package GameEngine;

import java.util.*;

public class ChessBoard {
	
	public final int BOARD_SIDE_LENGTH = 8;		//Used to Determine the board dimensions
	
	private int totalWhiteDead;					//Determines total White Pieces taken out of play
	private int totalBlackDead;					//Determines total Black Pieces taken out of play
	private Piece[][] chessBoard;
	private boolean playerTurn;					//False = White, True = Black
	
	public ChessBoard() {
		
		this.totalWhiteDead = 0;
		this.totalBlackDead = 0;
		this.chessBoard = new Piece[BOARD_SIDE_LENGTH][BOARD_SIDE_LENGTH];
		this.playerTurn = false;

		generatePieces();						//Creates piece objects at initialization
		
	}//End of default constructor for Chess_Board
	
	public boolean isSpaceOccupied(Coordinate location){
		
		return chessBoard[location.getX()][location.getY()] != null;
		
	}//End of public method isSpaceOccupied
	
	public boolean isSpaceWhiteOccupied(Coordinate location){
		
		if(isSpaceOccupied(location)){
			return chessBoard[location.getX()][location.getY()].getPieceColor();
			
		}//End of if
		else{
			return false;
			
		}//End of else
		
	}//End of public method isSpaceWhiteOccupied
	
	public boolean isSpaceBlackOccupied(Coordinate location){
		
		if(isSpaceOccupied(location)){
			return !chessBoard[location.getX()][location.getY()].getPieceColor();
			
		}//End of if
		else{
			return false;
			
		}//End of else
		
	}//End of public method isSpaceWhiteOccupied
	
	private void generatePieces(){

		Coordinate coordinate = new Coordinate(0,0);

		/*White Pawn Generation*/
		for(int index = 0; index < BOARD_SIDE_LENGTH; index++) {

			coordinate.setX(index);
			coordinate.setY(1);
			Pawn pawnWhite = new Pawn(coordinate, true, chessBoard);

		}//End of for loop

		/*Black Pawn Generation*/
		for(int index = 0; index < BOARD_SIDE_LENGTH; index++){

			coordinate.setX(index);
			coordinate.setY(6);
			Pawn pawnWhite = new Pawn(coordinate, false, chessBoard);

		}//End of for loop

		/*Knight Generation*/
		coordinate.setX(1);
		coordinate.setY(0);
		Knight knightWhite = new Knight(coordinate, true, chessBoard);

		coordinate.setX(6);
		coordinate.setY(0);
		Knight knightWhite = new Knight(coordinate, true, chessBoard);

		coordinate.setX(1);
		coordinate.setY(7);
		Knight knightBlack = new Knight(coordinate, false, chessBoard);

		coordinate.setX(6);
		coordinate.setY(7);
		Knight knightBlack = new Knight(coordinate, false, chessBoard);

		/*King Generation*/
		coordinate.setX(3);
		coordinate.setY(0);
		King kingWhite = new King(coordinate, true, chessBoard);

		coordinate.setX(3);
		coordinate.setY(7);
		King kingBlack = new King(coordinate, false, chessBoard);

		/*Bishop Generation*/
		coordinate.setX(2);
		coordinate.setY(0);
		Bishop bishopWhite = new Bishop(coordinate, true, chessBoard);

		coordinate.setX(5);
		coordinate.setY(0);
		Bishop bishopWhite = new Bishop(coordinate, true, chessBoard);

		coordinate.setX(2);
		coordinate.setY(7);
		Bishop bishopBlack = new Bishop(coordinate, false, chessBoard);

		coordinate.setX(5);
		coordinate.setY(7);
		Bishop bishopBlack = new Bishop(coordinate, false, chessBoard);

		/*Rook Generation*/
		coordinate.setX(0);
		coordinate.setY(0);
		Rook rookWhite = new Rook(coordinate, true, chessBoard);

		coordinate.setX(7);
		coordinate.setY(0);
		Rook rookWhite = new Rook(coordinate, true, chessBoard);

		coordinate.setX(0);
		coordinate.setY(7);
		Rook rookBlack = new Rook(coordinate, false, chessBoard);

		coordinate.setX(7);
		coordinate.setY(7);
		Rook rookBlack = new Rook(coordinate, false, chessBoard);

		/*Queen Generation*/
		coordinate.setX(4);
		coordinate.setY(0);
		Rook rookWhite = new Rook(coordinate, true, chessBoard);

		coordinate.setX(4);
		coordinate.setY(7);
		Rook rookBlack = new Rook(coordinate, false, chessBoard);

	}//End of public method generatePieces

	private void printChessBoard() {

		for(int row = 7; row < BOARD_SIDE_LENGTH; row--){

			for(int column = 0; column < BOARD_SIDE_LENGTH; column++){

				System.out.printf("| %s | ", chessBoard[row][column].getPieceSymbol);

			}//End of column

		}//End of row

	}//End of private method printChessBoard
	
}//End of public class Chess_Board
