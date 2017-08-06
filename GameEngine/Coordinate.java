
/*Creator: Andrew Cowden
  Project Title: Chess-Application
  Date Created: 07/19/2017
  Date Last Modified: 08/06/2017
*/

/*----------Class Overview------------
This class servers as a representation of a basic coordinate with attributes x and y. Basic operations can be done such as
setting and retrieving the x and y coordinate values. This class is used within much of the Chess Application to represent
the possible moves and movement patterns. 
*/
package GameEngine;

public class Coordinate{

	private int x;
	private int y;
	
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
		
	/*Getters and Setters for Coordinate Class*/
	
	public void setX(int x){ this.x = x; }
	
	public void setY(int y){ this.y = y; }
	
	public int getX(){ return this.x; }
	
	public int getY(){ return this.y; }
	
}//End of public class Coordinate
