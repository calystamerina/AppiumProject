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

public class EditProfile {

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
    public void testEditProfileSuccess() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'My Account')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_user_name")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/edt_phone_number")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/edt_user_name")).sendKeys("Dina Almira");
        driver.findElement(By.id("com.telkom.weedu:id/edt_phone_number")).sendKeys("0878787878");
        driver.findElement(By.id("com.telkom.weedu:id/btn_edit_profile")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Saldo')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Point')]")));
    }

    @Test
    public void testEditProfileUsernameEmpty() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'My Account')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_phone_number")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/edt_phone_number")).sendKeys("0878787878");
        driver.findElement(By.id("com.telkom.weedu:id/edt_user_name")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/btn_edit_profile")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")));
    }



    @Test
    public void testEditProfilePhoneEmpty() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'My Account')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_user_name")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/edt_user_name")).sendKeys("Dina Almira");
        driver.findElement(By.id("com.telkom.weedu:id/edt_phone_number")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/btn_edit_profile")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")));
    }

    @Test
    public void testEditProfileEmpty() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'My Account')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_user_name")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/edt_phone_number")).clear();
        driver.findElement(By.id("com.telkom.weedu:id/btn_edit_profile")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Edit Account')]")));
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}


