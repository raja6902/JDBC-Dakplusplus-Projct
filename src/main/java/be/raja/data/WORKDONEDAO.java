package be.raja.data;

import be.raja.User.WorkDoneView;
import be.raja.model.WORKDONE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WORKDONEDAO {

    public List<WORKDONE> getAllEmployee(int ProjectId) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("Select *\n" +
                "From employee e\n" +
                "Inner Join WORKDONE w On e.id = w.EmployeeId\n" +
                "Where w.ProjectId = ?  " + "ORDER BY w.HoursWorked");

        preparedStatement.setInt(1, ProjectId);


        preparedStatement.setMaxRows(3);

        ResultSet rs = preparedStatement.executeQuery();


        return parseWD(rs);
    }


    public double getProfitabilityByProject(int ProjectId) throws SQLException, ClassNotFoundException {
        double profit = 0;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("Select dp.PRICE - SUM((salary_per_month/22/8)*w.HoursWorked)\n" +
                "From employee e\n" +
                "Inner Join WORKDONE w On e.id = w.EmployeeId\n" +
                "INNER JOIN DakPlus_Project AS dp ON w.ProjectId = dp.Id\n" +
                "Where w.ProjectId = ? ");

        preparedStatement.setInt(1, ProjectId);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            profit = rs.getDouble(1);
        }
        return profit;


    }

    public List<WORKDONE> showWorkdone(int EmployeeId) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM WORKDONE WHERE " + "EmployeeId = ?");
            preparedStatement.setInt(1, EmployeeId);

            rs = preparedStatement.executeQuery();


        } catch (Exception e) {

            e.printStackTrace();

        }
        return parseWD(rs);

    }

    public void getDelete(WORKDONE wd) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM WORKDONE WHERE EmployeeId=?  AND ProjectId=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, wd.getEmployeeId());
        statement.setInt(2, wd.getProjectId());

        int i = statement.executeUpdate();
        if (i > 0) {
            System.out.println(i + " rows deleted successfully");
        }


    }

    public void addWD(WORKDONE wd) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO WORKDONE(EmployeeId, ProjectId, DATE, HoursWorked, Remarks ) VALUES ( ?, ?, ?, ?, ?)");
        statement.setInt(1, wd.getEmployeeId());
        statement.setInt(2, wd.getProjectId());
        statement.setDate(3, wd.getDATE());
        statement.setDouble(4, wd.getHoursWorked());
        statement.setString(5, wd.getRemarks());

        int res = statement.executeUpdate();
        if (res == 0) {
            System.out.println("record not inserted");

        } else {
            System.out.println("record inserted successfully");
        }
        statement.close();
        conn.close();

    }

    public void updateWD(WORKDONE wd) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE WORKDONE SET Date=?, HoursWorked=?,Remarks=? WHERE EmployeeId =? AND ProjectId=?");

        statement.setDate(1, wd.getDATE());
        statement.setDouble(2, wd.getHoursWorked());
        statement.setString(3, wd.getRemarks());
        statement.setInt(4, wd.getEmployeeId());
        statement.setInt(5, wd.getProjectId());

        int res = statement.executeUpdate();
        if (res == 0) {
            System.out.println("record not inserted");

        } else {
            System.out.println("record inserted successfully");
        }
        statement.close();
        conn.close();

    }

    public List<Integer> employeeIds(WORKDONE wd) throws SQLException, ClassNotFoundException {


        List<Integer> employeeIdList = new ArrayList();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT EmployeeId FROM WORKDONE where ProjectId = ?");
        statement.setInt(1, wd.getProjectId());
        ResultSet rs = statement.executeQuery();


        while (rs.next()) {


            employeeIdList.add(rs.getInt("EmployeeId"));


        }


        return employeeIdList;
    }

    public double getHoursPerProjByEmpl(int ProjectId, int EmployeeId) throws SQLException, ClassNotFoundException {
        WORKDONE wd = new WORKDONE();
        double hoursworked = 0;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT SUM(HoursWorked) FROM WORKDONE WHERE EmployeeId=?  AND ProjectId=?");
        statement.setInt(2, EmployeeId);
        statement.setInt(1, ProjectId);
        ResultSet rs = statement.executeQuery();
       if(rs.next()){
           hoursworked = rs.getDouble(1) ;
       }
       return hoursworked;
    }

    public double getSalaryPerHour(int EmployeeId) throws SQLException, ClassNotFoundException {
        double hourlywage = 0;
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("Select (salary_per_month/22/8)\n" +
                "From employee e\n" +
                "Inner Join WORKDONE w On e.id = w.EmployeeId\n" +
                "Where w.EmployeeId = ? ");

        preparedStatement.setInt(1, EmployeeId);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            hourlywage = rs.getDouble(1);
        }
        return hourlywage;


    }

    public List<WORKDONE> parseWD(ResultSet rs) throws SQLException {

        List<WORKDONE> result = new ArrayList<>();
        while (rs.next()) {

            WORKDONE wd = new WORKDONE();

            wd.setEmployeeId(rs.getInt("EmployeeId"));
            wd.setProjectId(rs.getInt("ProjectId"));
            wd.setDATE(rs.getDate("DATE"));
            wd.setHoursWorked(rs.getDouble("HoursWorked"));
            wd.setRemarks(rs.getString("Remarks"));

            result.add(wd);

        }
        return result;

    }
}

