package be.raja.User;

import java.sql.Date;
import java.sql.SQLException;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DateUtility {
    public static java.sql.Date  startDateInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        Date startDate = null;
        LocalDate date = LocalDate.now();
        Date cdate = java.sql.Date.valueOf(date);
        boolean result= false;
        do {
            System.out.println("Enter a Start date here: (dd/mm/yyyy) ");
            input = scanner.next();

            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input);

            if (!result) {

                System.out.println("Please enter a valid .... date");
            } else {
                SimpleDateFormat sdtf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date ustartDate = sdtf.parse(input);
                long ms = ustartDate.getTime();
                startDate = new java.sql.Date(ms);


            }
           if (startDate.before(cdate)){

               System.out.println("please enter  a valid date");
                result = false;
           }
        }
        while (!result);
        return startDate;
    }

    public static java.sql.Date endDateInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        Date endDate = null;
        boolean result = false;
        do {

            System.out.println("Please type the end date of the project in (dd/MM/yyyy) format");
            input = scanner.nextLine();

            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input);
            if (!result ) {

                System.out.println("Please enter the valid date");
            } else {
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date uendDate = dtf.parse(input);
                long ms = uendDate.getTime();
                endDate = new java.sql.Date(ms);

            }
            if (endDate.before(startDateInput())){
                System.out.println("End date can not be before start date");
                result = false;
            }

        } while (!result);
        return endDate;

    }

    public static double projectPrice() {
        Scanner scanner = new Scanner(System.in);
        double input = 0;
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
            String input = scanner.nextLine();


        return input;
    }

}