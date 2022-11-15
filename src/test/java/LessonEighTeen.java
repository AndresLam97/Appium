import DriverUtils.Constants.AllAppPackageAndActivity;
import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class LessonEighTeen {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
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
        try{
            appiumDriver.findElement(MobileBy.AccessibilityId("Login")).click();
            WebDriverWait webDriverWait = new WebDriverWait(appiumDriver,2);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("input-email")));

            MobileElement emailField = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordField = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            emailField.sendKeys("NguyenVanA");
            passwordField.sendKeys("Testing");

            appiumDriver.activateApp(AllAppPackageAndActivity.SETTING_APP_ACTIVITY);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("android:id/switch_widget")));

            appiumDriver.findElement(MobileBy.AccessibilityId("android:id/switch_widget")).click();

            appiumDriver.activateApp(AllAppPackageAndActivity.MAIN_APP_ACTIVITY);
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("button-LOGIN")));

            appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN")).click();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
