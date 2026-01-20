package BattleshipsController;

import Validation.InGameException;
import Validation.PositionValidator;

import static BattleshipsTerminalView.OutputHandler.*;

public class MainGame {
    private final int defaultSize = 10;

    private void game2Player(){
        //this boolean variable indicates which players go it is
        //false = player 1 and true = player 2
        boolean currentPlayer = false;
        /*this call asks the user to choose whether they want the default board size
        If not then asks them to enter a size*/
        int size = getGameBoardSize();
        /*Provides the user designated board size to the validator for
         later validation checks*/
        PositionValidator p = new PositionValidator(size);
        //each player needs to know their relevant boolean value and the board size for set up
        Player player1 = new Player(currentPlayer,size);
        Player player2 = new Player(!currentPlayer,size);
        //players add all of their ships in one go
        //then the other player places all of theirs
        player1.addShips();
        player2.addShips();

        //this is the main gameplay
        //while neither player has yet been defeated, the players keep guessing
        while(!player1.checkDefeated()&&!player2.checkDefeated()){
            //check which players go it is
            if (!currentPlayer){
                //player1 makes a guess on player 2s board
                player1.makeGuess(player2);
            }else{//player2 makes a guess on player 1s board
                player2.makeGuess(player1);
            }
            //swap which players go it is
            currentPlayer = !currentPlayer;
        }
        //declare whoever was not defeated as the winner
        if(player1.checkDefeated()){
            player2.wins();
        }else{player1.wins();}
    }

    private boolean checkStart(){
        //get output handler to output a message to user in terminal
        printIfStartGame();
        //tries to get an answer to if game should start
        return getYNAnswer();
    }


    private int getGameBoardSize(){
        //get outputHandler to ask if want default size
        printIfDefaultBoardSize();
        boolean isDefaultSize= getYNAnswer();

        if(isDefaultSize){return defaultSize;}
        else{//ask user to enter a different board size
            printNewBoardSize();
            return getNumericAnswer();
        }
    }

    private boolean getYNAnswer(){
        //repeats until a valid answer in entered
        while(true) {
            try {
                printYNQuestion();
                //getYN answer can throw exception (if invalid input attempted)
                // so try catch block needed
                return InputHandler.getYNAnswer();
            } catch (InGameException e) {
                printInGameException(e);
            }
        }
    }

    private int getNumericAnswer(){
        //repeats until a valid answer in entered
        while(true) {
            try {
                printNumericQuestion();
                //getNumeric answer can throw exception (if invalid input attempted)
                // so try catch block needed
                return InputHandler.getNumericAnswer();
            } catch (InGameException e) {
                printInGameException(e);
            }
        }
    }


    void main(){
        //If the player chooses to start then a 2 player game is started
        //(as a player vs computer is not yet implemented)
        while (checkStart()){game2Player();}

    }
}
