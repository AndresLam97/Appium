package Model.Components.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginFormComponent03 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private By usernameSelector = MobileBy.AccessibilityId("input-email");
    private By passwordSelector = MobileBy.AccessibilityId("input-password");
    private By loginButtonSelector = MobileBy.AccessibilityId("button-LOGIN");
    private By incorrectEmailSelector = MobileBy.xpath("//*[contains(@text,'Please enter a valid email address')]");
    private By incorrectPasswordSelector = MobileBy.xpath("//*[contains(@text,'Please enter at least 8 characters')]");
    private By loginSuccessPopupDetailSelector = MobileBy.xpath("//*[contains(@text,'You are logged in!')]");

    public LoginFormComponent03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Step("Input the user name with value {username}")
    public LoginFormComponent03 inputUserName(String username)
    {
        MobileElement userNameElement = appiumDriver.findElement(usernameSelector);
        userNameElement.clear();
        userNameElement.sendKeys(username);
        return this;
    }

    @Step("Input the password with value {password}")
    public LoginFormComponent03 inputPassword(String password)
    {
        MobileElement passwordElement = appiumDriver.findElement(passwordSelector);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    @Step("Click on the Login button")
    public LoginFormComponent03 clickOnLoginButton()
    {
        appiumDriver.findElement(loginButtonSelector).click();
        return this;
    }

    public String getIncorrectEmailText()
    {
        return appiumDriver.findElement(incorrectEmailSelector).getText();
    }

    public String getIncorrectPasswordText()
    {
        return appiumDriver.findElement(incorrectPasswordSelector).getText();
    }

    public String getLoginSuccessPopupDetailText()
    {
        return appiumDriver.findElement(loginSuccessPopupDetailSelector).getText();
    }

    public By getLoginSuccessPopupDetailSelector()
    {
        return this.loginSuccessPopupDetailSelector;
    }
}
