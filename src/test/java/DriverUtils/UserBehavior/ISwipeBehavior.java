package DriverUtils.UserBehavior;

import io.appium.java_client.AppiumDriver;

public interface ISwipeBehavior {
    void swipeFromAToB(int pointAHorizontalPosition, int pointAVerticalPosition, int pointBHorizontalPosition, int pointBVerticalPosition);

    void swipeToGetTheStatusPanel();

    void swipeToGetTheNotificationPanel();

    void swipeToBackHomeScreen();
}
