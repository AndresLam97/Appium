package Exercises.LessonNineteen;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import TestFlow.AllTestFlow.LoginTestFlowWithHardAssert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

import java.util.*;

public class HomeworkWithTestNG {

    private static void testSolutionOne()
    {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        try
        {
            Map<String, List<String>> testCaseData = new HashMap<>();
            testCaseData.put("Empty email", Arrays.asList("","12345678"));
            testCaseData.put("Invalid email", Arrays.asList("NguyenVanTeo","12345678"));
            testCaseData.put("Empty password", Arrays.asList("NguyenVanTeo@abc.com",""));
            testCaseData.put("Invalid password", Arrays.asList("NguyenVanTeo@abc.com","1234"));
            testCaseData.put("Correct data", Arrays.asList("NguyenVanTeo@abc.com","12345678"));
            final int EMAIL_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            for(String testCaseDataKey : testCaseData.keySet())
            {
                String email = testCaseData.get(testCaseDataKey).get(EMAIL_INDEX);
                String password = testCaseData.get(testCaseDataKey).get(PASSWORD_INDEX);
                System.out.println("Test case name: " + testCaseDataKey);
                LoginTestFlowWithHardAssert loginTest = new LoginTestFlowWithHardAssert(appiumDriver, email, password);
                loginTest.performLogin();
                System.out.println();
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }finally
        {
            appiumDriver.quit();
        }
    }

    private static void testSolutionTwo() {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        try
        {
            List<LoginCredential> loginCredentialList = new ArrayList<>();
            loginCredentialList.add(new LoginCredential("","12345678"));
            loginCredentialList.add(new LoginCredential("NguyenVanTeo","12345678"));
            loginCredentialList.add(new LoginCredential("NguyenVanTeo@abc.com",""));
            loginCredentialList.add(new LoginCredential("NguyenVanTeo@abc.com","1234"));
            loginCredentialList.add(new LoginCredential("NguyenVanTeo@abc.com","12345678"));
            for (LoginCredential loginCredential : loginCredentialList) {
                LoginTestFlowWithHardAssert loginTestFlowWithHardAssert = new LoginTestFlowWithHardAssert(appiumDriver,
                        loginCredential.getEmail(),
                        loginCredential.getPassword());
                loginTestFlowWithHardAssert.performLogin();
                System.out.println();
            }
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }finally
        {
            appiumDriver.quit();
        }
    }

}
