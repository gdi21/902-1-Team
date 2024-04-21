package test;

public class InputValidator {
    private final static String REGEX_PATTERN = "^(1[0-5]|[1-9])$";

    public static boolean validateInput(String input) {
        return input.matches(REGEX_PATTERN);
    }
}
