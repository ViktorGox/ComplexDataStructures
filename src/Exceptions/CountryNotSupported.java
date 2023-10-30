package Exceptions;

public class CountryNotSupported extends Throwable {
    public CountryNotSupported(String errorMessage) {
        super(errorMessage);
    }
}
