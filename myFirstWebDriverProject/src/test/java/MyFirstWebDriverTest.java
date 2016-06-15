import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yu on 6/15/16.
 */
public class MyFirstWebDriverTest {
    @Test
    public void checkSeleniumHQinFirefox(){
        WebDriver driver = null;
        DesiredCapabilities capability = DesiredCapabilities.firefox();

        try {
            driver = new RemoteWebDriver(new URL("http://"+("desporous")+":"+("5b0cc6d3-2725-4190-ac03-175bedb6bd75")+"@ondemand.saucelabs.com:80/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //driver.get("http://seleniumhq.org");
        WebElement downloadTab = driver.findElement(By.id("menu_download"));
        WebElement downloadLink = downloadTab.findElement(By.tagName("a"));
        downloadLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement downloadLink = driver.findElement(By.cssSelector("#menu_download a"));
        Assert.assertEquals("Downloads", driver.getTitle());

        driver.quit();


    }
}
