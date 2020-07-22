package be.raja.data;

import be.raja.User.DakPlusView;
import be.raja.User.DateUtility;
import be.raja.model.DakPlus_Project;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Date.valueOf;

public class DakPlus_ProjectDAO {
    public List<DakPlus_Project> incompleteProject() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM DakPlus_Project WHERE START_DATE < (NOW()+0) AND  END_DATE > (NOW()+0)");
        return parseDP_project(rs);
    }

    public List<DakPlus_Project> ProjectStartingToday() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM DakPlus_Project WHERE START_DATE BETWEEN (NOW()+1) AND (NOW()-1)");
        return parseDP_project(rs);
    }
    public void addProject(DakPlus_Project dps) throws SQLException, ClassNotFoundException {
        String str = "INSERT INTO DakPlus_Project(START_DATE,DESCRIPTION,PRICE,END_DATE) VALUES(?,?,?,?)";

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement pst = conn.prepareStatement(str);


        pst.setDate(1, dps.getStart_date());
        pst.setString(2, dps.getDescription());
        pst.setDouble(3,  dps.getPrice());
        pst.setDate(4,   dps.getEnd_date());
        int count =  pst.executeUpdate();
           if(count>= 1)
            System.out.println(count + " rows successfully added");
            else {
                System.out.println(" no data added");
           }

        }



        private List<DakPlus_Project> parseDP_project (ResultSet rs) throws SQLException {
            List<DakPlus_Project> result = new ArrayList<>();
            while (rs.next()) {
                DakPlus_Project dp = new DakPlus_Project();
                dp.setId(rs.getInt("Id"));
                dp.setStart_date(rs.getDate("START_DATE"));
                dp.setDescription(rs.getString("DESCRIPTION"));
                dp.setPrice(rs.getDouble("PRICE"));
                dp.setEnd_date(rs.getDate("END_DATE"));
                result.add(dp);

            }
            return result;

        }
    }
