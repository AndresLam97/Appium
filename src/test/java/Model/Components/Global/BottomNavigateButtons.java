package Model.Components.Global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavigateButtons {
    private AppiumDriver<MobileElement> appiumDriver;
    private By homeButtonSelector = MobileBy.AccessibilityId("Home");
    private By webviewButtonSelector = MobileBy.AccessibilityId("Webview");
    private By loginButtonSelector = MobileBy.AccessibilityId("Login");
    private By formsButtonSelector = MobileBy.AccessibilityId("Forms");
    private By swipeButtonSelector = MobileBy.AccessibilityId("Swipe");
    private By dragButtonSelector = MobileBy.AccessibilityId("Drag");

    public BottomNavigateButtons(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnHomeButton()
    {
        appiumDriver.findElement(homeButtonSelector).click();
    }

    public void clickOnWebViewButton()
    {
        appiumDriver.findElement(webviewButtonSelector).click();
    }

    public void clickOnLoginButton()
    {
        appiumDriver.findElement(loginButtonSelector).click();
    }

    public void clickOnFormsButton()
    {
        appiumDriver.findElement(formsButtonSelector).click();
    }

    public void clickOnSwipeButton()
    {
        appiumDriver.findElement(swipeButtonSelector).click();
    }

    public void clickOnDragButton()
    {
        appiumDriver.findElement(dragButtonSelector).click();
    }
}
