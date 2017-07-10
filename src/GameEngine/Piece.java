package GameEngine;

import java.util.*;

public abstract class Piece {

	private final boolean pieceColor;
	protected String pieceSymbol;					//Used for debugging in print mode
	private final Coordinate initialLocation;		
	private Coordinate currentLocation;
	protected ChessBoard chessBoard;				//Allows interaction between pieces and the Chess Board object
	private boolean alive;						//Indicates piece availability for Chess Board and Grave Yard
	
	public Piece(Coordinate initialLocation, boolean pieceColor, ChessBoard chessBoard){
		
		this.pieceColor = pieceColor;
		this.initialLocation = initialLocation;
		this.currentLocation = initialLocation;
		this.chessBoard = chessBoard;
		this.alive = true;
		this.pieceSymbol = "V";
		
	}//End of default constructor for Piece class
	
	/*Getters and Setters for Piece Class*/
	
	public boolean getPieceColor(){ return this.pieceColor; }
	
	public Coordinate getInitalLocation(){ return this.initialLocation; }
	
	public Coordinate getCurrentLocation(){ return this.currentLocation; }
	
	public boolean isAlive(){ return this.alive; }
	
	public Coordinate setCurrentLocation(Coordinate newLocation){ return this.currentLocation = newLocation; }

	public String getPieceSymbol(){ return this.pieceSymbol; }

        public abstract boolean move(Coordinate newLocation);

}//End of public class Piece
