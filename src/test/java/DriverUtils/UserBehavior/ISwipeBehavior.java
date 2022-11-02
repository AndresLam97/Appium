package DriverUtils.UserBehavior;

import io.appium.java_client.touch.offset.PointOption;

public interface ISwipeBehavior {
    boolean swipeUpFromAToB(PointOption pointA, PointOption pointB,int swipeTime);
    boolean swipeDownFromAToB(PointOption pointA, PointOption pointB, int swipeTime);
    boolean swipeLeftFromAToB(PointOption pointA, PointOption pointB, int swipeTime);
    boolean swipeRightFromAToB(PointOption pointA, PointOption pointB, int swipeTime);
}
