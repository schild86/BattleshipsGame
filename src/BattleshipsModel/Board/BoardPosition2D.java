package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;

//different from a ship part as can have 3 possible states
//can either have not yet been guessed or have been selected and there was a ship part there
// or selected and there was no ship part
public class BoardPosition2D extends Position2D {
    private Status status;
    private ShipPart part;
    enum Status{HIT,MISSED,UNSELECTED}

    public BoardPosition2D(char charX, int y) {
        super(charX, y);
        status = Status.UNSELECTED;
    }

    public BoardPosition2D(int x, int y) {
        super(x, y);
        status = Status.UNSELECTED;
    }

    public void positionIsAHit(){
        status = Status.HIT;
    }

    public void positionIsAMiss(){
        status = Status.MISSED;
    }

    public String getStatus(){
        //change this later?
        return status.toString();
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
