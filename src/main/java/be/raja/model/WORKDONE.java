package be.raja.model;

import java.sql.Date;

public class WORKDONE {
    private int EmployeeId;
    private int ProjectId;
    private Date DATE;
    private double HoursWorked;
    private String Remarks;

    public WORKDONE() {
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }

    public double getHoursWorked() {
        return HoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        HoursWorked = hoursWorked;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }
    @Override
    public String toString() {
        return "WORKDONE { " +
                "EmployeeId=" + EmployeeId +
                ", ProjectId=" + ProjectId +
                ", DATE=" + DATE +
                ", HoursWorked=" + HoursWorked +
                '}';
    }

    }

