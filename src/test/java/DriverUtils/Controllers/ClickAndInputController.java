package DriverUtils.Controllers;

import DriverUtils.UserBehavior.IClickAndInputBehavior;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.internal.CapabilityHelpers;
import org.openqa.selenium.Capabilities;

public class ClickAndInputController implements IClickAndInputBehavior {
    @Override
    public void clickAButton(AppiumDriver appiumDriver,MobileElement theButtonNeedToClick) {
        Capabilities capabilities = appiumDriver.getCapabilities();
        String platformType = CapabilityHelpers.getCapability(capabilities,"platformName",String.class);
        if(platformType.equalsIgnoreCase("android"))
        {
            theButtonNeedToClick.click();
        }
        else
        {
            theButtonNeedToClick.click();
            theButtonNeedToClick.click();
        }
    }

    @Override
    public void inputValueToTextField(MobileElement textField) {

    }
}
