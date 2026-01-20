package BattleshipsTerminalView;

import BattleshipsModel.Board.Board;
import BattleshipsModel.Board.BoardPosition2D;

public class OutputBoard {


    //the "guess" board is how one player sees the other players board whose ships they are trying to hit
    //helps see what spaces have been guessed and what the results were
    public void outputGuessBoard(Board board){
        BoardPosition2D[][] positions = board.getPositions();
        int maxY = String.valueOf(positions[positions.length-1][0].getY()).length();

        makeHeader(positions[0],maxY);

        for (BoardPosition2D[] bs: positions){
            StringBuilder outputLine = getGuessOutputLine(bs,maxY);
            System.out.println(outputLine);
        }
    }


    //the "ship" board is helpful during setup for the player to see where they are placing their ships
    public void outputShipLocationBoard(Board board){
        BoardPosition2D[][] positions = board.getPositions();
        int maxY = String.valueOf(positions[positions.length-1][0].getY()).length();

        makeHeader(positions[0],maxY);

        for (BoardPosition2D[] bs: positions){
            StringBuilder outputLine = getShipOutputLine(bs,maxY);
            System.out.println(outputLine);
        }
    }

    private StringBuilder getGuessOutputLine(BoardPosition2D[] bs, int maxY) {
        StringBuilder outputLine = new StringBuilder();
        makeRowHeader(bs,maxY,outputLine);
        for (BoardPosition2D b: bs){
            switch(b.getStatus()){
                case "unselected":
                    outputLine.append(" . ");
                    break;
                case "missed":
                    outputLine.append(" o ");
                    break;
                case "hit":
                    outputLine.append(" x ");
                    break;
            }
        }
        return outputLine;
    }

    private StringBuilder getShipOutputLine(BoardPosition2D[] bs, int maxY) {
        StringBuilder outputLine = new StringBuilder();
        makeRowHeader(bs,maxY,outputLine);
        for (BoardPosition2D b: bs){
            if(b.checkIfHasPart()){
                outputLine.append(" x ");
            }else{outputLine.append(" . ");}
        }
        return outputLine;
    }

    private void makeHeader(BoardPosition2D[] startRow, int maxY){
        StringBuilder colTitles = new StringBuilder();
        StringBuilder separator = new StringBuilder();

        colTitles.append(" ".repeat(maxY+1));
        separator.append(" ".repeat(maxY+1));
        for (BoardPosition2D p: startRow){
            colTitles.append(" ").append(p.getCharX()).append(" ");
            separator.append("---");
        }
        System.out.println(colTitles);
        System.out.println(separator);
    }

    private void makeRowHeader(BoardPosition2D[] bs, int maxY, StringBuilder outputLine){
        String y = String.valueOf(bs[0].getY());
        if (y.length()<maxY){
            outputLine.append(" ".repeat(maxY - 1));
        }
        outputLine.append(bs[0].getY());
        outputLine.append("|");
    }
}
