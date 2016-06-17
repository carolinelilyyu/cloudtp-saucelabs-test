import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Yu on 6/15/16.
 */
public class MyFirstWebDriverTest {

    protected String browser;
    protected String os;
    protected String version;
    protected String deviceName;
    protected String sessionId;
    protected WebDriver driver;
    @Test
    public void checkSeleniumHQinFirefox(){
        driver = null;
        DesiredCapabilities capability = new DesiredCapabilities(); //.firefox();
        capability.setCapability(CapabilityType.BROWSER_NAME, "safari");//System.getenv("SAUCE_ONDEMAND_BROWSERS"));
        //capability.setVersion(System.getenv("SELENIUM_VERSION"));
        //capability.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
        capability.setCapability("build", System.getenv("JOB_NAME") + "_" + System.getenv("BUILD_NUMBER"));
        try {
            driver = new RemoteWebDriver(new URL("http://"+System.getenv("SAUCE_USERNAME")+":"+System.getenv("SAUCE_ACCESS_KEY")+"@ondemand.saucelabs.com:80/wd/hub"), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //try catch
        driver.get("http://seleniumhq.org");
        WebElement downloadTab = driver.findElement(By.id("menu_download"));
        WebElement downloadLink = downloadTab.findElement(By.tagName("a"));
        downloadLink.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebElement downloadLink = driver.findElement(By.cssSelector("#menu_download a"));
        Assert.assertEquals("Downloads", driver.getTitle());

        driver.quit();


    }

    public static LinkedList browserStrings(){
        LinkedList browsers = new LinkedList();

        browsers.add(new String[] {"Windows 7", "41", "chrome", null, null});
        browsers.add(new String[] {"OSX 10.8", "7", "safari", null, null});
        return browsers;
    }


}
