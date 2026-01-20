package BattleshipsTerminalView;

import BattleshipsModel.Board.Board;
import BattleshipsModel.Position.Position2D;
import Validation.InGameException;

public class OutputHandler {
    private static final OutputBoard outputBoard = new OutputBoard();

    //function calls for the class that manages outputting the board
    public static void outputGBoard(Board board){outputBoard.outputGuessBoard(board);}

    public static void outputSBoard(Board board){outputBoard.outputShipLocationBoard(board);}


    //initial questions for player
    public static void printIfStartGame(){
        System.out.println("Do you want to play a game of Battleships? ");
    }

    public static void printIfDefaultBoardSize(){
        System.out.println("Do you want to play with the default board size(10x10)?");
    }

    public static void printNewBoardSize(){
        System.out.println("What board size do you want to play with?");
    }


    //outputs based on current player
    public static void printPlayerGo(boolean player){
        if(player){
        System.out.println("It's Player 2's go to guess.");}
        else{System.out.println("It's Player 1's go to guess.");}
    }

    public static void printPlayerGoPlaceShip(boolean player){
        if(player){
            System.out.println("It's Player 2's go to place their ships.");}
        else{System.out.println("It's Player 1's go to place their ships.");}
    }

    public static void printPlayerWin(boolean player){
        System.out.println("Congratulations!");
        if(!player){System.out.println("Player 1 Wins!!!");
        }else{System.out.println("Player 2 Wins!!!");}
    }



    //set up ships
    public static void printAskShipPosition(int length){
        System.out.println("Please enter the coordinates of where you want to place a ship of length "+length+". \n Please enter your chosen coordinates in the form column-row(e.g. A1):");
    }

    public static void printAskShipRotation(){
        System.out.println("Please enter the direction of the ship you wish to place. \n Please enter H for horizontal and V for vertical:");
    }


    //guesses
    public static void printAskGuessPosition(){
        System.out.println("Please enter your guess coordinates in the form column-row(e.g. A1):");
    }

    public static void printHitMessage(Position2D position){
        System.out.println("You hit! There was a ship located at "+position.userReadable());
    }

    public static void printMissMessage(Position2D position){
        System.out.println("You missed :( There was no ship located at "+position.userReadable());
    }

    public static void printShipDefeated(){
        System.out.println("You have manged to take down one of the enemy ships!");
    }


    //general other
    public static void printYNQuestion(){System.out.println("Please enter Y/N:");}

    public static void printNumericQuestion(){System.out.println("Please enter a number (1 or higher):");}

    public static void printFeatureNotImplemented(){
        System.out.println("Unfortunately the feature you have tried to access is not implemented yet");
    }
    //this method can be improved to handle different errors differently
    public static void printInGameException(InGameException e){
        System.out.println(e.getMessage());
    }

}
