package Validation;

public class PositionAlreadyGuessed extends CreatedException{
    public PositionAlreadyGuessed(){
        super("Already guessed this position");
    }
}
