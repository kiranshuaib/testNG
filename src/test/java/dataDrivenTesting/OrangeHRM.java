package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrangeHRM {


    WebDriver driver;

    @Test(dataProviderClass = SignInDP.class ,dataProvider = "signin-provider")
    public void signIn(String username, String password, boolean success){


//        System.setProperty("webdriver.chrome.driver","/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","/Users/Shuaib/Downloads/geckodriver/geckodriver.exe");
//        System.setProperty("webdriver.ie.driver","/Users/Shuaib/Downloads/IEDriver/IEDriverServer.exe");
//        driver = new ChromeDriver();
        driver= new FirefoxDriver();
//        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com");

        driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();


        System.out.println("Sign In Credentials: "+ "\n"+
                         String.format("name is %s", username) + "\n" +
                         String.format("password is %s", password) + "\n" +
                         String.format("successful sign in  is %s", success) + "\n" );

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actualResult = driver.findElement(By.id("welcome")).getText();
        String expectedResult = "Welcome Suraj";
        Assert.assertEquals(actualResult, expectedResult, "The Actual and expected results do not match");

        driver.quit();

    }
}
