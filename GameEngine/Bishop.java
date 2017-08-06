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
    
    public Bishop(boolean color, Coordinate initialLocation){
        super(color, initialLocation);
    }
    
    
    public ArrayDeque<Coordinate> getMovementPatterns(){
        
    }
}
