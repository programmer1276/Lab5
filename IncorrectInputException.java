package Exceptions;

public class IncorrectInputException extends RuntimeException {
    private String message;

    public IncorrectInputException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
