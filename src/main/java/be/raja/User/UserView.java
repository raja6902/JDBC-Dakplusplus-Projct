package be.raja.User;

import be.raja.model.Employee;
import be.raja.services.EmployeeService;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;


public class UserView {

    public static void createEmployee(EmployeeService employeeService) throws SQLException, ClassNotFoundException, ParseException {
        Employee employee = new Employee();

        employee.setFirst_name(EmpView.fname());
        employee.setSir_name(EmpView.lname());
        employee.setTelephone_number(EmpView.phone());
        employee.setTelephone_number_ICE(EmpView.phoneInEmergency());
        employee.setBirth_date(EmpView.getBirthdate());
        employee.setSalary_per_month(EmpView.salary());
        employeeService.post(employee);

    }

    public static void updateEmployee(EmployeeService es) throws SQLException, ParseException, ClassNotFoundException {

        Employee employee = new Employee();

        employee.setId(EmpView.getid());
        employee.setFirst_name(EmpView.fname());
        employee.setSir_name(EmpView.lname());
        employee.setTelephone_number(EmpView.phone());
        employee.setTelephone_number_ICE(EmpView.phoneInEmergency());
        employee.setBirth_date(EmpView.getBirthdate());
        employee.setSalary_per_month(EmpView.salary());
        es.update(employee);


    }

    public static Date dateCon() {
        LocalDate birth_date = null;
        return Date.valueOf(birth_date);

    }

}