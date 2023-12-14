package core.driver;

import constants.GlobalConstants;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DriverManager {
//    private static Logger logger = Logger.getLogger(String.valueOf(DriverManager.class));
    private static final ThreadLocal<BaseDriver> driverController = new ThreadLocal<>();

    public static void initBrowser(String browser) {
        DriverProperty property = BrowserSettingHelper.getDriverProperty(GlobalConstants.JsonFilePath, browser);

        BaseDriver newDriver = createDriver(property);
        if (newDriver != null) {
            DriverManager.addDriver(newDriver);
        }
    }

    public static BaseDriver createDriver(DriverProperty property) {
        String browserPackage = "core.driver.%s.%s";
        String browserClass = "%s%sDriver";
        String packageName = String.format(browserPackage, property.getProvider().toLowerCase().replace("\"", ""), property.getDriverType().toLowerCase().replace("\"", ""));
        String className = String.format(browserClass, property.getMode().replace("\"", ""), property.getDriverType().replace("\"", ""));
        try {
            Method method;
            String fullClassName = packageName + "." + className;
            Class<?> cls = Class.forName(fullClassName);
            Constructor<?> constructor = cls.getDeclaredConstructor(DriverProperty.class);
            Object obj = constructor.newInstance(property);

            // create webDriver
            method = cls.getDeclaredMethod("createWebDriver");
            method.invoke(obj);
            return (BaseDriver) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addDriver(BaseDriver driver) {
        driverController.set(driver);
    }

    public static void removeDriver() {
        driverController.remove();
    }

    public static BaseDriver getDriver() {
        return driverController.get();
    }
}
