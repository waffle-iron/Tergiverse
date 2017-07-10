package GameEngine;

public class ChessBoard {
	
    public final int BOARD_SIDE_LENGTH = 8;     //Used to Determine the board dimensions

    private int totalWhiteDead;			//Determines total White Pieces taken out of play
    private int totalBlackDead;			//Determines total Black Pieces taken out of play
    private Piece[][] pieceBoard;
    private boolean playerTurn;			//False = White, True = Black
	
    public ChessBoard() {

        this.totalWhiteDead = 0;
        this.totalBlackDead = 0;
        this.pieceBoard = new Piece[BOARD_SIDE_LENGTH][BOARD_SIDE_LENGTH];
        this.playerTurn = false;
    }
    
    public static void main(String[]args){
        
        ChessBoard gameBoard = new ChessBoard();
        
        gameBoard.generatePieces(gameBoard);
        
        gameBoard.printChessBoard();  
        
        gameBoard.pieceBoard[0][1].move(new Coordinate(0,2));
        
        gameBoard.printChessBoard();
    }

    public boolean isSpaceOccupied(Coordinate location){

        return pieceBoard[location.getX()][location.getY()] != null;
    }

    public boolean isSpaceWhiteOccupied(Coordinate location){

        if(isSpaceOccupied(location)){
                return pieceBoard[location.getX()][location.getY()].getPieceColor();
        }else{
                return false;
        }	
    }

    public boolean isSpaceBlackOccupied(Coordinate location){

        if(isSpaceOccupied(location)){
                return !pieceBoard[location.getX()][location.getY()].getPieceColor();
        }else{
                return false;
        }
    }

    private void generatePieces(ChessBoard chessBoard){

        Coordinate coordinate = new Coordinate(0,0);

        /*White Pawn Generation*/
        for(int index = 0; index < BOARD_SIDE_LENGTH; index++) {

                coordinate.setX(index);
                coordinate.setY(1);
                this.pieceBoard[index][1] = new Pawn(coordinate, true, chessBoard);

        }//End of for loop

        /*Black Pawn Generation*/
        for(int index = 0; index < BOARD_SIDE_LENGTH; index++){

                coordinate.setX(index);
                coordinate.setY(6);
                this.pieceBoard[index][6] = new Pawn(coordinate, false, chessBoard);

        }//End of for loop

        /*Knight Generation*/
        coordinate.setX(1);
        coordinate.setY(0);
        this.pieceBoard[1][0] = new Knight(coordinate, true, chessBoard);

        coordinate.setX(6);
        coordinate.setY(0);
        this.pieceBoard[6][0] = new Knight(coordinate, true, chessBoard);

        coordinate.setX(1);
        coordinate.setY(7);
        this.pieceBoard[1][7] = new Knight(coordinate, false, chessBoard);

        coordinate.setX(6);
        coordinate.setY(7);
        this.pieceBoard[6][7] = new Knight(coordinate, false, chessBoard);

        /*King Generation*/
        coordinate.setX(3);
        coordinate.setY(0);
        this.pieceBoard[3][0] = new King(coordinate, true, chessBoard);

        coordinate.setX(3);
        coordinate.setY(7);
        this.pieceBoard[3][7] = new King(coordinate, false, chessBoard);

        /*Bishop Generation*/
        coordinate.setX(2);
        coordinate.setY(0);
        this.pieceBoard[2][0] = new Bishop(coordinate, true, chessBoard);

        coordinate.setX(5);
        coordinate.setY(0);
        this.pieceBoard[5][0] = new Bishop(coordinate, true, chessBoard);

        coordinate.setX(2);
        coordinate.setY(7);
        this.pieceBoard[2][7] = new Bishop(coordinate, false, chessBoard);

        coordinate.setX(5);
        coordinate.setY(7);
        this.pieceBoard[5][7] = new Bishop(coordinate, false, chessBoard);

        /*Rook Generation*/
        coordinate.setX(0);
        coordinate.setY(0);
        this.pieceBoard[0][0] = new Rook(coordinate, true, chessBoard);

        coordinate.setX(7);
        coordinate.setY(0);
        this.pieceBoard[7][0] = new Rook(coordinate, true, chessBoard);

        coordinate.setX(0);
        coordinate.setY(7);
        this.pieceBoard[0][7] = new Rook(coordinate, false, chessBoard);

        coordinate.setX(7);
        coordinate.setY(7);
        this.pieceBoard[7][7] = new Rook(coordinate, false, chessBoard);

        /*Queen Generation*/
        coordinate.setX(4);
        coordinate.setY(0);
        this.pieceBoard[4][0] = new Queen(coordinate, true, chessBoard);

        coordinate.setX(4);
        coordinate.setY(7);
        this.pieceBoard[4][7] = new Queen(coordinate, false, chessBoard);

    }//End of public method generatePieces

    private void printChessBoard() {
        
        for(int row = 7; row > 0; row--){
            
                for(int column = 0; column < BOARD_SIDE_LENGTH; column++){
                        
                    if(pieceBoard[row][column] != null){
                        System.out.printf("| %s  ", pieceBoard[row][column].getPieceSymbol());
                    }else{
                        System.out.print("| |");
                    }
                }//End of column
            System.out.println();
        }//End of row

    }//End of private method printChessBoard
	
}//End of public class Chess_Board
