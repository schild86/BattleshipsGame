package BattleshipsController;

import Validation.PositionValidator;

import static BattleshipsTerminalView.OutputHandler.*;

public class MainGame {

    private void game2Player(){
        //this boolean variable indicates which players go it is
        //false = player 1 and true = player 2
        boolean currentPlayer = false;
        int size = getGameBoardSize();
        PositionValidator p = new PositionValidator(size);
        Player player1 = new Player(currentPlayer,size);
        Player player2 = new Player(!currentPlayer,size);
        player1.addShips();
        player2.addShips();
        while(!player1.checkDefeated()&&!player2.checkDefeated()){
            if (!currentPlayer){
                player1.makeGuess(player2);
            }else{player2.makeGuess(player1);}
            currentPlayer = !currentPlayer;
        }
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
        printIfDefaultBoardSize();
        boolean defaultSize= getYNAnswer();

        if(defaultSize){return 10;}
        else{printNewBoardSize();
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
            } catch (Exception e) {
                printException(e);
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
            } catch (Exception e) {
                printException(e);
            }
        }
    }


    void main(){
        //if the player chooses to start then a 2 player game is started
        //(as a player vs computer is not yet implemented)
        while (checkStart()){game2Player();}

    }
}
