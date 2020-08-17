package be.raja.services;

import be.raja.data.EmployeeDAO;
import be.raja.model.Employee;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public List<Employee> getAllEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllEmployee();
    }

    public List<Employee> showDetails(String fname, String lname) throws SQLException, ClassNotFoundException {
        return employeeDAO.showDetails(fname, lname);
    }

    public void getDelete(Employee employee) throws SQLException, ClassNotFoundException {
        employeeDAO.getDelete(employee);

    }

    public void post(Employee employee) throws SQLException, ClassNotFoundException {
        employeeDAO.post(employee);

    }

    public void update(Employee employee) throws SQLException, ClassNotFoundException {
        employeeDAO.updateEmployee(employee);

    }

    public List<Employee> getWrongPhoneNumber() throws SQLException, ClassNotFoundException {
        return employeeDAO.getWrongPhoneNumber();
    }

    public List<Employee> getBirthday() throws SQLException, ClassNotFoundException {
        return employeeDAO.getBirthday();
    }

    public List<Employee> getUnderAge() throws SQLException, ClassNotFoundException {
        return employeeDAO.getUnderAge();
    }
}
