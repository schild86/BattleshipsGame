package BattleshipsController;

import BattleshipsModel.Position.Position2D;
import Validation.*;

import java.util.Scanner;

import static Validation.GeneralValidation.isNumeric;
import static Validation.PositionValidator.*;

public class InputHandler {
    private static final Scanner scan = setScanner();

    //handles setting up the initial scanner of the terminal
    private static Scanner setScanner(){
            try {
                return new Scanner(System.in);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
    }

    //reads next input line in terminal
    //if there is no next line returns an empty string
    public static String getNextLine(){
        if (scan.hasNextLine()){return scan.nextLine();}
        return "";
    }

    //gets a position that the user entered in the terminal
    public static Position2D getPosition() throws InGameException {
        String nL = getNextLine();
        Position2D pos = null;
        //Examples of valid inputs: A1, B12
        //Have a letter followed by a series of numeric characters
        if (nL.length() >=2 && isNumeric(nL.substring(1))){
            //might need to add another check to see if first char is a letter
            pos = new Position2D(nL.charAt(0), Integer.parseInt(nL.substring(1)));
        }
        //Even if is a valid input, may not be a valid position if not on board grid
        if (checkValidPosition(pos)){
            return pos;
        }
        //is there a better way of doing this?
        //should this be in the PositionValidator class?
        throw new InvalidPosition2D();
    }

    /*gets a rotation that the user entered in the terminal
    Ships can either be placed horizontally or vertically on the board*/
    public static boolean getRotation() throws InGameException {
        String nL = getNextLine();
        if (nL.length() ==1){
            //H or h = horizontal
            //V or v = vertical
            if (nL.equalsIgnoreCase("H")){return false;}
            else if (nL.equalsIgnoreCase("V")){return true;}
        }
        //any other input is invalid
        throw new InvalidDirection();
    }

    //gets an answer to a yes/no question that the user entered in the terminal
    public static boolean getYNAnswer() throws InGameException {
        String nL = getNextLine();
        if (nL.length() ==1){
            if (nL.equalsIgnoreCase("N")){return false;}
            else if (nL.equalsIgnoreCase("Y")){return true;}
        }
        //if Y or y or N or n is not entered then invalid input
        throw new InvalidYNAnswer();
    }


    //gets a numeric answer that the user entered in the terminal
    public static int getNumericAnswer() throws InGameException {
        String nL = getNextLine();
        if (isNumeric(nL)){return Integer.parseInt(nL);}
        //if there are any not numeric chars (not 0-9) then invalid input
        throw new InvalidNumericAnswer();
    }
}
