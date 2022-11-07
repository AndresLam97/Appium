package DriverUtils.UserBehavior;

import io.appium.java_client.AppiumDriver;

public interface ISwipeBehavior {
    void swipeFromAToB(int pointAHorizontalPosition, int pointAVerticalPosition, int pointBHorizontalPosition, int pointBVerticalPosition, int swipeTime);

    void swipeToGetTheStatusPanel(AppiumDriver appiumDriver);

    void swipeToGetTheNotificationPanel(AppiumDriver appiumDriver);

    void swipeToBackHomeScreen(AppiumDriver appiumDriver);
}
