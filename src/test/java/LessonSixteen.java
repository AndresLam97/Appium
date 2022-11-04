import DriverUtils.Constants.MobileElementFindByType;
import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.ClickAndInputController;
import DriverUtils.Controllers.DriverFactory;
import DriverUtils.Controllers.WaitAndCheckController;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.util.ArrayList;
import java.util.List;

public class LessonSixteen {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(MobilePlatform.ANDROID);
        List<MobileElement> mobileElementList = new ArrayList<>();
        WaitAndCheckController waitAndCheckController = new WaitAndCheckController();
        ClickAndInputController clickAndInputController = new ClickAndInputController();
        try
        {
            MobileElement rootElement = appiumDriver.findElement(MobileBy.id("com.wdiodemoapp:id/action_bar_root"));
            mobileElementList = waitAndCheckController.findElementByInformation(rootElement,"//android.widget.Button", MobileElementFindByType.XPATH);
            if(mobileElementList.isEmpty())
            {
                throw new Exception("Can't find element");
            }
            for (MobileElement mobileElement : mobileElementList) {
                if (mobileElement.getText().equalsIgnoreCase("Login"))
                {
                    clickAndInputController.clickAButton(appiumDriver,mobileElement);
                }
            }
            waitAndCheckController.waitTillElementAppear(appiumDriver,"input-email",2,MobileElementFindByType.ACCESSIBILITY_ID);

            mobileElementList = waitAndCheckController.findElementByInformation(rootElement,"//android.widget.ScrollView",MobileElementFindByType.XPATH);

            // For debug purpose
            Thread.sleep(5000);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }
}
