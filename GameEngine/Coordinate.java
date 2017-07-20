/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
