import DriverUtils.Constants.ContextInformation;
import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import DriverUtils.Controllers.WaitForMoreThanOneContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LessonSevenTeen {
    public static void main(String[] args) {

        // Working with hybird context
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        try {
            appiumDriver.findElement(MobileBy.AccessibilityId("Webview")).click();
            WebDriverWait webDriverWait = new WebDriverWait(appiumDriver, 1);
            webDriverWait.until(new WaitForMoreThanOneContext(appiumDriver));

            // Switch to webview
            appiumDriver.context(ContextInformation.WEB_VIEW_CONTEXT);
            WebElement navigateToogleButton = appiumDriver.findElementByCssSelector(".navbar__toggle");
            navigateToogleButton.click();
            List<MobileElement> menuItemList = appiumDriver.findElementsByCssSelector(".menu__list-item a");
            for (MobileElement mobileElement : menuItemList) {
                String itemText = mobileElement.getText();
                String itemHref = mobileElement.getAttribute("href");
                if (itemText.isEmpty()) {
                    System.out.println("Github: " + itemHref);
                }
                System.out.println(mobileElement.getText());
            }
            appiumDriver.context(ContextInformation.APP_CONTEXT);

            // For debug purpose only
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        appiumDriver.quit();

        // Take screen shot --> Added controller and tested but haven't done the exercise
    }
}