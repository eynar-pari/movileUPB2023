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

public class AddContactTest {

    AppiumDriver appiumDriver;

    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","UPB2023");
        capabilities.setCapability("platformVersion","9.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.android.contacts");
        capabilities.setCapability("appActivity","com.android.contacts.activities.PeopleActivity");
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
        String name = "Eynar12";

        // click [+] button
        appiumDriver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
        // click [cancel] button
        appiumDriver.findElement(By.id("com.android.contacts:id/left_button")).click();
        // type [first name] textbox
        appiumDriver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys(name);
        // type [phone] textbox
        appiumDriver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("78978979");
        // click [save] button
        appiumDriver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();

        // verification Label --> contact created
        String actualResult =  appiumDriver.findElement(By.id("com.android.contacts:id/large_title")).getText();
        Assertions.assertEquals(name,actualResult,"ERROR! el contacto no fue creado");

    }
}
