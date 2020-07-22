package be.raja.User;

import be.raja.data.DakPlus_ProjectDAO;
import be.raja.model.DakPlus_Project;
import be.raja.services.DakPlus_ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DakPlusView {

    public static void userInput(DakPlus_ProjectService dps) throws ParseException, SQLException, ClassNotFoundException {
        DakPlus_Project dp = new DakPlus_Project();
        String description = DateUtility.StringInput();
        dp.setDescription(description);
        Date start_date = DateUtility.startDateInput();
        dp.setStart_date(start_date);
        double price = DateUtility.projectPrice();
        dp.setPrice(price);
        Date end_date = DateUtility.endDateInput();
        dp.setEnd_date(end_date);

            dps.addProject(dp);
        }

        }



