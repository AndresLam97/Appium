package DriverUtils.Controllers;

import DriverUtils.ApplicationBehavior.IClickAndInputBehavior;
import DriverUtils.ApplicationBehavior.ISwipeBehavior;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.internal.CapabilityHelpers;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class UtilityController implements IClickAndInputBehavior, ISwipeBehavior {
    private AppiumDriver appiumDriver;
    private int screenWidth;
    private int screenHeight;
    private final int PRESS_TIME = 200;

    public UtilityController(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        Dimension screenDimension = appiumDriver.manage().window().getSize();
        screenWidth = screenDimension.getWidth();
        screenHeight = screenDimension.getHeight();
    }

    @Override
    public void swipeFromAToB(int pointAHorizontalPercentage, int pointAVerticalPercentage,
                              int pointBHorizontalPercentage, int pointBVerticalPercentage) {
        TouchAction touchAction = new TouchAction(appiumDriver);
        PointOption pointA = generatePointByScreenPercentage(pointAHorizontalPercentage, pointBVerticalPercentage);
        PointOption pointB = generatePointByScreenPercentage(pointBHorizontalPercentage, pointBVerticalPercentage);
        touchAction.press(pointA)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointB)
                .release()
                .perform();
    }

    @Override
    public void swipeToGetTheStatusPanel() {
        TouchAction touchAction = new TouchAction(appiumDriver);
        PointOption pointA = generatePointByScreenPercentage(90, 1);
        PointOption pointB = generatePointByScreenPercentage(90, 50);
        touchAction.press(pointA)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointB)
                .release()
                .perform();
    }

    @Override
    public void swipeToGetTheNotificationPanel() {
        TouchAction touchAction = new TouchAction(appiumDriver);
        PointOption pointA = generatePointByScreenPercentage(10, 1);
        PointOption pointB = generatePointByScreenPercentage(10, 50);
        touchAction.press(pointA)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointB)
                .release()
                .perform();
    }

    // Pending: There is a difference way to back home screen
    @Override
    public void swipeToBackHomeScreen() {
        TouchAction touchAction = new TouchAction(appiumDriver);
        PointOption pointA = generatePointByScreenPercentage(50, 107);
        PointOption pointB = generatePointByScreenPercentage(50, 50);
        touchAction.press(pointA)
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointB)
                .release()
                .perform();
    }

    @Override
    public void clickAButton(MobileElement theButtonNeedToClick) {
        Capabilities capabilities = appiumDriver.getCapabilities();
        String platformType = CapabilityHelpers.getCapability(capabilities, "platformName", String.class);
        if (platformType.equalsIgnoreCase("android")) {
            theButtonNeedToClick.click();
        } else {
            theButtonNeedToClick.click();
            theButtonNeedToClick.click();
        }
    }

    private PointOption generatePointByScreenPercentage(int horizontalPercentage, int verticalPercentage) {
        int horizontalPosition = horizontalPercentage * (screenWidth / 100);
        int verticalPosition = verticalPercentage * (screenHeight / 100);
        return new PointOption().withCoordinates(horizontalPosition, verticalPosition);
    }

}
