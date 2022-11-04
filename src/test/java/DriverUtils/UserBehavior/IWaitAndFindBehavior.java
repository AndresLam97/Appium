package DriverUtils.UserBehavior;

import DriverUtils.Constants.MobileElementFindByType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public interface IWaitAndFindBehavior {
    boolean waitTillElementAppear(AppiumDriver<MobileElement> appiumDriver,
                                  String appearElementInformation,
                                  int waitTime,
                                  MobileElementFindByType type);

    boolean waitTillElementDisappear(AppiumDriver<MobileElement> appiumDriver,
                                     String appearElementInformation,
                                     int waitTime,
                                     MobileElementFindByType type);

    List<MobileElement> findElementByInformation(MobileElement mainElement, String elementWhichWantToFind, MobileElementFindByType type);

}
