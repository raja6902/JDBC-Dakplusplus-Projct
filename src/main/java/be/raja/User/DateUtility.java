package be.raja.User;

import java.sql.Date;
import java.sql.SQLException;
import java.text.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DateUtility {

    public static java.sql.Date getBirthdate() throws SQLException {

        Scanner in = new Scanner(System.in);
        String input;
        java.util.Date utilDay = null;

        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("\nPlease enter the birth_date, format: yyyy-mm-dd");
        while (utilDay == null) {
            try {
                input = in.next();
                utilDay = (java.util.Date) df.parse(input);
            } catch (ParseException e) {
                System.out.println("Please enter a valid date! Format is yyyy/mm/dd");
            }
        }

        java.sql.Date sqlDate = new java.sql.Date(utilDay.getTime());
        return sqlDate;
    }

    public static java.sql.Date  startDateInput() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        Date startDate = null;
        LocalDate date = LocalDate.now();
        Date cdate = java.sql.Date.valueOf(date);
        boolean result;
        do {
            System.out.println("Enter a Start date here: (dd/mm/yyyy) ");
            input = scanner.next();
            System.out.println("the date you have put in is " + input);
            String input12 = scanner.nextLine();

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
        String input1 = null;
        Date endDate = null;
        boolean result;
        do {

            System.out.println("Please type the end date of the project in (dd/MM/yyyy) format");
            input1 = scanner.next();
            System.out.println("the date you have put in is " + input1);
            String input12 = scanner.nextLine();
            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input1);
            if (!result ) {

                System.out.println("Please enter the valid date");
            } else {
                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date uendDate = dtf.parse(input1);
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

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the price of project");
        double price = scan.nextDouble();

        return price;
    }

    public static String StringInput() {
        Scanner scanner = new Scanner(System.in);
        String input3 = null;

            System.out.println("Enter a text here: ");
            input3 = scanner.nextLine();


        return input3;
    }

}