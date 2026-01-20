package BattleshipsController;

import BattleshipsModel.Board.Board;
import BattleshipsModel.Position.Position2D;
import Validation.InGameException;
import Validation.PositionAlreadyGuessed;

import static BattleshipsTerminalView.OutputHandler.*;
//each "player" object has their own board and knows which boolean val corresponds to them
public class Player {
    private final Board playerBoard;
    private final boolean player;

    public Player(boolean player,int size){
        //instantiate the players board based on size
        playerBoard = new Board(size);
        this.player = player;
    }

    protected Board getPlayerBoard(){return playerBoard;}

    protected boolean getPlayerBool() {
        return player;
    }

    //add ships to their own board
    public void addShips(){
        printPlayerGoPlaceShip(player);
        outputShipBoard();
        while(playerBoard.checkIfCanAddShip()){
            try{
                Position2D position = getPositionForShip();
                boolean rotation = getRotationForShip();
                playerBoard.addShip(position, rotation);
            } catch (InGameException e){
                printInGameException(e);}
            outputShipBoard();
        }
    }

    //very similar to the method addShips
    // except no user input is asked for
    //instead a very basic positioning of ships
    public void addDefaultShips(){
        int i = 1;
        while(playerBoard.checkIfCanAddShip()){
            try{
                Position2D position = new Position2D(1, i);
                boolean rotation = false;
                playerBoard.addShip(position, rotation);
                i+=1;
            } catch (InGameException e){
                printInGameException(e);}
        }
        outputShipBoard();
    }

    public void checkGuess(Position2D position) throws InGameException {
        if(playerBoard.checkAlreadyGuessed(position)) {
            throw new PositionAlreadyGuessed();
        }else if(playerBoard.checkIfHits(position)){
            printHitMessage(position);
        }else{printMissMessage(position);}
        outputGuessBoard();
    }

    public void makeGuess(Player otherPlayer) {
        printPlayerGo(player);
        boolean acceptableGuess = false;
        while(!acceptableGuess) {
            try {
                Position2D pos = getPositionForGuess();
                otherPlayer.checkGuess(pos);
                acceptableGuess=true;
            } catch (InGameException e) {
                printInGameException(e);
            }
        }
    }

    public Position2D getPositionForShip() throws InGameException {
        printAskShipPosition(playerBoard.getNextShipLength());
        return InputHandler.getPosition();
    }

    public Position2D getPositionForGuess() throws InGameException {
        printAskGuessPosition();
        return InputHandler.getPosition();
    }

    public boolean getRotationForShip() throws InGameException {
        printAskShipRotation();
        return InputHandler.getRotation();
    }

    public void outputGuessBoard(){
        outputGBoard(playerBoard);
    }

    public void outputShipBoard(){
        outputSBoard(playerBoard);
    }

    public boolean checkDefeated(){return playerBoard.checkIfDefeated();}

    public void wins(){
        printPlayerWin(player);
    }
}
