package DriverUtils.Controllers;

import DriverUtils.Constants.MobileElementFindByType;
import DriverUtils.UserBehavior.IWaitAndCheckBehavior;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAndCheckController implements IWaitAndCheckBehavior {
    @Override
    public boolean waitTillElementAppear(AppiumDriver<MobileElement> appiumDriver,
                                         String appearElementInformation,
                                         int waitTime,
                                         MobileElementFindByType type) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver, waitTime);
        try {
            switch (type) {
                case XPATH:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(appearElementInformation)));
                    break;
                case ID:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(appearElementInformation)));
                    break;
                case NAME:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(appearElementInformation)));
                    break;
                case CLASS_NAME:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className(appearElementInformation)));
                    break;
                case DATA_MATCHER:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.androidDataMatcher(appearElementInformation)));
                    break;
                case ACCESSIBILITY_ID:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(appearElementInformation)));
                    break;
                case ANDROID_VIEW_TAG:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidViewTag(appearElementInformation)));
                    break;
                case UIAUTOMATOR_SELECTOR:
                    waitDriver.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(appearElementInformation)));
                    break;
                default:
                    throw new ElementNotVisibleException("The element is not appear, please re-check!");
            }
        } catch (ElementNotVisibleException elementNotVisibleException) {
            System.out.println(elementNotVisibleException.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean waitTillElementDisappear(AppiumDriver<MobileElement> appiumDriver,
                                            String appearElementInformation,
                                            int waitTime,
                                            MobileElementFindByType type) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver, waitTime);
        try {
            switch (type) {
                case XPATH:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(appearElementInformation)));
                    break;
                case ID:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id(appearElementInformation)));
                    break;
                case NAME:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.name(appearElementInformation)));
                    break;
                case CLASS_NAME:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.className(appearElementInformation)));
                    break;
                case DATA_MATCHER:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.androidDataMatcher(appearElementInformation)));
                    break;
                case ACCESSIBILITY_ID:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId(appearElementInformation)));
                    break;
                case ANDROID_VIEW_TAG:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AndroidViewTag(appearElementInformation)));
                    break;
                case UIAUTOMATOR_SELECTOR:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AndroidUIAutomator(appearElementInformation)));
                    break;
                default:
                    throw new Exception("The element is not disappear, please re-check!");
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
            return false;
        }
        return true;
    }
}
