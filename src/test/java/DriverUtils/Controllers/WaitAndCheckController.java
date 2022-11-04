package DriverUtils.Controllers;

import DriverUtils.Constants.MobileElementFindByType;
import DriverUtils.UserBehavior.IWaitAndFindBehavior;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WaitAndCheckController implements IWaitAndFindBehavior {
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
                                            String disappearElementInformation,
                                            int waitTime,
                                            MobileElementFindByType type) {
        WebDriverWait waitDriver = new WebDriverWait(appiumDriver, waitTime);
        try {
            switch (type) {
                case XPATH:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(disappearElementInformation)));
                    break;
                case ID:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id(disappearElementInformation)));
                    break;
                case NAME:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.name(disappearElementInformation)));
                    break;
                case CLASS_NAME:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.className(disappearElementInformation)));
                    break;
                case DATA_MATCHER:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.androidDataMatcher(disappearElementInformation)));
                    break;
                case ACCESSIBILITY_ID:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId(disappearElementInformation)));
                    break;
                case ANDROID_VIEW_TAG:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AndroidViewTag(disappearElementInformation)));
                    break;
                case UIAUTOMATOR_SELECTOR:
                    waitDriver.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AndroidUIAutomator(disappearElementInformation)));
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

    @Override
    public List<MobileElement> findElementByInformation(MobileElement mainElement, String elementWhichWantToFind, MobileElementFindByType type) {
        List<MobileElement> mobileElementsList = new ArrayList<>();
        try {
            switch (type) {
                case XPATH:
                    mobileElementsList = mainElement.findElements(MobileBy.xpath(elementWhichWantToFind));
                    break;
                case ID:
                    mobileElementsList = mainElement.findElements(MobileBy.id(elementWhichWantToFind));
                    break;
                case NAME:
                    mobileElementsList = mainElement.findElements(MobileBy.name(elementWhichWantToFind));
                    break;
                case CLASS_NAME:
                    mobileElementsList = mainElement.findElements(MobileBy.className(elementWhichWantToFind));
                    break;
                case DATA_MATCHER:
                    mobileElementsList = mainElement.findElements(MobileBy.androidDataMatcher(elementWhichWantToFind));
                    break;
                case ACCESSIBILITY_ID:
                    mobileElementsList = mainElement.findElements(MobileBy.AccessibilityId(elementWhichWantToFind));
                    break;
                case ANDROID_VIEW_TAG:
                    mobileElementsList = mainElement.findElements(MobileBy.AndroidViewTag(elementWhichWantToFind));
                    break;
                case UIAUTOMATOR_SELECTOR:
                    mobileElementsList = mainElement.findElements(MobileBy.AndroidUIAutomator(elementWhichWantToFind));
                    break;
                default:
                    throw new Exception("There is not have the element type which you want to find.");
            }
        } catch (Exception exception) {
            System.out.println(exception.toString());
            return mobileElementsList;
        }
        return mobileElementsList;
    }
}
