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
public class KingWatcher {
    
    private boolean whiteAlive;
    private boolean blackAlive;
    
    public boolean isKingAlive(boolean clan){
        if(clan){
            return getWhiteAlive();
        }else{
            return getBlackAlive();
        }
    }
     
    
    public void killKing(boolean clan){
        if(clan){
            killWhite();
        }else{
            killBlack();
        }
    }
    
    
    private boolean getWhiteAlive(){
        return this.whiteAlive;
    }
    
    
    private boolean getBlackAlive(){
        return this.blackAlive;
    }
    
    
    private void killWhite(){
        this.whiteAlive = false;
    }
    
    
    private void killBlack(){
        this.blackAlive = false;
    }  
}
