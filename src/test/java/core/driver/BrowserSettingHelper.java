package core.driver;

import com.fasterxml.jackson.databind.JsonNode;
import core.utilities.JSonReader;
import org.openqa.selenium.Capabilities;

public class BrowserSettingHelper {
    public static DriverProperty getDriverProperty(String filePath, String sectionName) {
        DriverProperty driverProperty = new DriverProperty();
        try {
            JSonReader jSonReader = new JSonReader(filePath);
            JsonNode sectionNode = jSonReader.getJsonNode().get(sectionName);
            if (sectionNode == null) {
                throw new Exception("Section not found, return an empty string");
            }
            String mode = String.valueOf(sectionNode.get("mode"));
            String platform = String.valueOf(sectionNode.get("platform"));
            String driverType = String.valueOf(sectionNode.get("driver"));
            String remoteUrl = String.valueOf(sectionNode.get("remoteUrl"));
            Capabilities capabilities = (Capabilities) sectionNode.get("capabilities");
            String args = String.valueOf(sectionNode.get("arguments"));
            String provider = String.valueOf(sectionNode.get("provider"));

            driverProperty.setDriverType(driverType);
            driverProperty.setMode(mode);
            driverProperty.setPlatform(platform);
            driverProperty.setRemoteUrl(remoteUrl);
            driverProperty.setCapabilities(capabilities);
            driverProperty.setArguments(args);
            driverProperty.setProvider(provider);

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return driverProperty;
    }
}
