package BattleshipsController;

import BattleshipsModel.Position.Position2D;
import Validation.*;

import java.util.Scanner;

import static Validation.PositionValidator.*;

public class InputHandler {
    private static final Scanner scan = setScanner();

    public static Scanner setScanner(){
        try {
            return new Scanner(System.in);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getNextLine(){
        if (scan.hasNextLine()){return scan.nextLine();}
        return "";
    }

    public static Position2D getPosition() throws Exception {
        String nL = getNextLine();
        Position2D pos = null;
        if (nL.length() >=2 && isNumeric(nL.substring(1))){
            pos = new Position2D(nL.charAt(0), Integer.parseInt(nL.substring(1)));
        }
        if (checkValidPosition(pos)){
            return pos;
        }
        throw new InvalidPosition2D();
    }

    public static boolean getRotation() throws Exception {
        String nL = getNextLine();
        if (nL.length() ==1){
            if (nL.equalsIgnoreCase("H")){return false;}
            else if (nL.equalsIgnoreCase("V")){return true;}
        }

        throw new InvalidDirection();
    }

    public static boolean getYNAnswer() throws Exception{
        String nL = getNextLine();
        if (nL.length() ==1){
            if (nL.equalsIgnoreCase("N")){return false;}
            else if (nL.equalsIgnoreCase("Y")){return true;}
        }

        throw new InvalidYNAnswer();
    }



    public static int getNumericAnswer() throws Exception{
        String nL = getNextLine();
        if (isNumeric(nL)){return Integer.parseInt(nL);}

        throw new InvalidNumericAnswer();
    }
}
