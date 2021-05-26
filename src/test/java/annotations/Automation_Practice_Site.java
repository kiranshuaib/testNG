package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Automation_Practice_Site {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationpractice.com/index.php");
        System.out.println("Open Chrome & Application");
    }


    @Test(priority = 1)
    public void signin(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        WebElement email = driver.findElement(By.id("email"));
        HighlighterMethod.highLighterMethod(driver,email);
        email.sendKeys("TestNG@Framework.com");

        WebElement password = driver.findElement(By.id("passwd"));
        HighlighterMethod.highLighterMethod(driver,password);
        password.sendKeys("TestNG1234");


        WebElement submitLogin = driver.findElement(By.id("SubmitLogin"));
        HighlighterMethod.highLighterMethod(driver,submitLogin);
        submitLogin.click();


        System.out.println("1. sign in ");
    }

    @Test(priority = 2)
    public void searchTShirt() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();
        WebElement search_query_top = driver.findElement(By.id("search_query_top"));
        search_query_top.sendKeys("Blue");

        WebElement buttonElement = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        HighlighterMethod.highLighterMethod(driver,buttonElement);
        buttonElement.click();

        System.out.println("2. Search For T-Shirt");



    }

    @Test(priority=3)
    public void signOut() throws InterruptedException {


        WebElement logoutElem = driver.findElement(By.className("logout"));
        HighlighterMethod.highLighterMethod(driver,logoutElem);
        logoutElem.click();


        System.out.println("3. Sign Out");


    }


    @AfterClass
    public void tearDown(){
        driver.quit();

        System.out.println("quit");
    }
}
