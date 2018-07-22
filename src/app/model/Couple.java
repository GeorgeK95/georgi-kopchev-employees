package app.model;

public class Couple {

    private int firstEmployeeId;
    private int secondEmployeeId;
    private int projectId;
    private long daysWorked;

    public Couple(int firstEmployeeId, int secondEmployeeId, int projectId, long daysWorked) {
        this.setFirstEmployeeId(firstEmployeeId);
        this.setSecondEmployeeId(secondEmployeeId);
        this.setProjectId(projectId);
        this.setDaysWorked(daysWorked);
    }

    public int getFirstEmployeeId() {
        return firstEmployeeId;
    }

    private void setFirstEmployeeId(int firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public int getSecondEmployeeId() {
        return secondEmployeeId;
    }

    private void setSecondEmployeeId(int secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    private void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public long getDaysWorked() {
        return daysWorked;
    }

    private void setDaysWorked(long daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public String toString() {
        return "Employee ID #1: " + firstEmployeeId +
                "\r\nEmployee ID #2: " + secondEmployeeId +
                "\nProject ID: " + projectId +
                "\nDays worked: " + daysWorked;
    }
}
