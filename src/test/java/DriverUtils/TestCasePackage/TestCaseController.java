package DriverUtils.TestCasePackage;

import DriverUtils.Controllers.UtilityController;
import io.appium.java_client.AppiumDriver;

public class TestCaseController {

    //
    public static void testCase1(AppiumDriver appiumDriver)
    {
        UtilityController utilityController = new UtilityController(appiumDriver);

    }
}
