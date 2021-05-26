package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogIn2 {

    WebDriver driver;

    @Test(dataProvider = "login-provider")
    public void login2(String email, String password, boolean success){
        System.setProperty("webdriver.chrome.driver","/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();


        System.out.println("Login Credentials: " +" \n" +
                            "email = "+email + "\n" +
                            "password = "+password + "\n"+
                            "successful login= = "+success + "\n"
        );


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actual_result = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).getText();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expected_result = "Sign out";
        Assert.assertEquals(actual_result,expected_result, "Actual and Expected result do not match");

        driver.quit();




    }

    @DataProvider(name = "login-provider")
    public Object[][] loginData2(){
        Object[][] data = new Object[3][3];

        data [0] [0] = "TestNG@Framework.com";		data [0] [1] = "TestNG1234";	data [0] [2] = true;
        data [1] [0] = "Joe@Doe.com";		        data [1] [1] = "DoeDoe34";	data [1] [2] = false;
        data [2] [0] = "Test@AutomationU.com";		data [2] [1] = "TAU1234";	data [2] [2] = true;

        return data;
    }
}
