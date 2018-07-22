package sample.util;

public final class Constants {

    public static final String SEED_FILE_PATH = System.getProperty("user.dir") + "\\data\\employees.txt";
    public static final String VERTICAL_BAR = "|";
    public static final String VERTICAL_BAR_SEPARATOR = "\\|";
    public static final String COMMA_SPACE_SEPARATOR = ", ";
    public static final String PLEASE_PROVIDE_CORRECT_DATE_MESSAGE = "Please, provide correct date.";
    public static final String YYYY_MM_DD_DATE_FORMAT = "yyyy-mm-dd";
    public static final int ZERO = 0;
    public static final int ONE = 1;

    public static final String NO_DATA_PROVIDED_MESSAGE = "No solution found, " +
            "please make sure provided employees data is not an empty file or there is at least one project in which contains" +
            "at least 2 employees.";

    private Constants() {
    }
}
