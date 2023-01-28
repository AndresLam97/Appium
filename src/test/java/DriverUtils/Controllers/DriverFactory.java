package DriverUtils.Controllers;

import DriverUtils.Constants.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private AppiumDriver<MobileElement> appiumDriver;

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
                case ios:
                    desiredCapabilities = createDesiredCapabilitiesForIOSPlatform("","","","");
                    appiumDriver = new IOSDriver<MobileElement>(appium_server_url, desiredCapabilities);
                    appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
                    break;
                case android:
                    desiredCapabilities = createDesiredCapabilitiesForAndroidPlatform("","","");
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

    public AppiumDriver<MobileElement> createAppiumDriver(MobilePlatform platform, String udid, String systemPort, String platformVersion) {
        if(appiumDriver != null) return appiumDriver;
        URL appium_server_url = null;
        DesiredCapabilities desiredCapabilities = null;
        try {
            appium_server_url = new URL(AppiumServerInformation.URL_PREFIX +
                    AppiumServerInformation.URL_IP +
                    AppiumServerInformation.URL_PORT +
                    AppiumServerInformation.URL_SUFFIX);
            switch (platform) {
                case ios:
                    desiredCapabilities = createDesiredCapabilitiesForIOSPlatform(platform.toString(),udid,systemPort,platformVersion);
                    appiumDriver = new IOSDriver<MobileElement>(appium_server_url, desiredCapabilities);
                    appiumDriver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
                    break;
                case android:
                    desiredCapabilities = createDesiredCapabilitiesForAndroidPlatform(platform.toString(),udid, systemPort);
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

    private static DesiredCapabilities createDesiredCapabilitiesForAndroidPlatform(String platform,String udid, String systemPort) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        try {
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.PLATFORM_NAME, platform);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.AUTOMATION_NAME, "uiautomator2");
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.UDID, udid);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.APP_PACKAGE, "com.wdiodemoapp");
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.SYSTEM_PORT,systemPort);
        } catch (Exception ex) {
            System.out.println("Can't create desired capabilities");
            System.out.println(ex.toString());
            return null;
        }
        return desiredCapabilities;
    }

    private static DesiredCapabilities createDesiredCapabilitiesForIOSPlatform(String platform, String deviceName, String wdaLocalPort, String platformVersion) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        try {
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.PLATFORM_NAME, platform);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.AUTOMATION_NAME, "XCUITest");
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.DEVICE_NAME, deviceName);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.PLATFORM_VERSION, platformVersion);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.BUNDLE_ID, "org.wdioNativeDemoApp");
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.WDA_LOCAL_PORT,wdaLocalPort);
            desiredCapabilities.setCapability(MobileCapabilityTypeSub.NO_RESET, true);
        } catch (Exception ex) {
            System.out.println("Can't create desired capabilities");
            System.out.println(ex.toString());
            return null;
        }
        return desiredCapabilities;
    }

    public void quitAppiumSession()
    {
        if (appiumDriver != null) appiumDriver.quit();
    }

}
