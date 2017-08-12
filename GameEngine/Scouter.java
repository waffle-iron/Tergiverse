/*Creator: Andrew Cowden
  Project Title: Tergiverse
  Date Created: 07/19/2017
  Date Last Modified: 08/11/2017
*/

/*----------Class Overview------------
This class servers as a representation of the game piece Scouter. Within this class are methods and attributes to represent
the possible movement patterns as well as storage for objects of the type Scouter. Note that this class only generates the
possible movement patterns and does not do movement validation. That is done through the GameBoard class. 
*/

package GameEngine;
import java.util.ArrayDeque;

public class Scouter extends Piece{
    
    public Bishop(boolean color, Coordinate initialLocation){
        super(color, initialLocation);
    }
    
    @Override
    public void generateMovePattern(){
        
        Coordinate currentLocation = this.getCurrentLocation();
        
        this.addToMoves(generateMovePattern(PLUSINDEX, ZEROINDEX, currentLocation));       //Incriment x coordinate
        this.addToMoves(generateMovePattern(MINUSINDEX, ZEROINDEX, currentLocation));      //Decriment x coordinate
        this.addToMoves(generateMovePattern(ZEROINDEX, PLUSINDEX, currentLocation));       //Incriment y coordinate
        this.addToMoves(generateMovePattern(ZEROINDEX, MINUSINDEX, currentLocation));      //Decriment y coordinate
    }
  
    private ArrayDeque<Coordinate> generateMovePattern(int indexPrimary, int indexSecondary, Coordinate initialLocation){
        //recursive implementation of movement patterns
    }
}
