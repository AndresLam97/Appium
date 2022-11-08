package DriverUtils.ApplicationBehavior;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;

public interface ITakeScreenShotBehavior{
    void takeAFullScreenShot(String fileName, AppiumDriver<MobileElement> appiumDriver) throws IOException;
    void takeAnAreaScreenShot(String fileName, MobileElement areaElement) throws IOException;
    void takeAnElementScreenShot(String fileName, MobileElement element) throws IOException;
}
