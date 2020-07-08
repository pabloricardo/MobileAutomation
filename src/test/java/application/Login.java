package application;

import bases.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends Base {

    @Test
    public void LoginTest() throws IOException {
        AppiumDriver<AndroidElement> driver = androidDriver("GeneralStoreApp");
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test01");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Brazil\"));"));
        driver.findElement(By.xpath("//*[@text='Brazil']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }
}
