package Validation;

public class InvalidShipPlacement extends CreatedException {
    public InvalidShipPlacement(){
        super("Can't place a ship here");
    }
}
