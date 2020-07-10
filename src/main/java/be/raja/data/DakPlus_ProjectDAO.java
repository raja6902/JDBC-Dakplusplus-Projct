package be.raja.data;

import be.raja.model.DakPlus_Project;
import be.raja.model.Employee;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DakPlus_ProjectDAO {
    public List<DakPlus_Project> incompleteProject() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM DakPlus_Project WHERE END_DATE > NOW()");
        return parseDP_project(rs);
    }

    private List<DakPlus_Project> parseDP_project(ResultSet rs) throws SQLException {
        List<DakPlus_Project> result = new ArrayList<>();
        while (rs.next()) {
            DakPlus_Project dp = new DakPlus_Project();
            dp.setId(rs.getInt("Id"));
            dp.setStart_date(rs.getDate("START_DATE"));
            dp.setDescription(rs.getString("DESCRIPTION"));
            dp.setPrice(rs.getDouble("PRICE"));
            dp.setEnd_date(rs.getDate("END_DATE"));


        }
        return result;

    }
}