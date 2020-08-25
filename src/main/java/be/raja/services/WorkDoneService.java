package be.raja.services;


import be.raja.data.DakPlus_ProjectDAO;
import be.raja.data.WORKDONEDAO;
import be.raja.model.WORKDONE;
import java.sql.SQLException;
import java.util.List;


public class WorkDoneService {
    private WORKDONEDAO workdonedao = new WORKDONEDAO();

    public List<WORKDONE> getAllEmployee(int ProjectId) throws SQLException, ClassNotFoundException {
        return workdonedao.getAllEmployee(ProjectId);
    }

    public double getProfitabilityByProject(int ProjectId) throws SQLException, ClassNotFoundException {
        return workdonedao.getProfitabilityByProject(ProjectId);
    }

    public List<WORKDONE> showDetails(int EmployeeId) throws SQLException, ClassNotFoundException {
        return workdonedao.showWorkdone(EmployeeId);
    }

    public void getDelete(WORKDONE wd) throws SQLException, ClassNotFoundException {
        workdonedao.getDelete(wd);
    }

    public void addWD(WORKDONE wd) throws SQLException, ClassNotFoundException {
    }

    public void updateWD(WORKDONE wd) throws SQLException, ClassNotFoundException {
        workdonedao.updateWD(wd);

    }

    public List<Integer> employeeIds(WORKDONE wd) throws SQLException, ClassNotFoundException {

        return workdonedao.employeeIds(wd);
    }

    public double getHoursPerProjByEmpl(int ProjectId, int EmployeeId) throws SQLException, ClassNotFoundException {
        return workdonedao.getHoursPerProjByEmpl(ProjectId, EmployeeId);
    }

    public double getSalaryPerHour(int EmployeeId) throws SQLException, ClassNotFoundException {
        return workdonedao.getSalaryPerHour(EmployeeId);
    }

    public double calculateProfit(int ProjectId, List<Integer> EmployeeId) throws SQLException, ClassNotFoundException {

        double result = 0;
        WORKDONE wd = new WORKDONE();
        DakPlus_ProjectDAO dpda = new DakPlus_ProjectDAO();
        double result1 = dpda.getPrice(ProjectId);
        System.out.println("The total revenue of a project: "+result1);
        for (Integer emp : EmployeeId) {
            double hourlyWage = getSalaryPerHour(emp);
            double hoursWorked = getHoursPerProjByEmpl(emp, ProjectId);

            result += (hourlyWage * hoursWorked);

        }
        return (result1 - result);

    }

}



