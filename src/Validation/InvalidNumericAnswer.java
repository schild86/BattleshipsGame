package Validation;

public class InvalidNumericAnswer extends InGameException {
    public InvalidNumericAnswer(){
        super("Not a valid numeric answer");
    }
}
