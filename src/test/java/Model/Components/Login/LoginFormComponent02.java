package Model.Components.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginFormComponent02 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private By usernameSelector = MobileBy.AccessibilityId("input-email");
    private By passwordSelector = MobileBy.AccessibilityId("input-password");
    private By loginButtonSelector = MobileBy.AccessibilityId("button-LOGIN");

    public LoginFormComponent02(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver = appiumDriver;
    }

    public void inputUserName(String username)
    {
        appiumDriver.findElement(usernameSelector).sendKeys(username);
    }

    public void inputPassword(String password)
    {
        appiumDriver.findElement(passwordSelector).sendKeys(password);
    }

    public void clickOnLoginButton()
    {
        appiumDriver.findElement(loginButtonSelector).click();
    }

}
