package DriverUtils.UserBehavior;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface IClickAndInputBehavior {
    void clickAButton(AppiumDriver appiumDriver, MobileElement theButtonNeedToClick);

    void inputValueToTextField(MobileElement textField, String information);
}
