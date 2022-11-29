package Exercises.LessonSixteen;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import DriverUtils.Controllers.UtilityController;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LessonSixTeen {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        UtilityController utilityController = new UtilityController(appiumDriver);
        fillUpALongForm(appiumDriver, utilityController);
        getDeviceNotification(appiumDriver, utilityController);
        appiumDriver.quit();
    }

    // Homework 1
    public static void fillUpALongForm(AppiumDriver<MobileElement> appiumDriver, UtilityController utilityController) {
        try {
            MobileElement formButton = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            utilityController.clickAButton(formButton);
            WebDriverWait waitDriver = new WebDriverWait(appiumDriver, 2);
            waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("text-input")));

            //Input value for the input text field
            MobileElement inputTextField = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            inputTextField.sendKeys("Inputting somethings");

            // Check the Active button is appear or not
            List<MobileElement> elementList = appiumDriver.findElements(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-Active\"]"));
            if (elementList.isEmpty()) {
                boolean checkKey = true;
                while (checkKey) {
                    utilityController.swipeFromAToB(50, 50, 10, 10);
                    List<MobileElement> findActiveButtonList = appiumDriver.findElements(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"button-Inactive\"]"));
                    if (!findActiveButtonList.isEmpty()) {
                        checkKey = false;
                    }
                }
            }

            // Find and click the switch toggle button
            MobileElement switchToggleButton = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            utilityController.clickAButton(switchToggleButton);

            // Click the drop down list button then click an element on the popup
            MobileElement dropDownList = appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));
            utilityController.clickAButton(dropDownList);
            List<MobileElement> dropDownListElements = appiumDriver.findElements(MobileBy.xpath("//android.widget.CheckedTextView"));
            for (MobileElement dropDownListElement : dropDownListElements) {
                if (dropDownListElement.getText().equalsIgnoreCase("This app is awesome")) {
                    utilityController.clickAButton(dropDownListElement);
                }
            }

            // Click the Active button then click the OK button on the popup
            MobileElement activeButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-Active"));
            utilityController.clickAButton(activeButton);
            List<MobileElement> activePopupElements = appiumDriver.findElements(MobileBy.xpath("//android.widget.Button"));
            for (MobileElement activePopupElement : activePopupElements) {
                if (activePopupElement.getText().equalsIgnoreCase("OK")) {
                    utilityController.clickAButton(activePopupElement);
                }
            }

            // Check the inactive button is clickable or not
            MobileElement inactiveButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-Inactive"));
            System.out.println(inactiveButton.getAttribute("clickable"));

            // For debug purpose only
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    // Homework 2
    public static void getDeviceNotification(AppiumDriver<MobileElement> appiumDriver, UtilityController utilityController) {
        try {
            utilityController.swipeToGetTheNotificationPanel();
            List<MobileElement> notificationList = appiumDriver.findElements(MobileBy.id("com.android.systemui:id/notification_main_column"));
            if (notificationList.isEmpty()) {
                throw new Exception("[ERROR]: There is no any notification.");
            }
            for (MobileElement mobileElement : notificationList) {
                MobileElement notificationDetail = mobileElement.findElement(MobileBy.id("com.android.systemui:id/text"));
                System.out.println(notificationDetail.getText());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
