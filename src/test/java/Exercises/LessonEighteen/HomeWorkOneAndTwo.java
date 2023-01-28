package Exercises.LessonEighteen;

import DriverUtils.Constants.AppPackages;
import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomeWorkOneAndTwo {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.android);
        homeWork1(appiumDriver,5);
        homeWork2(appiumDriver);
        appiumDriver.quit();
    }

    // Homework 1: run app in background
    public static void homeWork1(AppiumDriver<MobileElement> appiumDriver, int seconds)
    {
        try
        {
            appiumDriver.runAppInBackground(Duration.ofSeconds(seconds));
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // Homework 2: Doing something then switch to setting application
    // Then turn on/off the wifi and return back to current application
    public static void homeWork2(AppiumDriver<MobileElement> appiumDriver)
    {
        WebDriverWait webDriverWait = new WebDriverWait(appiumDriver,1);
        try{
            // Click the Login button on the navigate panel
            // Then wait for 2 seconds till the input email text field appear
            appiumDriver.findElement(MobileBy.AccessibilityId("Login")).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("input-email")));

            // Input the value to the email and password text field
            MobileElement emailField = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordField = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            emailField.sendKeys("NguyenVanA");
            passwordField.sendKeys("Testing");

            // Switch to the setting application
            appiumDriver.activateApp(AppPackages.SETTING);

            // Wait till the setting screen disappear
            webDriverWait.until(ExpectedConditions
                    .visibilityOfElementLocated(
                            MobileBy.AndroidUIAutomator(
                                    "new UiSelector().resourceId(\"com.android.settings:id/homepage_title\")")));

            // Find and click the Internet button
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Mạng và Internet']")).click();
            appiumDriver.findElement(MobileBy.xpath("//*[@text='Internet']")).click();

            // Find the wifi toggle button then click in
            boolean isWifiOn = appiumDriver.findElements(MobileBy.xpath("//*[@text='Thêm mạng']")).isEmpty();
            int toggleTime = isWifiOn ? 1:2;
            MobileElement wifiToggleButton = appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));
            for(int pressingTime = 0; pressingTime < toggleTime; pressingTime++)
            {
                wifiToggleButton.click();
            }

            appiumDriver.activateApp(AppPackages.WEBDRIVER_IO);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("input-email")));

            MobileElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));
            loginButton.click();

            // For debug purpose only
            Thread.sleep(5000);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
