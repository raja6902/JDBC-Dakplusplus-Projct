package be.raja.User;

import be.raja.model.Employee;
import be.raja.services.EmployeeService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class UserView{

    public static void createEmployee(EmployeeService employeeService) throws SQLException, ClassNotFoundException, ParseException {
        Scanner scan = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Please enter the first name of the employee");
        String first_name = scan.nextLine();
        System.out.println("Please enter the sir_name ");
        String sir_name = scan.nextLine();
        System.out.println("please enter the telephone number");
        String telephone_number = scan.nextLine();
        System.out.println("Please enter the telephone number in case of emergency");
        String telephone_number_ICE = scan.nextLine();
        System.out.println("Please enter birth_date in (yyyy-mm-dd) fromat");
         String birth_date = scan.next();
        System.out.println("Please enter the salary");
        double salary_per_month = scan.nextDouble();
         employeeService.post(employee);
        System.out.println("Employee has been added successfully");
    }

    public static Date dateCon(){
       LocalDate birth_date = null;
        java.sql.Date sqbirth_date = java.sql.Date.valueOf(birth_date);
      return Date.valueOf(birth_date);

    }
}