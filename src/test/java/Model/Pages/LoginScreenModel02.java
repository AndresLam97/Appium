package Model.Pages;

import Model.Components.Global.BottomNavigateButtons;
import Model.Components.Login.LoginFormComponent02;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreenModel02 {
    private final AppiumDriver<MobileElement> appiumDriver;

    public LoginScreenModel02(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent02 loginFormComponent02()
    {
        return new LoginFormComponent02(appiumDriver);
    }

    public BottomNavigateButtons bottomNavigateButtons()
    {
        return new BottomNavigateButtons(appiumDriver);
    }
}
