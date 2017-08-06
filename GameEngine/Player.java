/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;

/**
 *
 * @author amcowden97
 */
public class Player {
    
    private final boolean color;
    private final String playerName;
    private static playerCount;
    
    public Player(boolean color){
        this.color = color;
        this.playerCount++;
        this.playerName = "Player" + playerCount;
    }
    
    public boolean getColor(){
        return this.color;
    }
    
    public String getPlayerName(){
        return this.playerName;
    }
    
    /**Seeks to Give Each Player a Name of Their Choice
     * @param playerNumber 
     * @return String describing player name
     */
    public String promptPlayerName(int playerNumber){
        System.out.println("Please input a name for PLAYER" + playerNumber);
        Scanner playerNameScan = new Scanner(System.in);
        this.playerName = playerNameScan.nextLine();
        playerNameScan.close();
    }
    
}
