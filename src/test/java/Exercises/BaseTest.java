package Exercises;

import DriverUtils.Constants.MobilePlatform;
import DriverUtils.Controllers.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseTest {

    private static List<DriverFactory> driverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;
    private String udid;
    private String systemPort;

    public AppiumDriver<MobileElement> getDriver()
    {
        return driverThread.get().createAppiumDriver(MobilePlatform.ANDROID,this.udid,this.systemPort);
    }

    @BeforeTest
    @Parameters({"udid","systemPort"})
    public void initAppiumSession(String udid, String systemPort)
    {
            this.udid = udid;
            this.systemPort = systemPort;
            driverThread = ThreadLocal.withInitial(()->{
               DriverFactory driverFactory = new DriverFactory();
               driverThreadPool.add(driverFactory);
               return driverFactory;
            });
    }

    @AfterTest(alwaysRun = true)
    public void closeAppiumSession()
    {
        driverThread.get().quitAppiumSession();
    }

    @AfterMethod
    public void takeErrorScreenShot(ITestResult iTestResult)
    {
        if(iTestResult.getStatus() == ITestResult.FAILURE)
        {
            // Get method name
            String failedMethodName = iTestResult.getName();

            // Generate taken time and convert to the new format
            LocalDateTime takenTimeBeforeFormat = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            String takenTime = takenTimeBeforeFormat.format(dtf);

            // Create file name and store into a location
            String fileName = failedMethodName + "-" + takenTime + ".png";
            String location = System.getProperty("user.dir").concat("/All_ScreenShot/" + fileName);

            // Capture screen shot and attach into report
            File base64ScreenShot = getDriver().getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(base64ScreenShot,new File(location));
                Path fileLocation = Paths.get(location);
                InputStream inputStream = Files.newInputStream(fileLocation);
                Allure.addAttachment(failedMethodName,inputStream);
            }catch(Exception ex)
            {}
        }
    }

}
