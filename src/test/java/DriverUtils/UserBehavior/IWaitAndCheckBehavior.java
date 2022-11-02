package DriverUtils.UserBehavior;

import DriverUtils.Constants.MobileElementFindByType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface IWaitAndCheckBehavior {
    boolean waitTillElementAppear(AppiumDriver<MobileElement> appiumDriver,
                                  String appearElementInformation,
                                  int waitTime,
                                  MobileElementFindByType type);

    boolean waitTillElementDisappear(AppiumDriver<MobileElement> appiumDriver,
                                     String appearElementInformation,
                                     int waitTime,
                                     MobileElementFindByType type);
}
