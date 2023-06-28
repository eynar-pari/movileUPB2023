package devices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.GetEnvironment;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidCloud implements IDevice{
    @Override
    public AppiumDriver create() {

        String user="SET_YOUR_USER";
        String key="SET_YOUR_KEY";
        String app="bs://SET_YOUR_ID";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Samsung Galaxy S22 Ultra");
        capabilities.setCapability("os_version","12.0");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app",app);
        capabilities.setCapability("browserstack.user",user);
        capabilities.setCapability("browserstack.key",key);
        capabilities.setCapability("project","UPB Test WhenDo");
        capabilities.setCapability("build","build 0001");
        capabilities.setCapability("name","WhenDo Test");

        AppiumDriver driver= null;
        try {
            //    driver = new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"), capabilities);
            driver = new AndroidDriver(new URL("http://" + user + ":" + key + "@hub-cloud.browserstack.com/wd/hub"),capabilities);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // implicit wait
        //
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
