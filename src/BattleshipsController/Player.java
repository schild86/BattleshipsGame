package BattleshipsController;

import BattleshipsModel.Board.Board;
import BattleshipsModel.Position.Position2D;
import Validation.PositionAlreadyGuessed;

import static BattleshipsTerminalView.OutputHandler.*;

public class Player {
    private Board playerBoard;
    private final boolean player;

    public Player(boolean player,int size){
        playerBoard = new Board(size);
        this.player = player;
    }

    public void addShips(){
        printPlayerGoPlaceShip(player);
        outputShipBoard();
        while(playerBoard.checkIfCanAddShip()){
            try{
                Position2D position = getPositionForShip();
                boolean rotation = getRotationForShip();
                playerBoard.addShip(position, rotation);
            } catch (Exception e){printException(e);}
            outputShipBoard();
        }
    }

    public void addDefaultShips(){
        int i = 1;
        while(playerBoard.checkIfCanAddShip()){
            try{
                Position2D position = new Position2D(1, i);
                boolean rotation = false;
                playerBoard.addShip(position, rotation);
                i+=1;
            } catch (Exception e){printException(e);}
        }
        outputShipBoard();
    }

    public void checkGuess(Position2D position) throws Exception {
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
            } catch (Exception e) {
                printException(e);
            }
        }
    }

    public Position2D getPositionForShip() throws Exception {
        printAskShipPosition(playerBoard.getNextShipLength());
        return InputHandler.getPosition();
    }

    public Position2D getPositionForGuess() throws Exception {
        printAskGuessPosition();
        return InputHandler.getPosition();
    }

    public boolean getRotationForShip() throws Exception {
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
