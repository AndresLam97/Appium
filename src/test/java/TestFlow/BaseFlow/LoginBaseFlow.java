package TestFlow.BaseFlow;

import Model.Pages.LoginScreenModel03;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginBaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public LoginBaseFlow(AppiumDriver<MobileElement> appiumDriver)
    {
        this.appiumDriver = appiumDriver;
    }


    protected void goToLoginScreen()
    {
        LoginScreenModel03 loginScreenModel03 = new LoginScreenModel03(appiumDriver);
        loginScreenModel03.bottomNavigateButtons().clickOnLoginButton();
    }

}
