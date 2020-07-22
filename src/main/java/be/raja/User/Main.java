package be.raja.User;

import be.raja.data.ConnectionFactory;
import be.raja.data.DakPlus_ProjectDAO;
import be.raja.model.DakPlus_Project;
import be.raja.model.Employee;
import be.raja.services.DakPlus_ProjectService;
import be.raja.services.EmployeeService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        Scanner scan = new Scanner(System.in);

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
                String fname = "";
                String lname = "";
                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter first name of employee or leave it blank");

                fname = scan.nextLine();
                System.out.println("please enter sir name of employee or leave it blank ");
                lname = scan.nextLine();

                    List<Employee> emp = employeeService.showDetails(fname, lname);
                    emp.forEach(System.out::print);

                }

            if (subChoice == 3) {
                Scanner scan = new Scanner(System.in);

                System.out.println("Please enter the Id of employee to be deleted");
                int id = scan.nextInt();
                //EmployeeService.getDelete(id);

            }
            if (subChoice == 4) {
              UserView.createEmployee(employeeService);
            }
            if (subChoice == 5) {
                Scanner scan = new Scanner(System.in);

                System.out.println("Id of the employee");
                int id = scan.nextInt();
                System.out.println("Please enter the first name of the employee");
                String first_name = scan.next();
                System.out.println("Please enter the sir_name ");
                String sir_name = scan.next();
                System.out.println("please enter the telephone number");
                String telephone_number = scan.next();
                System.out.println("Please enter the telephone number in case of emergency");
                String telephone_number_ICE = scan.next();
                 Date borth_date = DateUtility.getBirthdate();
                System.out.println("Please enter the salary");
                double salary_per_month = scan.nextDouble();

                EmployeeService.update(id);
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

                    List<Employee> employees = employeeService.getAge();
                    employees.forEach(System.out::println);
            }

        }

            if (mainChoice == 2) {
                DakPlus_ProjectService dps = new DakPlus_ProjectService();
                if (subChoice == 1) {
                    List<DakPlus_Project> dakplus = dps.incompleteProject();
                        dakplus.forEach(System.out::println);
                    }
                if(subChoice ==2 ){
                    List<DakPlus_Project> dakplus = dps.projectStartingtoday();
                    dakplus.forEach(System.out::println);

                }
                if(subChoice==3){
                    DakPlus_Project dpp = new DakPlus_Project();
                    DakPlusView.userInput(dps);
                    dps.addProject(dpp);





                }
                }
            }



        private static void showMenu () {
            System.out.println("0. Exit");
            System.out.println("1. employee");
            System.out.println("2. DakPlus_Project");
            System.out.println("3. Adding a new Projects");
        }

        private static void showSubMenu ( int choice){
            if (choice == 1) {
                System.out.println("0. Exit");
                System.out.println("1. Show all employee");
                System.out.println("2. Showing employee with First or Last name");
                System.out.println("3. deleting employee from list ");
                System.out.println("4. Adding new employee");
                System.out.println("5. Updating the Employee list");
                System.out.println("6 Wrong phone number listed");
                System.out.println("7. employee's birthday with in  next 7 days");
                System.out.println("8. Showing Employee's Age");

            }
            if (choice == 2) {
                System.out.println("1. Running Projects which has not been completed");
                System.out.println("2.Projects starting today");
                System.out.println("3. Adding a new Project");
            }
        }


        private static int requestIntInput ( int lower, int upper){
            Scanner scanner = new Scanner(System.in);
            int input = -1;
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


        private static void printResult (List < String > result) {
            result.forEach(System.out::println);
        }
    }








