package be.raja.User;


import be.raja.model.DakPlus_Project;
import be.raja.model.Employee;
import be.raja.model.WORKDONE;
import be.raja.services.DakPlus_ProjectService;
import be.raja.services.EmployeeService;
import be.raja.services.WorkDoneService;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

        int mainChoice;
        int subChoice = -1;


        do {
            showMenu();
            mainChoice = requestIntInput(0, 3);
            if (mainChoice != 0) {
                showSubMenu(mainChoice);
                subChoice = requestIntInput(0, 8);

                handleUserChoice(mainChoice, subChoice);


            }
        } while (mainChoice != 0 && subChoice != 0);
    }

    private static void handleUserChoice(int mainChoice, int subChoice) throws SQLException, ClassNotFoundException, ParseException {
        if (mainChoice == 1) {
            EmployeeService employeeService = new EmployeeService();

            if (subChoice == 1) {

                List<Employee> employees = employeeService.getAllEmployee();
                employees.forEach(System.out::println);
            }
            if (subChoice == 2) {
                String fname ;
                String lname ;
                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter first name of employee or leave it blank");

                fname = scan.nextLine();
                System.out.println("please enter sir name of employee or leave it blank ");
                lname = scan.nextLine();

                List<Employee> emp = employeeService.showDetails(fname, lname);
                emp.forEach(System.out::print);

            }

            if (subChoice == 3) {
                EmployeeService es = new EmployeeService();
                Employee employee = new Employee();
                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter the Id of employee to be deleted");
                int id = scan.nextInt();
                employee.setId(id);
                es.getDelete(employee);

            }
            if (subChoice == 4) {
                UserView.createEmployee(employeeService);
            }
            if (subChoice == 5) {
                UserView.updateEmployee(employeeService);
            }
            if (subChoice == 6) {
                List<Employee> employees = employeeService.getWrongPhoneNumber();
                employees.forEach(System.out::println);

            }
            if (subChoice == 7) {

                List<Employee> employees = employeeService.getBirthday();
                employees.forEach(System.out::println);

            }
            if (subChoice == 8) {

                List<Employee> employees = employeeService.getUnderAge();
                employees.forEach(System.out::println);
            }

        }

        if (mainChoice == 2) {
            DakPlus_ProjectService dps = new DakPlus_ProjectService();
            if (subChoice == 1) {
                List<DakPlus_Project> dakplus = dps.incompleteProject();  // List of ongoing projects.
                dakplus.forEach(System.out::println);
            }
            if (subChoice == 2) {
                List<DakPlus_Project> dakplus = dps.projectStartingtoday();
                dakplus.forEach(System.out::println);

            }
            if (subChoice == 3) {
                DakPlusView.userInput(dps);


            }
        }
        if (mainChoice == 3) {
            WorkDoneService wds = new WorkDoneService();
            if (subChoice == 1) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Please enter the ProjectId");
                int ProjectId = scan.nextInt();
                List<WORKDONE> wd = wds.getAllEmployee(ProjectId);
                wd.forEach(System.out::print);
            }
            if (subChoice == 2) {
                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter the projectId to get its profit");
                int ProjectId = scan.nextInt();
                double wd = wds.getProfitabilityByProject(ProjectId);
                System.out.println(wd);
            }
            if (subChoice == 3) {
                Scanner scan = new Scanner(System.in);
                System.out.println("Please enter the EmployeeId");
                int EmployeeId = scan.nextInt();

                List<WORKDONE> wd = wds.showDetails(EmployeeId);
                wd.forEach(System.out::println);
            }
            if (subChoice == 4) {
                WORKDONE wd = new WORKDONE();
                Scanner scan = new Scanner(System.in);


                System.out.println("Please enter the EmployeeId to be deleted from the table ");
                int EmployeeId = scan.nextInt();
                wd.setEmployeeId(EmployeeId);
                System.out.println("Please enter the ProjectId to be deleted");
                int ProjectId = scan.nextInt();
                wd.setProjectId(ProjectId);

                wds.getDelete(wd);

            }
            if (subChoice == 5) {
                WorkDoneView.addWorkD(wds);
            }
            if (subChoice == 6) {

                WorkDoneView.updateWorkD(wds);
            }
        }
    }


    private static void showMenu() {
        System.out.println("0. Exit");
        System.out.println("1. employee");
        System.out.println("2. DakPlus_Project");
        System.out.println("3. Adding a new Projects");
    }

    private static void showSubMenu(int choice) {
        if (choice == 1) {
            System.out.println("0. Exit");
            System.out.println("1. Show all employee");
            System.out.println("2. Showing employee with First or Last name");
            System.out.println("3. deleting employee from list ");
            System.out.println("4. Adding new employee");
            System.out.println("5. Updating the Employee list");
            System.out.println("6 List of Wrong mobile phone number i.e other than prefix 04 and less than 8 digits");
            System.out.println("7. employee's birthday with in  next 7 days");
            System.out.println("8. List of Employee's who are under 18 years old");

        }
        if (choice == 2) {
            System.out.println("1. Running Projects which has not been completed or ongoing projects");
            System.out.println("2.Projects starting today");
            System.out.println("3. Adding a new Project");
        }
        if (choice == 3) {
            System.out.println("1.  List of Top 3 employees worked in one project");
            System.out.println("2.  profitability of the project ");
            System.out.println("3.  List of Emloyee worked in which project");
            System.out.println("4.  deleting entry from WORKDONE table");
            System.out.println("5.   Adding a new row in a table");
            System.out.println("6.    Updating a existing record");
        }

    }

    private static int requestIntInput(int lower, int upper) {
        Scanner scanner = new Scanner(System.in);
        int input;
        do {
            try {
                System.out.println("Choose from Menu: ");
                input = scanner.nextInt();
            } catch (Exception e) {
                input = -1;
            }
            scanner.nextLine();
            if (input < lower || input > upper)
                System.out.println("this is not valid number");
        }
        while (input < lower || input > upper);
        return input;
    }


}









