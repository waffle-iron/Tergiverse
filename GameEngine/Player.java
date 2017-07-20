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
    
    public Player(boolean color, String playerName){
        this.color = color;
        this.playerName = playerName;
    }
    
    public boolean getColor(){
        return this.color;
    }
    
    public String getPlayerName(){
        return this.playerName;
    }
    
}
