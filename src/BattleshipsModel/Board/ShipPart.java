package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;
import Validation.InvalidShipPlacement;

import static Validation.PositionValidator.checkValidPosition;

//separate class from position as position doesn't require hit attribute
public class ShipPart {
    private boolean hit;
    private Position2D position;
    private final Battleship ship;

    public ShipPart(Position2D position, Battleship ship, Board board) throws Exception {
        this.ship = ship;
        this.hit = false;
        checkIfValidShipPart(position,board);
    }

    public ShipPart(int x,int y, Battleship ship, Board board) throws Exception {
        this.ship = ship;
        this.hit = false;
        Position2D pos = new Position2D(x,y);
        checkIfValidShipPart(pos,board);
    }

    private void checkIfValidShipPart(Position2D pos, Board board) throws Exception {
        if(checkValidPosition(pos)&& !board.checkIfPosHasShipPart(pos)){
            this.position = pos;
            board.setShipPart(position, this);
        }else{throw new InvalidShipPlacement();}
    }

    public Position2D getPosition(){
        return position;
    }

    public Battleship getShip() {
        return ship;
    }

    public boolean getIfHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public void partIsHit(){
        setHit(true);
    }
}
