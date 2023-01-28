package Exercises.LessonEighteen;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import Model.Components.Login.LoginFormComponent02;
import Model.Pages.LoginScreenModel02;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestLoginScreenModel2 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory
                .createAppiumDriver(MobilePlatform.android);
        try
        {
            LoginScreenModel02 loginScreenModel02 = new LoginScreenModel02(appiumDriver);
            loginScreenModel02.bottomNavigateButtons().clickOnLoginButton();
            LoginFormComponent02 loginFormComp02 = loginScreenModel02.loginFormComponent02();
            loginFormComp02.inputUserName("NguyenVanTeo");
            loginFormComp02.inputPassword("TranVanTi");
            loginFormComp02.clickOnLoginButton();

            // For debug purpose only
            Thread.sleep(2000);
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        appiumDriver.quit();
    }
}
