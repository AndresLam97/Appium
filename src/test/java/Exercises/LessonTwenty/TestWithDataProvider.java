package Exercises.LessonTwenty;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import Exercises.LessonNineteen.LoginCredential;
import TestFlow.AllTestFlow.LoginTestFlowWithHardAssert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestWithDataProvider {

    @Test(dataProvider = "MyTestFunction")
     void testMethod1(LoginCredential loginCredential) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.android);
        try {
            LoginTestFlowWithHardAssert loginTestFlowWithHardAssert = new LoginTestFlowWithHardAssert(appiumDriver,
                    loginCredential.getEmail(),
                    loginCredential.getPassword());
            loginTestFlowWithHardAssert.performLogin();
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            appiumDriver.quit();
        }
    }

    @DataProvider(name = "MyTestFunction")
    private LoginCredential[] loginCredentialList()
    {
        LoginCredential[] loginCredentialList = new LoginCredential[] {new LoginCredential("","12345678")
        ,new LoginCredential("NguyenVanTeo","12345678")
        ,new LoginCredential("NguyenVanTeo@abc.com","")
        ,new LoginCredential("NguyenVanTeo@abc.com","1234")
        ,new LoginCredential("NguyenVanTeo@abc.com","12345678")};
        return loginCredentialList;
    }



}
