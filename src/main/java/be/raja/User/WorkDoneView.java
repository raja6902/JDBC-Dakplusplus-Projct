package be.raja.User;

import be.raja.model.DakPlus_Project;
import be.raja.model.Employee;
import be.raja.model.WORKDONE;
import be.raja.services.WorkDoneService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WorkDoneView {
    public static java.sql.Date DateInput() throws ParseException {
        WORKDONE wd = new WORKDONE();
        Scanner scanner = new Scanner(System.in);
        String input;
        Date DateInput = null;
        boolean result = false;
        do {
            System.out.println("Please type the  date when employee worked in (dd/MM/yyyy) format");
            input = scanner.nextLine();

            result = Pattern.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)", input);

            if (!result) {

                System.out.println("Please enter a valid .... date");
            } else {

                SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date ustartDate = dtf.parse(input);
                long ms = ustartDate.getTime();
                DateInput = new java.sql.Date(ms);
            }


        }
        while (!result);
        return DateInput;
    }


    public static void addWorkD(WorkDoneService wds) throws ParseException, SQLException, ClassNotFoundException {
        WORKDONE wd = new WORKDONE();

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the EmployeeId to be added");
        int EmployeeId = scan.nextInt();
        wd.setEmployeeId(EmployeeId);
        System.out.println("Please add the ProjectId to be added");
        int ProjectId = scan.nextInt();
        wd.setProjectId(ProjectId);
        wd.setDATE(DateInput());
        System.out.println("Please enter hoursWorked by employee");
        double HoursWorked = scan.nextDouble();
        wd.setHoursWorked(HoursWorked);
        wd.setRemarks(DateUtility.StringInput());
        wds.addWD(wd);
    }

    public static void updateWorkD(WorkDoneService wds) throws ParseException, SQLException, ClassNotFoundException {
        WORKDONE wd = new WORKDONE();

        Scanner scan = new Scanner(System.in);

        wd.setDATE(DateInput());
        System.out.println("Please enter hoursWorked by employee");
        double HoursWorked = scan.nextDouble();
        wd.setHoursWorked(HoursWorked);
        wd.setRemarks(DateUtility.StringInput());
        System.out.println("Please enter the EmployeeId to be updated");
        int EmployeeId = scan.nextInt();
        wd.setEmployeeId(EmployeeId);
        System.out.println("Please add the ProjectId to be updated ");
        int ProjectId = scan.nextInt();
        wd.setProjectId(ProjectId);
        wds.updateWD(wd);


    }
}
