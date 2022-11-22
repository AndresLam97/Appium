package Model.Components.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent01{
    private final AppiumDriver<MobileElement> appiumDriver;
    private final By usernameSelector = MobileBy.AccessibilityId("input-email");
    private final By passwordSelector = MobileBy.AccessibilityId("input-password");
    private final By loginButtonSelector = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent01(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public MobileElement usernameElement()
    {
        return appiumDriver.findElement(usernameSelector);
    }

    public MobileElement passwordElement()
    {
        return appiumDriver.findElement(passwordSelector);
    }

    public MobileElement loginButtonElement()
    {
        return appiumDriver.findElement(loginButtonSelector);
    }


}
