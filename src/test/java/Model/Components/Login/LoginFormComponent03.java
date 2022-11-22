package Model.Components.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent03 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private By usernameSelector = MobileBy.AccessibilityId("input-email");
    private By passwordSelector = MobileBy.AccessibilityId("input-password");
    private By loginButtonSelector = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent03 inputUserName(String username)
    {
        appiumDriver.findElement(usernameSelector).sendKeys(username);
        return this;
    }

    public LoginFormComponent03 inputPassword(String password)
    {
        appiumDriver.findElement(passwordSelector).sendKeys(password);
        return this;
    }

    public LoginFormComponent03 clickOnLoginButton()
    {
        appiumDriver.findElement(loginButtonSelector).click();
        return this;
    }
}
