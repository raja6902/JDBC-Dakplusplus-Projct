package be.raja.User;


import be.raja.model.DakPlus_Project;
import be.raja.services.DakPlus_ProjectService;

import java.sql.SQLException;
import java.text.ParseException;


public class DakPlusView {

    public static void userInput(DakPlus_ProjectService dps) throws ParseException, SQLException, ClassNotFoundException {
        DakPlus_Project dp = new DakPlus_Project();

        dp.setStart_date(DateUtility.startDateInput());
        dp.setDescription(DateUtility.StringInput());
        dp.setPrice(DateUtility.projectPrice());
        dp.setEnd_date(DateUtility.endDateInput());
        dps.addProject(dp);

    }

}



