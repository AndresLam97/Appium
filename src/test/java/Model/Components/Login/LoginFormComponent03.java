package Model.Components.Login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginFormComponent03 {
    private final AppiumDriver<MobileElement> appiumDriver;
    private By usernameSelector = MobileBy.AccessibilityId("input-email");
    private By passwordSelector = MobileBy.AccessibilityId("input-password");
    private By loginButtonSelector = MobileBy.AccessibilityId("button-LOGIN");

    @AndroidFindBy(xpath="//*[contains(@text,'Please enter a valid email address')]")
    @iOSXCUITFindBy(iOSNsPredicate="label = \"Please enter a valid email address\"")
    private MobileElement incorrectEmailSelector;

    @AndroidFindBy(xpath="//*[contains(@text,'Please enter at least 8 characters')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label = \"Please enter at least 8 characters\"")
    private MobileElement incorrectPasswordSelector;

    @AndroidFindBy(xpath="//*[contains(@text,'You are logged in!')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label = \"You are logged in!\"")
    private MobileElement loginSuccessPopupDetailElement;

    public LoginFormComponent03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)),this);
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
        return incorrectEmailSelector.getText();
    }

    public String getIncorrectPasswordText()
    {
        return incorrectPasswordSelector.getText();
    }

    public String getLoginSuccessPopupDetailText()
    {
        return loginSuccessPopupDetailElement.getText().trim();
    }

    public MobileElement getLoginSuccessPopupDetailSelector()
    {
        return this.loginSuccessPopupDetailElement;
    }
}
