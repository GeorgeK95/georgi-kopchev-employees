package app.factory;

import app.model.WorkProcess;
import app.util.DateParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static app.util.Constants.NULL;
import static app.util.Constants.PLEASE_PROVIDE_CORRECT_DATE_MESSAGE;

public final class WorkProcessFactory {

    public static WorkProcess generate(String[] workProcess) {
        int employeeId = Integer.parseInt(workProcess[0]);
        int projectId = Integer.parseInt(workProcess[1]);

        String dateFormat = DateParser.determineDateFormat(workProcess[2]);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        try {
            Date dateFrom = formatter.parse(workProcess[2]);
            Date dateTo = null;
            if (!workProcess[3].equals(NULL)) {
                dateFormat = DateParser.determineDateFormat(workProcess[3]);
                formatter = new SimpleDateFormat(dateFormat);
                dateTo = formatter.parse(workProcess[3]);
            }

            return new WorkProcess(employeeId, projectId, dateFrom, dateTo);
        } catch (ParseException e) {
            System.err.println(PLEASE_PROVIDE_CORRECT_DATE_MESSAGE);
        }

        return null;
    }

    private WorkProcessFactory() {
    }
}
