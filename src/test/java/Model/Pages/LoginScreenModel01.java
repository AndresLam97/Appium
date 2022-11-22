package Model.Pages;

import Model.Components.Global.BottomNavigateButtons;
import Model.Components.Login.LoginFormComponent01;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreenModel01 {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreenModel01(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent01 loginFormComponent()
    {
        return new LoginFormComponent01(appiumDriver);
    }

    public BottomNavigateButtons bottomNavigateComponent()
    {
        return new BottomNavigateButtons(appiumDriver);
    }

}
