package be.raja.User;

import be.raja.model.DakPlus_Project;

import java.sql.Date;
import java.text.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DateUtility {

    public static java.sql.Date startDateInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input;
        Date startDate = null;
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        boolean result ;
        do {
            System.out.println("Please type the start date of the project in (dd/MM/yyyy) format");
            input = scanner.nextLine();

            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input);

            if (!result) {

                System.out.println("Please enter a valid .... date");
            } else {
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date ustartDate = dtf.parse(input);
                long ms = ustartDate.getTime();
                startDate = new java.sql.Date(ms);
            }

            assert startDate != null;
            if (startDate.before(date)) {
                System.out.println("startDate can not be in the past");
                result = false;

            }

        }
        while (!result);
        return startDate;
    }

    public static Date endDateInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input5;
        Date endDate = null;
        boolean result;
        do {

            System.out.println("Please type the end date of the project in (dd/MM/yyyy) format");
            input5 = scanner.next();

            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input5);
            if (!result) {

                System.out.println("Please enter the valid date");
            } else {
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date uendDate = dtf.parse(input5);
                long ms = uendDate.getTime();
                endDate = new java.sql.Date(ms);
                if (endDate.before(startDateInput())) {
                    System.out.println("end date can not be before start date");
                }
            }

        }
        while (!result);
        return endDate;

    }


    public static double projectPrice() {
        Scanner scanner = new Scanner(System.in);
        double input;
        do {

            System.out.print("Enter a price of project ");
            input = scanner.nextDouble();
            if (input < 0)
                System.out.println("The price must be > 0");
        } while (input < 0);

        return input;
    }

    public static String StringInput() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter a text here: ");
        String input;
        input = scanner.nextLine();


        return input;
    }

}