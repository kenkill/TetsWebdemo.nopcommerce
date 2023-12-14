package core.utilities;

import constants.GlobalConstants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;

    public ConfigReader() {
        try {
            FileInputStream fileInputStream = new FileInputStream(GlobalConstants.propertyFilePath);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("Can not file the properties file");
        }
    }

    public String readConfigData(String data) {
        String configData = properties.getProperty(data);
        return configData;
    }

    public static void appendDataIntoFile(String data) {
        try {
            // Add or update properties
            properties.setProperty("customerId", data);

            // Save the modified properties back to the file
            FileOutputStream fileOutput = new FileOutputStream(GlobalConstants.propertyFilePath);
            properties.store(fileOutput, null);
            fileOutput.close();

            System.out.println("Data appended to the properties file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

