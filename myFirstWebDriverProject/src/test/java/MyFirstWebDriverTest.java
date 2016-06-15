import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Yu on 6/15/16.
 */
public class MyFirstWebDriverTest {
    @Test
    public void checkSeleniumHQinFirefox(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://seleniumhq.org");
        WebElement downloadTab = driver.findElement(By.id("menu_download"));
        WebElement downloadLink = downloadTab.findElement(By.tagName("a"));
        downloadLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement downloadLink = driver.findElement(By.cssSelector("#menu_download a"));
        Assert.assertEquals("Downloads", driver.getTitle());

        driver.quit();


    }
}
