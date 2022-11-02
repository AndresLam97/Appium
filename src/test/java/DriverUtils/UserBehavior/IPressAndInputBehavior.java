package DriverUtils.UserBehavior;

import io.appium.java_client.MobileElement;

public interface IPressAndInputBehavior {
    void pressAButton(MobileElement theButtonNeedToPress);
    void inputValueToTextField(MobileElement textField);
}
