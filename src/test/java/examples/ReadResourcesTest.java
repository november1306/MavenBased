package examples;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.PropertyReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ReadResourcesTest {

    @Test
    public void readPropertiesfromResourcesTest() {
        Properties properties = PropertyReader.getProperties();
        String browser = properties.getProperty("browser");
        assertEquals("chrome", browser);
    }

    @DisplayName("Read properties")
    @Description("read content of text.txt file")
    @Epic("jira ticket link")
    @Issue("JRE-81")
    @Test
    public void readTextFromResourcesTest() {
        String filePath = "attachments/text.txt";
        String text = "";
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            text = sb.toString();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assertTrue( text.contains("random text"), text + "is not what we expected");
    }

    @Test
    public void simplifiedResourceRead() {
        resourceStep();
        String filePath = "attachments/text.txt";
        String text = "";
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
            text = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assertTrue(text.contains("random text"), text + "is not what we expected");
    }

    @Step
    public void resourceStep() {
        System.out.println("step 1 in simplifiedResourceRead");
    }


}
