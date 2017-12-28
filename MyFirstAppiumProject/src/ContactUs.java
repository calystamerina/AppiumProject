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

public class ContactUs {

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
    public void testContactUsSuccess() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Help')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_subject")).sendKeys("Feedback");
        driver.findElement(By.id("com.telkom.weedu:id/edt_message")).sendKeys("Aplikasi yang sangat baik!");
        driver.findElement(By.id("com.telkom.weedu:id/btn_send_message")).click();
        Assert.assertEquals("Thank you, Your message has been sent", driver.findElementById("android:id/message").getText());
    }

    @Test
    public void testContactUsEmpty() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Help')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_send_message")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")));
    }

    @Test
    public void testContactUsSubjectEmpty() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Help')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_message")).sendKeys("Aplikasi yang sangat baik!");
        driver.findElement(By.id("com.telkom.weedu:id/btn_send_message")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")));
    }

    @Test
    public void testContactUsMessageEmpty() throws InterruptedException {
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/btn_skip")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_username")).sendKeys("ganiamri");
        driver.findElement(By.id("com.telkom.weedu:id/edt_password")).sendKeys("Telkom12345");
        driver.findElement(By.id("com.telkom.weedu:id/btn_login")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Help')]")).click();
        driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")).click();
        driver.findElement(By.id("com.telkom.weedu:id/edt_subject")).sendKeys("Feedback");
        driver.findElement(By.id("com.telkom.weedu:id/btn_send_message")).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Contact Us')]")));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}

