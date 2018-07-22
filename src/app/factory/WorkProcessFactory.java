package app.factory;

import app.model.WorkProcess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static app.util.Constants.PLEASE_PROVIDE_CORRECT_DATE_MESSAGE;
import static app.util.Constants.YYYY_MM_DD_DATE_FORMAT;

public final class WorkProcessFactory {

    public static final String NULL = "NULL";

    public static WorkProcess generate(String[] workProcess) {
        int employeeId = Integer.parseInt(workProcess[0]);
        int projectId = Integer.parseInt(workProcess[1]);

        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_DATE_FORMAT);

        try {
            Date dateFrom = formatter.parse(workProcess[2]);
            Date dateTo = null;
            if (!workProcess[3].equals(NULL)) dateTo = formatter.parse(workProcess[3]);

            return new WorkProcess(employeeId, projectId, dateFrom, dateTo);
        } catch (ParseException e) {
            System.err.println(PLEASE_PROVIDE_CORRECT_DATE_MESSAGE);
        }

        return null;
    }

    private WorkProcessFactory() {
    }
}
