package Data;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static Hooks.Hooks.*;

public class ScreenShots {
    public static String filePath;

    public static void takeScreenShotFail() throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String name = ScenarioName + " Fail ".concat(".png");
        File destination = new File("C:\\Users\\Basant_Ehab\\Downloads\\Telegram Desktop\\ParkBank Auto\\ParkBank Auto\\ParkBank\\target\\ScreenShots\\".concat(name));
        filePath = destination.getAbsolutePath();
        FileUtils.copyFile(srcFile, destination);
        test.addScreenCaptureFromPath(filePath);
    }

    public static void takeScreenShotPass() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        //Calendar cal = Calendar.getInstance();
        String name = ScenarioName + " Pass ".concat(".png");
        File destination = new File("C:\\Users\\Basant_Ehab\\Downloads\\Telegram Desktop\\ParkBank Auto\\ParkBank Auto\\ParkBank\\target\\ScreenShots\\".concat(name));
        filePath = destination.getAbsolutePath();
        FileUtils.copyFile(srcFile, destination);
        test.addScreenCaptureFromPath(filePath);
    }
}

