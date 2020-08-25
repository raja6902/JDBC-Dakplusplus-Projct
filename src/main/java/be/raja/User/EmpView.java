package be.raja.User;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmpView {

    public static String fname() {
        Scanner scan = new Scanner(System.in);
        String input = null;

        do {
            System.out.println("Please enter the first name of the employee");
            input = scan.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                System.out.println("This is not a valid name");

            }


        } while (input.isEmpty() || input.isBlank());
        return input;
    }

    public static String lname() {
        Scanner scan = new Scanner(System.in);
        String input = null;

        do {
            System.out.println("Please enter the sir_name of the employee");
            input = scan.nextLine();
            if (input.isEmpty() || input.isBlank()) {

            }


        } while (input.isEmpty() || input.isBlank());
        return input;


    }

    public static String phone() {
        Scanner scan = new Scanner(System.in);
        String input = null;
        boolean result = false;

        do {
            System.out.println("please enter phone number");
            input = scan.nextLine();
            result = Pattern.matches("^\\+?\\d{0,3}\\s?\\(?\\d{0,3}\\)?[-./ \\s]?\\d{3}[-./ \\s]?\\d{4}?", input);
            if (!result) {
                System.out.println("the phone number is not valid");
            }
        }
        while (!result);
        return input;
    }

    public static String phoneInEmergency() {
        Scanner scan = new Scanner(System.in);
        String input = null;
        boolean result = false;

        do {
            System.out.println("please enter phone number in case of emergency");
            input = scan.nextLine();
            result = Pattern.matches("^\\+?\\d{0,3}\\s?\\(?\\d{0,3}\\)?[-./ \\s]?\\d{3}[-./ \\s]?\\d{4}?", input);
            if (!result) {
                System.out.println("the phone number is not valid");
            }
        }
        while (!result);
        return input;


    }

    public static LocalDate getBirthdate() throws SQLException, ParseException {

        Scanner scan = new Scanner(System.in);
        String input = null;
        LocalDate birthDate = null;
        boolean result = false;


        do {
            System.out.println("\nPlease enter the birth_date, format: dd/mm/yyyy");
            input = scan.nextLine();
            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input);

            if (!result) {
                System.out.println("please enter a valid date");


            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                birthDate = LocalDate.parse(input, dtf);
                LocalDate now = LocalDate.now();
                int i = Period.between(birthDate, now).getYears();
                if (i < 18) {
                    System.out.println("you are under age for this job");
                }
            }
        }
        while (!result);
        return birthDate;
    }

    public static double salary() {
        Scanner scan = new Scanner(System.in);
        double input = 0;

        do {
            System.out.println("Please enter the salary");
            input = scan.nextDouble();
            if (input < 1) {
                System.out.println("This is not a valid entry");
            }
        } while (input < 1);
        return input;
    }

    public static int getid() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the id of employee");
        int i = scan.nextInt();

        return i;
    }


}
