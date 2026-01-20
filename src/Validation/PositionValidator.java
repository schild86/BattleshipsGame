package Validation;

import BattleshipsModel.Position.Position2D;

public class PositionValidator {
    private static int size;

    public PositionValidator(int s){
        size =s;
    }

    public static boolean checkValidPosition(Position2D point){
        if (point!=null){
            int x = point.getX();
            int y = point.getY();
            return y >= 1 && y <= size && x >= 1 && x <= size;
        }
        return false;
    }

    public static boolean isNumeric(String string){
        if(string==null){return false;}
        for(int i=0; i<string.length();i++){
            if (string.charAt(i)<48 || string.charAt(i)>57){return false;}
        }
        return true;
    }
}
