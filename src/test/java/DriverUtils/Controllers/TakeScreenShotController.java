package DriverUtils.Controllers;

import DriverUtils.ApplicationBehavior.ITakeScreenShotBehavior;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class TakeScreenShotController implements ITakeScreenShotBehavior {
    private String directoryPath;

    public TakeScreenShotController(String directoryPath)
    {
        this.directoryPath = directoryPath;
    }

    @Override
    public void takeAFullScreenShot(String fileName, AppiumDriver<MobileElement> appiumDriver) throws IOException {
        File base64ScreenShotData = appiumDriver.getScreenshotAs(OutputType.FILE);
        String location;
        final int FIRST_INDEX = 0;
        if(fileName.charAt(FIRST_INDEX) == '/')
        {
            location = directoryPath.concat(fileName);
        }
        else
        {
            location = directoryPath.concat("/").concat(fileName);
        }
        FileUtils.copyFile(base64ScreenShotData,new File(location));
    }

    @Override
    public void takeAnAreaScreenShot(String fileName, MobileElement areaElement) throws IOException {
        File base64ScreenShotData = areaElement.getScreenshotAs(OutputType.FILE);
        String location;
        final int FIRST_INDEX = 0;
        if(fileName.charAt(FIRST_INDEX) == '/')
        {
            location = directoryPath.concat(fileName);
        }
        else
        {
            location = directoryPath.concat("/").concat(fileName);
        }
        FileUtils.copyFile(base64ScreenShotData,new File(location));
    }

    @Override
    public void takeAnElementScreenShot(String fileName, MobileElement element) throws IOException {
        File base64ScreenShotData = element.getScreenshotAs(OutputType.FILE);
        String location;
        final int FIRST_INDEX = 0;
        if(fileName.charAt(FIRST_INDEX) == '/')
        {
            location = directoryPath.concat(fileName);
        }
        else
        {
            location = directoryPath.concat("/").concat(fileName);
        }
        FileUtils.copyFile(base64ScreenShotData,new File(location));
    }
}
