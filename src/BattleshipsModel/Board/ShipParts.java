package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;
import Validation.InGameException;

public class ShipParts {
    private ShipPart[] parts;

    public ShipParts(int length, Position2D startPos, boolean rotation, Battleship ship, Board board) throws InGameException {
        setUpShipParts(length, startPos, rotation, ship, board);
    }


    private void setUpShipParts(int length, Position2D startPos, boolean rotation, Battleship ship, Board board) throws InGameException {
        try{parts = new ShipPart[length];
        if (rotation) {
            for (int i =0; i<length; i++){
                parts[i] = new ShipPart(startPos.getX(), startPos.getY()+i, ship, board);
            }
        }else{
            for (int i =0; i<length; i++){
                parts[i] = new ShipPart(startPos.getX()+i, startPos.getY(), ship, board);
            }
        }
        } catch (InGameException e) {
            //is this necessary?
            parts = null;//remove all parts
            throw e;
        }
    }

    public boolean checkHit(Position2D point){
        for (ShipPart currentPart: parts){
            if (currentPart.getPosition().equals(point)){
                currentPart.partIsHit();
                return true;
            }
        }
        return false;
    }

    public boolean checkAllHit(){
        for (ShipPart currentPart: parts){
            if (!currentPart.getIfHit()){
                return false;
            }
        }
        return true;
    }
}
