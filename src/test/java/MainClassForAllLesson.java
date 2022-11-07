import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class MainClassForAllLesson {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        try
        {


            // For debug purpose
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        appiumDriver.quit();
    }
}
