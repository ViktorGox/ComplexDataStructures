package Utilities;

public class StringModification {
    public static String removeQuotes(String string) {
        if (string == null) {
            return null;
        }
        return string.replace("\"", "");
    }
}
