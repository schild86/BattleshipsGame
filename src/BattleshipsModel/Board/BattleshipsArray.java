package BattleshipsModel.Board;

import BattleshipsModel.Position.Position2D;

public class BattleshipsArray {
    private Battleship[] battleships;
    private int[] lengths;
    //holds the value of the next free index in the array
    //and lines up with the next length for a ship
    private int nextShip;

    protected BattleshipsArray(){
        setDefaultLengths();
        //as there are 5 ships in the standard rules, 5 is hardcoded here
        //this could be updated to allow the user to choose or to be based on number of lengths entered
        setUpBattleShips(5);
        nextShip = 0;
    }

    //according to the general rules these are the lengths of ships which are standard
    //could add another feature in future if users wanted different lengths
    protected void setDefaultLengths(){
        this.lengths = new int[]{5,4,3,3,2};
    }


    protected void setUpBattleShips(int num){
        battleships = new Battleship[num];
    }

    protected int getNextShipLength(){
        return lengths[nextShip];
    }

    protected void addShip(Position2D position, boolean rotation, Board board) throws Exception {
        //creating a battleship can throw an exception
        battleships[nextShip] = new Battleship(getNextShipLength(), position, rotation, board);
        nextShip+=1;
    }


    protected boolean checkIfCanAddShip(){
        return nextShip<lengths.length;
    }

    protected boolean checkIfHits(Position2D point){
        for (Battleship b: battleships){
            if(b.checkHit(point)){return true;}
        }
        return false;
    }

    protected boolean checkIfAllDefeated(){
        for(Battleship b: battleships){
            if (!b.checkDefeated()){return false;}
        }
        return true;
    }
}
