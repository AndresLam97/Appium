import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LessonSixteen {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);

        try {
            MobileElement navigateLoginScreen = appiumDriver.findElement();

            // For debug purpose
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        appiumDriver.quit();
    }
}
