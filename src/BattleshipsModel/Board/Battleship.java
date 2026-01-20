package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;

import static BattleshipsTerminalView.OutputHandler.printShipDefeated;

public class Battleship {
    private final int length;
    //holds the position where the front of the ship is within the board
    private final Position2D startPosition;
    //an array(with extra features) that holds all the "ship parts" that make up the ship
    private ShipParts parts;
    private final boolean rotation; //0/false is horizontal, 1/true is vertical
    private boolean defeated; //true once all positions within the ship have been hit

    protected Battleship(int length, Position2D startPosition, boolean rotation, Board board) throws Exception {
        this.startPosition = startPosition;
        this.rotation = rotation;
        this.length = length;
        this.defeated = false;
        //the creation of new ship parts can throw an error (e.g. if ships cross over)
        this.parts = new ShipParts(this.length,this.startPosition,this.rotation, this, board);
    }

    protected boolean checkHit(Position2D point){
        return parts.checkHit(point);
    }

    protected boolean checkDefeated(){
        //if currently undefeated then check if now defeated
        if (!defeated){defeated = parts.checkAllHit();
            //if the ship has just changed to being defeated then tell player
            if(defeated){printShipDefeated();}
        }
        return defeated;
    }
}
