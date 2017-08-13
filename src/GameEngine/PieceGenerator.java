
package GameEngine;
import static GameEngine.ConstantValues.*;
import GameEngine.GamePieces.*;

public class PieceGenerator {
    
    public Piece[][] initializeGameArray(){
        Piece[][] tempBoard = new Piece[BOARD_LENGTH][BOARD_LENGTH];
        
        for(int index = 0; index < BOARD_LENGTH; index++){
            Coordinate trueCord = new Coordinate(index, 0);
            Coordinate falseCord = new Coordinate(index, BOARD_LENGTH - 1);
            
            Scouter battleScout = new Scouter(true, trueCord);
            Scouter fearScout = new Scouter(false, falseCord);
            
            tempBoard[index][0] = battleScout;
            tempBoard[index][BOARD_LENGTH - 1] = fearScout;
        }
        return tempBoard;
    }
}
