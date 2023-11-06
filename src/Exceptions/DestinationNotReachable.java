package Exceptions;

public class DestinationNotReachable extends Throwable {
    public DestinationNotReachable(String errorMessage) {
        super(errorMessage);
    }
}