package mj.chess.utils;

public class StringUtil {
    private StringUtil() {

    }

    public static final String NEWLINE = System.getProperty("line.separator");

    public static StringBuilder appendNewLine(String input) {
        return new StringBuilder()
                .append(input)
                .append(NEWLINE);
    }
}
