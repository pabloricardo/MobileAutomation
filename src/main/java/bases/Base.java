package bases;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static Properties PROP;
    public static AndroidDriver<AndroidElement> ANDROID_DRIVER;


    public static AndroidDriver<AndroidElement> androidDriver(String appName) throws IOException {

        String userDir = System.getProperty("user.dir");
        InputStream inputStream = new FileInputStream(userDir+"\\src\\main\\java\\properties\\ConfigTests.config.properties");
        PROP= new Properties();
        PROP.load(inputStream);

        File app = new File("src/" + PROP.getProperty(appName));
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "EmulatorPhoneAndroid9");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        //capabilities.setCapability("chromedriverExecutable", "C://chromedriver/chromedriver.exe");

        ANDROID_DRIVER = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        ANDROID_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return ANDROID_DRIVER;


    }




}
