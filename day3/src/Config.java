import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties properties;

    public Config() {
        this.properties = new Properties();
        loadProperties();
    }

    public void loadProperties() {
        // config.properties file in generealy located in /src/main/resources
        try (InputStream input = new FileInputStream("day3/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
