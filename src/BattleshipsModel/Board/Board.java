package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;
import Validation.InGameException;
import Validation.PositionValidator;

public class Board {
    private final int size;
    private BoardPosition2D[][] positions;
    private BattleshipsArray battleships;

    public Board(int size){
        this.size=size;
        setUpBoard();
        battleships = new BattleshipsArray();
    }

    public void setUpBoard(){
        positions = new BoardPosition2D[size][size];
        for (int i=1;i<size+1;i++){
            for (int j=1;j<size+1; j++){
                positions[i-1][j-1] = new BoardPosition2D(j,i);
            }
        }
    }

    public void addShip(Position2D position, boolean rotation) throws InGameException {
        if (PositionValidator.checkValidPosition(position)){
            battleships.addShip(position,rotation, this);}
    }

    public boolean checkIfCanAddShip(){
        return battleships.checkIfCanAddShip();
    }

    public boolean checkIfHits(Position2D point){
        if (PositionValidator.checkValidPosition(point)){
            return getBoardPosition2D(point).checkIfHit();
        }
        return false; //change later to throw error instead?
    }

    public BoardPosition2D getBoardPosition2D(Position2D position){
        return positions[position.getY()-1][position.getX()-1];
    }

    public int getNextShipLength(){return battleships.getNextShipLength();}

    public boolean checkIfPosHasShipPart(Position2D point){
        if (PositionValidator.checkValidPosition(point)){
            return getBoardPosition2D(point).checkIfHasPart();
        }
        return false;
    }

    public void setShipPart(Position2D position, ShipPart part){
        getBoardPosition2D(position).setPart(part);
    }

    public boolean checkIfDefeated(){return battleships.checkIfAllDefeated();}

    public BoardPosition2D[][] getPositions() {
        return positions;
    }

    public boolean checkAlreadyGuessed(Position2D position){
        return getBoardPosition2D(position).checkIfGuessed();
    }
}
