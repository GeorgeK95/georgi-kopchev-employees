package sample.util;

import javafx.scene.text.Font;

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

    //Main class constants
    public static final String TEXT_FILES = "Text Files";
    public static final String TXT = "*.txt";
    public static final String EMPLOYEES_APP_NAME = "Employees App";
    public static final String ADDRESS_BOOK = "Address Book";
    public static final Font ARIAL = new Font("Arial", 20);
    public static final String EMPLOYEE_ID_1 = "Employee ID #1";
    public static final String FIRST_EMPLOYEE_ID = "firstEmployeeId";
    public static final String EMPLOYEE_ID_2 = "Employee ID #2";
    public static final String SECOND_EMPLOYEE_ID = "secondEmployeeId";
    public static final String PROJECT_ID_BIG = "Project ID";
    public static final String DAYS_WORKED_BIG = "Days Worked";
    public static final String PROJECT_ID_SMALL = "projectId";
    public static final String DAYS_WORKED_SMALL = "daysWorked";
    public static final String SELECT_FILE = "Select File";
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public static final int MIN_WIDTH = 100;
    public static final int MIN_WIDTH_2 = 200;
    public static final int SPACING = 5;
    public static final int TOP = 10;
    public static final int LEFT = 10;

    private Constants() {
    }
}
