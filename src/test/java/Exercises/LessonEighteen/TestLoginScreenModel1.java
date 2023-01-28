package Exercises.LessonEighteen;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import Model.Components.Login.LoginFormComponent01;
import Model.Pages.LoginScreenModel01;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestLoginScreenModel1 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory
                .createAppiumDriver(MobilePlatform.android);
        try
        {
            LoginScreenModel01 loginScreenModel01 = new LoginScreenModel01(appiumDriver);
            loginScreenModel01.bottomNavigateComponent().clickOnLoginButton();
            LoginFormComponent01 loginFormComp01 = loginScreenModel01.loginFormComponent();
            loginFormComp01.usernameElement().sendKeys("NguyenVanTeo");
            loginFormComp01.passwordElement().sendKeys("TranVanTi");
            loginFormComp01.loginButtonElement().click();

            // For debug purpose only
            Thread.sleep(2000);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        appiumDriver.quit();
    }
}
