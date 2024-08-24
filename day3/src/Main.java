import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        // Mysql Database
        selectDemo();
        InsertDemo();
        updateDemo();
        deleteDemo();
    }

    public static void selectDemo() throws SQLException {
        String sqlString = "SELECT Code,Name,Continent,Region FROM country";

        DbHelper dbHelper = new DbHelper();
        try (Connection connection = dbHelper.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlString)) {
            System.out.println("Connected to MySQL database:!");

            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(resultSet.getString("Code"), resultSet.getString("Name"),
                        resultSet.getString("Continent"), resultSet.getString("Region")));
            }
            for (Country country : countries) {
                System.out.println(country.getName());
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
    }

    public static void InsertDemo() throws SQLException {
        String insertQuery = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?, ?, ?, ?)";

        DbHelper dbHelper = new DbHelper();
        try (Connection connection = dbHelper.getConnection();
                PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, "New York 2");
            statement.setString(2, "USA");
            statement.setString(3, "New York");
            statement.setInt(4, 8623000);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("A new record inserted successfully");
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
    }

    public static void updateDemo() throws SQLException {
        String updateQuery = "UPDATE city SET Population = ?, Name = ? WHERE ID = ?";

        DbHelper dbHelper = new DbHelper();
        try (Connection connection = dbHelper.getConnection();
                PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            // After The Purge Night...
            statement.setInt(1, 5000000);
            statement.setString(2, "New York Purge");
            statement.setInt(3, 4080);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("A record updated successfully");
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
    }

    public static void deleteDemo() throws SQLException {
        String deleteQuery = "DELETE FROM city WHERE ID = ?";

        DbHelper dbHelper = new DbHelper();
        try (Connection connection = dbHelper.getConnection();
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, 4081);
            int result = statement.executeUpdate();
            if (result > 0) {
                System.out.println("A record deleted successfully");
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }
    }
}