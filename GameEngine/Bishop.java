/*Creator: Andrew Cowden
  Project Title: Chess-Application
  Date Created: 07/19/2017
  Date Last Modified: 08/06/2017
*/

/*----------Class Overview------------
This class servers as a representation of the chess piece Bishop. Within this class are methods and attributes to represent
the possible movement patterns as well as storage for objects of the type Bishop. Note that this class only generates the
possible movement patterns and does not do movement validation. That is done through the GameBoard class. 
*/
import java.util.ArrayDeque;
package GameEngine;

public class Bishop extends Piece {
    
    //Constants Deffinitions
    public int PLUSINDEX = 1;
    public int ZEROINDEX = 0;
    public int MINUSINDEX = -1;
    
    public Bishop(boolean color, Coordinate initialLocation){
        super(color, initialLocation);
    }
    
    public void generateMovePattern(){
        
        ArrayDeque<Coordinate> leftMoves = generateMovePattern(PLUSINDEX, ZEROINDEX);       //Incriment x coordinate
        ArrayDeque<Coordinate> rightMoves = generatMovePattern(MINUSINDEX, ZEROINDEX);      //Decriment x coordinate
        ArrayDeque<Coordinate> upMoves = generateMovePattern(ZEROINDEX, PLUSINDEX);         //Incriment y coordinate
        ArrayDeque<Coordinate> downMoves = generateMovePattern(ZEROINDEX, MINUSINDEX);      //Decriment y coordinate
    }
  
    private ArrayDeque<Coordinate> generateMovePattern(int indexPrimary, int indexSecondary, Coordinate initialLocation){
        //recursive implementation of movement patterns
    }
}
