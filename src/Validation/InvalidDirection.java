package Validation;

public class InvalidDirection extends InGameException {
    public InvalidDirection(){
        super("Not a valid direction");
    }
}
