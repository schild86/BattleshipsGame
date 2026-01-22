package Validation;

import BattleshipsModel.Position.Position2D;
/*PositionValidator aims to be able to check
whether a given point is within the designated board
using the board size decided by the user at the start of the game*/

//There is probably a better way to implement this class
public class PositionValidator {
    private static final int defaultSize =10;
    private static int size;

    public PositionValidator(int s){
        size=s;
    }

    public PositionValidator(){
        size=defaultSize;
    }

    public boolean checkValidPosition(Position2D point) throws InvalidPosition2D {
        if (point!=null){
            int x = point.getX();
            int y = point.getY();
            if(y >= 1 && y <= size && x >= 1 && x <= size){return true;}
        }
        throw new InvalidPosition2D();
    }

}
