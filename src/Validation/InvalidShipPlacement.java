package Validation;

public class InvalidShipPlacement extends InGameException {
    public InvalidShipPlacement(){
        super("Can't place a ship here");
    }
}
