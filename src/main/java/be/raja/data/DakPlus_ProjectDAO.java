package be.raja.data;


import be.raja.model.DakPlus_Project;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public void addproject(DakPlus_Project dakp) throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO DakPlus_Project (START_DATE, DESCRIPTION, PRICE, END_DATE) VALUES (?,?,?,?)");
        statement.setDate(1, dakp.getStart_date());
        statement.setString(2, dakp.getDescription());
        statement.setDouble(3, dakp.getPrice());
        statement.setDate(4, dakp.getEnd_date());
        int res = statement.executeUpdate();
        if (res == 0) {
            System.out.println("record not inserted");

        } else {
            System.out.println("record inserted successfully");
        }
        statement.close();
        conn.close();

    }
    public double getPrice(int ProjectId) throws SQLException, ClassNotFoundException {
        double price = 0;
        DakPlus_Project dp = new DakPlus_Project();
        String str = "SELECT PRICE FROM DakPlus_Project WHERE Id = ?";
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(str);
        preparedStatement.setInt(1, ProjectId);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            price = rs.getDouble(1);
        }
        return price;
    }


    private static List<DakPlus_Project> parseDP_project(ResultSet rs) throws SQLException {
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
