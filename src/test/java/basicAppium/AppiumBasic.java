package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasic {

    AppiumDriver appiumDriver;

    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","UPB2023");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        appiumDriver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        // implicit wait
    }

    @AfterEach
    public void closeApp(){
        appiumDriver.quit();
    }
    @Test
    public void verifySomeThing() throws InterruptedException {
        Thread.sleep(5000);
    }
}
