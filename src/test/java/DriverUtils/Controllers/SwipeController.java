package DriverUtils.Controllers;

import DriverUtils.UserBehavior.ISwipeBehavior;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeController implements ISwipeBehavior {
    @Override
    public boolean swipeUpFromAToB(PointOption pointA, PointOption pointB, int swipeTime) {
        return false;
    }

    @Override
    public boolean swipeDownFromAToB(PointOption pointA, PointOption pointB, int swipeTime) {
        return false;
    }

    @Override
    public boolean swipeLeftFromAToB(PointOption pointA, PointOption pointB, int swipeTime) {
        return false;
    }

    @Override
    public boolean swipeRightFromAToB(PointOption pointA, PointOption pointB, int swipeTime) {
        return false;
    }
}
