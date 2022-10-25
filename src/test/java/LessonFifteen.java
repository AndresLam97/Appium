import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LessonFifteen {

    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.createAppiumDriver(
                "http://localhost:4999/wd/hub", MobilePlatform.ANDROID);
        WebDriverWait explicitWait = new WebDriverWait(appiumDriver, 3);

        try {
            // From the home screen, click the login button on the navigate panel
            // After click the login button, wait for 3 seconds to avoid
            // the case of not switching the screen in time to find element
            MobileElement navigateLoginScreenButton = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navigateLoginScreenButton.click();
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath
                    ("//android.widget.ScrollView[@content-desc=\"Login-screen\"" +
                            "]/android.view.ViewGroup/android.view.ViewGroup" +
                            "/android.view.ViewGroup[1]/android.widget.TextView")));

            // Start getting the elements on the login screen
            MobileElement emailFieldElement = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordFieldElement = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginButtonElement = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            // Input value to the email and password field
            // Then click the login button
            emailFieldElement.sendKeys("Andres");
            passwordFieldElement.sendKeys("Test");
            loginButtonElement.click();

            // For DEBUG purpose only
            Thread.sleep(3000);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        appiumDriver.quit();
    }


}
