package test;

//입력된 층수를 검증하는 클래스
public class InputValidator {
    private final static String REGEX_PATTERN = "^(1[0-5]|[1-9])$";

    public static boolean validateInput(String input) {
        return input.matches(REGEX_PATTERN);
    }
}
