package Model.Pages;

import Model.Components.Global.BottomNavigateButtons;
import Model.Components.Login.LoginFormComponent03;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreenModel03 {
    private final AppiumDriver<MobileElement> appiumDriver;


    public LoginScreenModel03(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginFormComponent03 loginFormComponent03()
    {
        return new LoginFormComponent03(appiumDriver);
    }

    public BottomNavigateButtons bottomNavigateButtons()
    {
        return new BottomNavigateButtons(appiumDriver);
    }
}
