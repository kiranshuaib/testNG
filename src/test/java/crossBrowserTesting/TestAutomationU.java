package crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAutomationU {

    WebDriver driver;

    @Test
    @Parameters({"URL", "BrowserType"})
    public void VerifyTAU(String url, String browserType){
        if (browserType.equalsIgnoreCase("Internet Explorer")) {
            System.setProperty("webdriver.ie.driver", "/Users/Shuaib/Downloads/IEDriver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "/Users/Shuaib/Downloads/geckodriver/geckodriver.exe");

            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");

            driver = new ChromeDriver();

        }
        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("\n" + "Open " + browserType);
        System.out.println("   " +  driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        System.out.println("   " +  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[1]/div/div[1]/section[1]/p[1]")).getText());
        System.out.println("   " +  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[1]/div/div[1]/section[1]/p[1]")).getText());

        System.out.println("Close " + browserType + "\n");

        driver.quit();
    }
}