package be.raja.data;

import be.raja.model.Employee;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {


    public List<Employee> getAllEmployee() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM employee");
        return parseEmployee(rs);

    }

    public static void post(String first_name, String sir_name, String telephone_number, String telephone_number_ICE, Date birth_date, double salary_per_month) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement posted = conn.prepareStatement("INSERT INTO employee (first_name, sir_name, " +
                    "telephone_number, " +
                    "telephone_number_ICE, birth_date, salary_per_month) VALUES( ?,?,?,?,?,?");
            preparedStatement.setString(1, "first_name");
            preparedStatement.setString(2, "sir_name");
            preparedStatement.setString(3,"telephone_number");
            preparedStatement.setString(4, "telephone_number_ICE");
            preparedStatement.setDate(5, birth_date);
            preparedStatement.setDouble(6, salary_per_month);
            posted.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Some thing went wrong");
        } finally {
            System.out.println("Insert completed..");

        }
    }

    public static void getDelete(int id) {
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            conn = ConnectionFactory.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        public List<Employee> showDetails(String fname, String lname) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM employee WHERE " + "first_name = ?" + " OR" + " sir_name = ?");
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            rs = preparedStatement.executeQuery();


        } catch (Exception e) {

            e.printStackTrace();

        }
        return parseEmployee(rs);

    }

    public void update(int id) throws SQLException, ClassNotFoundException {

        Employee emp = new Employee();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE employee SET" + "first_name = ? , " +
                "sir_name = ? , telephone_number = ? , telephone_number_ICE = ? birth_date = ? , " +
                "salary_per_month = ? WHERE id = ? ");

        preparedStatement.setString(1, emp.getFirst_name());
        preparedStatement.setString(2,   emp.getSir_name());
        preparedStatement.setString(3,  emp.getTelephone_number());
        preparedStatement.setString(3, emp.getTelephone_number_ICE());
        preparedStatement.setDate(4, (Date) emp.getBirth_date());
        preparedStatement.setDouble(5, emp.getSalary_per_month());

        preparedStatement.executeUpdate();
        System.out.println("UPDATE employee SET" + "first_name = ? , " +
                "sir_name = ? , telephone_number = ? , telephone_number_ICE = ? birth_date = ? , " +
                "salary_per_month = ? WHERE id = ? ");


    }

    public List<Employee> getWrongPhoneNumber() throws SQLException, ClassNotFoundException {
        String string = "SELECT *  FROM employee WHERE telephone_number  NOT LIKE '04%' OR LENGTH(telephone_number) < 10 ";

        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(string);
        return parseEmployee(rs);
    }

    public List<Employee> getAge() throws SQLException, ClassNotFoundException {
        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * ,floor(DATEDIFF (NOW(), birth_date)/365) AS age FROM employee");
        return parseEmployee(rs);

    }

    public List<Employee> getBirthday() throws SQLException, ClassNotFoundException {
        String string = "SELECT * FROM employee\n" +
                "WHERE DATE_FORMAT(birth_date, '%m-%d') >= DATE_FORMAT(NOW(), '%m-%d') AND " +
                "DATE_FORMAT(birth_date, '%m-%d') <= DATE_FORMAT((NOW() + INTERVAL + 7 DAY), '%m-%d') ";


        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(string);
        return parseEmployee(rs);

    }

    private List<Employee> parseEmployee(ResultSet rs) throws SQLException {
        List<Employee> result = new ArrayList<>();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirst_name(rs.getString("first_name"));
            emp.setSir_name(rs.getString("sir_name"));
            emp.setTelephone_number(rs.getString("telephone_number"));
            emp.setTelephone_number_ICE(rs.getString("telephone_number_ICE"));
            emp.setBirth_date(rs.getDate("birth_date"));
            emp.setSalary_per_month(rs.getDouble("salary_per_month"));
            result.add(emp);
        }
        return result;
    }
}
