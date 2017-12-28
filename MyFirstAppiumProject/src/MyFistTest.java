import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyFistTest {

    AppiumDriver driver;
    String path;

    @Before
    public void setUp()throws Exception {

        path = System.getProperty("user.dir");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("app", path+"//app//app-debug.apk");
        capabilities.setCapability("app_package", "com.telkom.weedu");


        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginSuccess() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Rekomendasi')]")));
    }

    @Test
    public void testLoginFailed() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("calysta");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("calysta31");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Login')]")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}
