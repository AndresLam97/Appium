package DriverUtils.Controllers;

import DriverUtils.Constants.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static AppiumDriver<MobileElement> createAppiumDriver(MobilePlatform platform) {
        AppiumDriver<MobileElement> appiumDriver = null;
        URL appium_server_url = null;
        DesiredCapabilities desiredCapabilities = null;
        try {
            appium_server_url = new URL(AppiumServerInformation.URL_PREFIX +
                    AppiumServerInformation.URL_IP +
                    AppiumServerInformation.URL_PORT +
                    AppiumServerInformation.URL_SUFFIX);
            switch (platform) {
                case IOS:
                    desiredCapabilities = createDesiredCapabilitiesForIOSPlatform();
                    appiumDriver = new IOSDriver<MobileElement>(appium_server_url, desiredCapabilities);
                    appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
                    break;
                case ANDROID:
                    desiredCapabilities = createDesiredCapabilitiesForAndroidPlatform();
                    appiumDriver = new AndroidDriver<MobileElement>(appium_server_url, desiredCapabilities);
                    appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown platform, please recheck the platform!");
            }
        } catch (MalformedURLException malformedURLException) {
            System.out.println("Can't set the URL of appium server, please recheck the url!");
            System.exit(-1);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.exit(-1);
        }
        return appiumDriver;
    }

    private static DesiredCapabilities createDesiredCapabilitiesForAndroidPlatform() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        try {
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.PLATFORM_NAME,
                    AndroidEnvironmentVariables.PLATFORM_VARIABLE_VALUE);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.AUTOMATION_NAME,
                    AndroidEnvironmentVariables.AUTOMATION_NAME_VARIABLE_VALUE);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.UDID,
                    AndroidEnvironmentVariables.UDID_VARIABLE_VALUE);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.APP_PACKAGE,
                    AppPackages.WEBDRIVER_IO);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.APP_ACTIVITY,
                    AppActivities.WEBDRIVER_IO);
        } catch (Exception ex) {
            System.out.println("Can't create desired capabilities");
            System.out.println(ex.toString());
            return null;
        }
        return desiredCapabilities;
    }

    private static DesiredCapabilities createDesiredCapabilitiesForIOSPlatform() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        try {
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.PLATFORM_NAME,
                    IOSEnvironmentVariables.PLATFORM_VARIABLE_VALUE);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.AUTOMATION_NAME,
                    IOSEnvironmentVariables.AUTOMATION_NAME_VARIABLE_VALUE);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.UDID,
                    IOSEnvironmentVariables.UDID_VARIABLE_VALUE);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.APP_PACKAGE,
                    AppPackages.WEBDRIVER_IO);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.APP_ACTIVITY,
                    AppActivities.WEBDRIVER_IO);
        } catch (Exception ex) {
            System.out.println("Can't create desired capabilities");
            System.out.println(ex.toString());
            return null;
        }
        return desiredCapabilities;
    }

}
