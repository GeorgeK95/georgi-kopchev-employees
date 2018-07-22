package app.exception;

import static app.util.Constants.NO_DATA_PROVIDED_MESSAGE;

public class SolutionNotFoundException extends RuntimeException {

    public SolutionNotFoundException() {
        super(NO_DATA_PROVIDED_MESSAGE);
    }
}
