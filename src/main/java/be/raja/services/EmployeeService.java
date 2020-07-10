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

    public static void getDelete(int id) {


    }

    public static void post(String fname, String lname, String phno, String phice, Date birth_date, double salary) {

    }

    public static void update(int id) throws SQLException, ClassNotFoundException {

    }

    public List<Employee> getWrongPhoneNumber() throws SQLException, ClassNotFoundException {
        return employeeDAO.getWrongPhoneNumber();
    }

    public List<Employee> getBirthday() throws SQLException, ClassNotFoundException {
        return employeeDAO.getBirthday();
    }

    public List<Employee> getAge() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAge();
    }
    }
