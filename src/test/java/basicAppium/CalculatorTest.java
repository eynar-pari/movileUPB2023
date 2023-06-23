package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {

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
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void closeApp(){
        appiumDriver.quit();
    }
    @Test
    public void verifyAdditionTest() throws InterruptedException {
        // click 4 button
        appiumDriver.findElement(By.id("com.android.calculator2:id/digit_4")).click();
        // click + button
        appiumDriver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        // click 3 button
        appiumDriver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
        // click = button
        appiumDriver.findElement(By.id("com.android.calculator2:id/eq")).click();
        // verification total
        Thread.sleep(5000);
        String expectedResult = "7";
        String actualResult = appiumDriver.findElement(By.id("com.android.calculator2:id/result")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR la suma es incorrecta!");
    }
}
