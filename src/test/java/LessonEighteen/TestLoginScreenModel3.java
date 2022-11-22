package LessonEighteen;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import Model.Components.Login.LoginFormComponent03;
import Model.Pages.LoginScreenModel03;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestLoginScreenModel3 {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory
                .createAppiumDriver(MobilePlatform.ANDROID);
        try{
            LoginScreenModel03 loginScreenModel03 = new LoginScreenModel03(appiumDriver);
            loginScreenModel03.bottomNavigateButtons().clickOnLoginButton();
            LoginFormComponent03 loginFormComponent03 = loginScreenModel03.loginFormComponent03();
            loginFormComponent03.inputUserName("NguyenVanTeo")
                    .inputPassword("TranVanTi")
                    .clickOnLoginButton();

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
