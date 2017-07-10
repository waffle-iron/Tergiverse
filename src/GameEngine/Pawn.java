package GameEngine;

import java.util.*;
//import Error File

public class Pawn extends Piece{

	private boolean hasMoved;
	private int incrementIndex;		/*If White: moves up the board = 1, If Black: moves down the board = -1
										Note will change with pawn promotion*/
	public Pawn(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){
	
		super(initialLocation, pieceColor, chessBoard);
		setIncrementIndex(pieceColor);
		this.hasMoved = false;
		this.pieceSymbol = "P";	
	}
	

    public boolean move(Coordinate newLocation){
	
		if(isValidMove(newLocation)){
			setCurrentLocation(newLocation);
			this.hasMoved = true;
                        return true;
		}else{
			//invalidMoveError();
                        System.out.println("Error");
                        return false;
		}
	}
	
	private boolean isValidMove(Coordinate newLocation) {
		
		Coordinate currentLocation = getCurrentLocation();
		int index = this.incrementIndex;
		Coordinate attackSide1 = new Coordinate(currentLocation.getX() + 1, currentLocation.getY() + index);
		Coordinate attackSide2 = new Coordinate(currentLocation.getX() - 1, currentLocation.getY() + index);
		
		if(!hasMoved){
			return openingMove(newLocation);
		}else if(chessBoard.isSpaceOccupied(attackSide1) || chessBoard.isSpaceOccupied(attackSide2)){
			return attack(newLocation);
                }else{
			return defaultMove(newLocation);
		}
	}
	
	private boolean openingMove(Coordinate newLocation){
		
		boolean color = getPieceColor();
		int newX = newLocation.getX();
		int newY = newLocation.getY();
		int oldX = this.getCurrentLocation().getX();
		int oldY = getCurrentLocation().getY();
		
		int xDifferences = newX - oldX;		/*X coordinates should not change making 
											difference 0 for valid move*/	
		int yDifferences = newY - oldY;		/*Y coordinates should be a difference of
											-2,-1,1,2 for a valid move based on color*/
		
		if(color && xDifferences == 0 && yDifferences <= 2 && yDifferences != 0){	//White Owner Case
			if(!chessBoard.isSpaceOccupied(newLocation)){
				return true;
			}else if(chessBoard.isSpaceBlackOccupied(newLocation)){
				///////////Killed piece case///////////
				return true;
			}else{
				return false;
			}
		}else if(!color && xDifferences == 0 && yDifferences >= -2 && yDifferences != 0){	//Black Owner Case
			if(!chessBoard.isSpaceOccupied(newLocation)){
				return true;
			}else if(chessBoard.isSpaceWhiteOccupied(newLocation)){
				///////////Killed piece case///////////
				return true;
			}else{
				return false;
			}
                }
                return false;
	}
	
	private boolean defaultMove(Coordinate newLocation) {
		
		boolean color = getPieceColor();
		int newX = newLocation.getX();
		int newY = newLocation.getY();
		int oldX = getCurrentLocation().getX();
		int oldY = getCurrentLocation().getY();
		
		int xDifferences = newX - oldX;		/*X coordinates should not change making 
											difference 0 for valid move*/	
		int yDifferences = newY - oldY;		/*Y coordinates should be a difference of
											-1 or 1 for a valid move based on color*/
		
		if(color && xDifferences == 0 && yDifferences == 1){		//White Owner Case
			if(!chessBoard.isSpaceOccupied(newLocation)){
				return true;
			}else if(chessBoard.isSpaceBlackOccupied(newLocation)){
				///////////Killed piece case///////////
				return true;
			}else{
				return false;
			}
			
		}else if(!color && xDifferences == 0 && yDifferences == -1){	//Black Owner Case
			if(!chessBoard.isSpaceOccupied(newLocation)){
				return true;
			}else if(chessBoard.isSpaceWhiteOccupied(newLocation)){
				///////////Killed piece case///////////
				return true;
			}else{
				return false;
			}
                }
                return false;
	}
		
	private boolean attack(Coordinate newLocation){
		
		boolean color = getPieceColor();
		int newX = newLocation.getX();
		int newY = newLocation.getY();
		int oldX = getCurrentLocation().getX();
		int oldY = getCurrentLocation().getY();
		
		int xDifferences = newX - oldX;		/*X coordinates should be a difference of
											1 or -1 or by 0 for a vaild move based on side of attack or default move*/	
		
		int yDifferences = newY - oldY;		/*Y coordinates should be a difference of
											-1 or 1 for a valid move based on color*/
		
		
		return false;
		
		
	}
	
	private void setIncrementIndex(boolean pieceColor){
		
		if(pieceColor){
			this.incrementIndex = 1;
		}else{
			this.incrementIndex = -1;
		}
	}
}

