package Validation;

public class PositionAlreadyGuessed extends InGameException {
    public PositionAlreadyGuessed(){
        super("Already guessed this position");
    }
}
