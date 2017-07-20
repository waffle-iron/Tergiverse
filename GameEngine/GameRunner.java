/*Creator: Andrew Cowden
  Project Title: Chess-Application
  Date Created: 07/19/2017
  Date Last Modified: 07/19/2017
*/

/*----------Class Overview------------
This class servers as the main driver of the program containing the basic
logic that will serve as the turn mechanism to change which player's turn it 
is as well as to ensure that they make a move. In addition, this class will
serve to verify that the game has ended by calling appropriate methods such 
as check() and checkmate().
*/
package GameEngine;
import java.util.Scanner;

public class GameRunner {
    
    
    public static void main(String[]args){
        
        GameBoard mainGameBoard = new GameBoard();
        Player player1 = new Player(true, promptPlayerName(1)); 
        Player player2 = new Player(false, promptPlayerName(2));
        
        while(!mainGameBoard.isCheckMate()){
            
            //Makes Player1 Move a Game Piece
            while(!mainGameBoard.Move(promptMove(player1))){}
            
            //Makes Player2 Move a Game Piece
            while(!mainGameBoard.Move(promptMove(player2))){}
            
        }
        
        gameEnd();
    }
    
    /**Seeks to Give Each Player a Name of Their Choice
     * @param playerNumber 
     * @return String describing player name
     */
    private static String promptPlayerName(int playerNumber){
        
        System.out.println("Please input a name for PLAYER" + playerNumber);
        Scanner playerNameScan = new Scanner(System.in);
        return playerNameScan.nextLine();
    }
    
    /**Asks the User for Piece to Move and Where to Move it and Sees if it is 
     * Possible to Do So. 
     * @param playerColor
     * @return True if move was a valid move: stays on board boundary,
     * is not taken or blocked by same color piece, is a possible move for 
     * that piece type.
     */
    private static Coordinate promptMove(Player player){
        
        Scanner scan = new Scanner(System.in);
        String pieceOrigin;
        int xCoordinate = -1;
        int yCoordinate = -1;
        
        System.out.println(player.getPlayerName() + ": Please Choose a Piece..."
                + " EX: 1,2");
        pieceOrigin = scan.nextLine();
        
        //Converts String Characters to Integers
        //Input cannot contain numbers with > 1 digit in size w/o comma sperator
        if(pieceOrigin.charAt(1) == ',' && pieceOrigin.length() == 3){ 
             xCoordinate = (char)pieceOrigin.charAt(0);
             yCoordinate = (char)pieceOrigin.charAt(2);
        }else{
            invalidEntry(COORDINATE_INPUT_ERR);
        }
        return new Coordinate(xCoordinate, yCoordinate);
    }
}
