package Validation;

//Class to use type testing to see if the error is specific to game rules
public class InGameException extends Exception{

    public InGameException(String message){
        super(message);
    }

    public InGameException(){
        super();
    }
}
