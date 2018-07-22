package sample.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WorkProcess {

    private int employeeId;
    private int projectId;
    private Date dateFrom;
    private Date dateTo;

    public WorkProcess(int employeeId, int projectId, Date dateFrom, Date dateTo) {
        this.setEmployeeId(employeeId);
        this.setProjectId(projectId);
        this.setDateFrom(dateFrom);
        this.setDateTo(dateTo);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    private void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    private void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    private void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    private void setDateTo(Date dateTo) {
        if (dateTo == null) this.dateTo = new Date();
        else this.dateTo = dateTo;
    }

    public long getWorkingDays() {
        long diffInMillis = Math.abs(this.dateTo.getTime() - this.dateFrom.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }
}
