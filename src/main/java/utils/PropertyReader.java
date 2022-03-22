package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertyReader {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();

    public static String BROWSER;
    public static String BASEURL;

    private PropertyReader() {
    }

    public static Properties getProperties() {
        return prop;
    }

    private static Properties initProperties() {
        Properties prop = new Properties();

        InputStream inputStream = ClassLoader.getSystemResourceAsStream(CONFIG_PATH);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(" Could not load properties " + CONFIG_PATH);
        }

        BROWSER = prop.getProperty("browser");
        BASEURL = prop.getProperty("baseUrl");

        if (System.getProperty("browser") != null)
            BROWSER = System.getProperty("browser");

        return prop;
    }

}
