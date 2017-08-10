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
    
    private final static GameBoard mainGameBoard;
  
    public GameRunner(){
      this.mainGameBoard = new GameBoard();
    }
  
    public static void main(String[]args){
       
        Player player1 = new Player(true, promptPlayerName(1)); 
        Player player2 = new Player(false, promptPlayerName(2));
        
        while(!mainGameBoard.isCheckMate()){
            
            //Makes Player1 Move a Game Piece
            while(!promptMove(player1))){}
            
            //Makes Player2 Move a Game Piece
            while(!promptMove(player2))){}
        }
        gameEnd();
    }
    
    
    
    /**Asks the User for Piece to Move and location of Piece Movement. 
     * @param playerColor
     * @return True if move was a valid move: stays on board boundary,
     * is not taken or blocked by same color piece, is a possible move for 
     * that piece type.
     */
    private static boolean promptMove(Player player){
        Scanner scan = new Scanner(System.in);
        Coordinate initialLocation = new Coordinate();
        Coordinate newLocation = new Coordinate();
      
        //User Prompt and Validation Loop for Piece Selection
        do{
          System.out.println("Please enter the x coordinate of the piece you want to move...");
          initialLocation.setX(scan.nextInt());
          System.out.println("Please enter the y coordinate of the piece you want to move...");
          initialLocation.setY(scan.nextInt());
        }while(!mainGameBoard.isDesiredOccupiedSpace(initialLocation, player.getColor()));
      
        //User Prompt and Validation Loop for Desired Piece Movement
        do{
          System.out.println("Please enter desired x coordinate...");
          newLocation.setX(scan.nextInt());
          System.out.println("Please enter desired y coordinate...");
          newLocation.setY(scan.nextInt());
        }while(!mainGameBoard.hasNoBoardConflicts(newLocation, player.getColor()));
      
        //Actual Movement of Piece and Validation
        if(mainGameBoard.getPieceAt(initialLocation).isValidMove(newLocation)){
            mainGameBoard.move(initialLocation, newLocation);
            return true;
        }else{
          error(invalidMovelocation);
          return false;
        }
    }
    
    private static void gameEnd(){
        
    }
}
