package Exceptions;

public class DestinationNotReachable extends RuntimeException {
    public DestinationNotReachable(String errorMessage) {
        super(errorMessage);
    }
}