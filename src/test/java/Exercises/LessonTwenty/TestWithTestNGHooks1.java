package Exercises.LessonTwenty;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import TestFlow.AllTestFlow.LoginTestFlowWithHardAssert;
import TestFlow.AllTestFlow.LoginTestFlowWithSoftAssert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestWithTestNGHooks1 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    // Using hard assert with LoginTestFlowWithHardAssert
    @Test(dependsOnMethods = {"testMethod2"})
    public void testMethod1()
    {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.android);
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

    // Using soft assert with LoginTestFlow02
    @Test
    public void testMethod2()
    {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.android);
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
                LoginTestFlowWithSoftAssert loginTest = new LoginTestFlowWithSoftAssert(appiumDriver, email, password);
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





}



