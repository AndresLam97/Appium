package Exercises.LessonTwenty;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DataBuilderFromFile;
import DriverUtils.Controllers.DriverFactory;
import Exercises.LessonNineteen.LoginCredential;
import TestFlow.AllTestFlow.LoginTestFlowWithHardAssert;
import com.google.gson.Gson;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestWithJsonDataFile
{
    @Test
    public void testLoginScreen()
    {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        try{
            String fileLocation = "/src/test/java/Exercises/LessonTwenty/LoginTestData.json";
            LoginCredential[] dataList = DataBuilderFromFile.listDataFromJsonFile(fileLocation,LoginCredential[].class);
            for(LoginCredential loginCredential : dataList) {
                String userName = loginCredential.getEmail();
                String password = loginCredential.getPassword();
                LoginTestFlowWithHardAssert loginTestFlowWithHardAssert = new LoginTestFlowWithHardAssert(appiumDriver, userName, password);
                loginTestFlowWithHardAssert.performLogin();
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }finally {
            appiumDriver.quit();
        }
    }
}
