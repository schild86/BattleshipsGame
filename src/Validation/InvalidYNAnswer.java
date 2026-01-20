package Validation;

public class InvalidYNAnswer extends InGameException {
    public InvalidYNAnswer(){
        super("Not a valid answer");
    }
}
