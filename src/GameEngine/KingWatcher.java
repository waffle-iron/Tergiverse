/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameEngine;
import static GameEngine.ConstantValues.*;

/**
 *
 * @author amcowden97
 */
public class KingWatcher {
    
    private boolean whiteAlive;
    private boolean blackAlive;
    
    public boolean isKingAlive(int alignment) throws Exception{
        switch (alignment) {
            case WHITE_SIDE:
                return getWhiteAlive();
            case BLACK_SIDE:
                return getBlackAlive();
            default:
                throw new Exception("Invalid Alignment");
        }
    }
     
    
    public void killKing(int alignment) throws Exception{
         switch (alignment) {
            case WHITE_SIDE:
                killWhite();
                break;
            case BLACK_SIDE:
                killBlack();
                break;
            default:
                throw new Exception("Invalid Alignment");
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
