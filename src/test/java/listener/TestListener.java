package listener;

import core.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class TestListener implements ITestListener {

    String filePath = "src/test/java/screenshots/";

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("**** Error" + result.getTestName() + "test has failed *****");
        takeScreenshot(result.getName());
    }

    public void takeScreenshot(String methodName) {

        File sourceFile = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        String timeStamp = date.toString().replace(":", "_").replace(" ", "_");
        String fileLocation = filePath + methodName + "_" + timeStamp + ".png";
        try {
            FileUtils.copyFile(sourceFile, new File(fileLocation));
            Path content = Paths.get(fileLocation);
            try (InputStream inputStream = Files.newInputStream(content)) {
                //       Allure.addAttachment(methodName, inputStream);
            }
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }
}