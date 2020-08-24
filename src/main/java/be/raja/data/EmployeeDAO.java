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

    public void post(Employee employee) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement("INSERT INTO employee(first_name, sir_name, telephone_number, telephone_number_ICE, birth_date, salary_per_month ) VALUES ( ?, ?, ?, ?, ?, ?)");
        statement.setString(1, employee.getFirst_name());
        statement.setString(2, employee.getSir_name());
        statement.setString(3, employee.getTelephone_number());
        statement.setString(4, employee.getTelephone_number_ICE());
        statement.setDate(5, java.sql.Date.valueOf(employee.getBirth_date()));
        statement.setDouble(6, employee.getSalary_per_month());
        int res = statement.executeUpdate();
        if (res == 0) {
            System.out.println("record not inserted");

        } else {
            System.out.println("record inserted successfully");
        }
        statement.close();
        conn.close();

    }

    public void getDelete(Employee employee) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM employee WHERE id=?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, employee.getId());
        int i = statement.executeUpdate();
        if (i > 0) {
            System.out.println(i + " rows deleted successfully");
        }


    }

    public List<Employee> showDetails(String fname, String lname) throws SQLException {

        Connection conn;
        PreparedStatement preparedStatement;
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
        assert rs != null;
        return parseEmployee(rs);

    }


    public List<Employee> getWrongPhoneNumber() throws SQLException, ClassNotFoundException {
        String string = "SELECT *  FROM employee WHERE telephone_number  NOT LIKE '04%' OR LENGTH(telephone_number) < 8 ";

        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(string);
        return parseEmployee(rs);
    }

    public List<Employee> getUnderAge() throws SQLException, ClassNotFoundException {


        String string = "SELECT * FROM employee WHERE (DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(birth_date,'%Y'))< 18";

        Connection conn = ConnectionFactory.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(string);
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

    public void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement statement = conn.prepareStatement(
                "UPDATE  employee SET first_name=?, sir_name=?, telephone_number=?, telephone_number_ICE=?, birth_date=?, salary_per_month=?  WHERE id =?");
        statement.setString(1, employee.getFirst_name());
        statement.setString(2, employee.getSir_name());
        statement.setString(3, employee.getTelephone_number());
        statement.setString(4, employee.getTelephone_number_ICE());
        statement.setDate(5, java.sql.Date.valueOf(employee.getBirth_date()));
        statement.setDouble(6, employee.getSalary_per_month());
        statement.setInt(7, employee.getId());
        int res = statement.executeUpdate();
        if (res == 0) {
            System.out.println("record not updated");

        } else {
            System.out.println(res + " number of record updated successfully");
        }
        statement.close();
        conn.close();
    }



    private static List<Employee> parseEmployee(ResultSet rs) throws SQLException {
        List<Employee> result = new ArrayList<>();
        while (rs.next()) {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setFirst_name(rs.getString("first_name"));
            emp.setSir_name(rs.getString("sir_name"));
            emp.setTelephone_number(rs.getString("telephone_number"));
            emp.setTelephone_number_ICE(rs.getString("telephone_number_ICE"));
            emp.setBirth_date(rs.getDate("birth_date").toLocalDate());
            emp.setSalary_per_month(rs.getDouble("salary_per_month"));
            result.add(emp);
        }
        return result;
    }
}

