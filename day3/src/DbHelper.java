import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {

    // Config Properties for database connection informations.
    private Config config;

    public DbHelper() {
        this.config = new Config();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(config.getProperty("db.url"), config.getProperty("db.user"),
                config.getProperty("db.password"));
    }

    public void showErrorMessage(SQLException exception) {
        System.err.println("Error: " + exception.getMessage());
        System.err.println("Error code: " + exception.getErrorCode());
    }
}
