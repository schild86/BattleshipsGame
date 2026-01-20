package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;

//different from a ship part as can have 3 possible states
//can either have not yet been guessed or have been selected and there was a ship part there
// or selected and there was no ship part
public class BoardPosition2D extends Position2D {
    private String status;
    private ShipPart part;

    public BoardPosition2D(char charX, int y) {
        super(charX, y);
        status = "unselected";
    }

    public BoardPosition2D(int x, int y) {
        super(x, y);
        status = "unselected";
    }

    public void positionIsAHit(){
        status = "hit";
    }

    public void positionIsAMiss(){
        status = "missed";
    }

    public String getStatus(){
        return status;
    }

    public void setPart(ShipPart part) {
        this.part = part;
    }

    public boolean checkIfHasPart(){
        return part!=null;
    }

    public boolean checkIfHit(){
        if (part!=null){
            part.partIsHit();
            positionIsAHit();
            return true;
        }
        positionIsAMiss();
        return false;
    }

    public boolean checkIfGuessed(){
        return !status.equals("unselected");
    }

}
