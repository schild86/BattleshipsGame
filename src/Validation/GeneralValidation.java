package Validation;

public class GeneralValidation {
    //isNumeric function returns if every character in a string is an integer (0-9)
    //useful for input validation
    public static boolean isNumeric(String string){
        if(string==null){return false;}
        for(int i=0; i<string.length();i++){
            if (string.charAt(i)<48 || string.charAt(i)>57){return false;}
        }
        return true;
    }

    //isAlphabetic function returns if every character in a string is in alphabet(a-z,A-z)
    //useful for input validation
    public static boolean isAlphabetic(String string){
        if(string==null){return false;}
        for(int i=0; i<string.length();i++){
            char c = string.charAt(i);
            if (c<'A' || (c>'Z' && c<'a') || c>'z' ){return false;}
        }
        return true;
    }

    public static boolean isAlphabetic(char c){
        if (c<'A' || (c>'Z' && c<'a') || c>'z' ){return false;}
        return true;
    }
}
