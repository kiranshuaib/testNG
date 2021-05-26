package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.Timer;

@Test
public class BM_AM_OrangeHRM {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();


    @BeforeClass
    public void setup(){
       System.setProperty("webdriver.chrome.driver","/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().window().maximize();


       driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
        System.out.println("1. Open Chrome & Application");
    }

    @Test
    public void signIn(){
        WebElement textUsername = driver.findElement(By.id("txtUsername"));
        textUsername.sendKeys("Admin");

        WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        System.out.println("2. SignIn");
    }


    @Test
    public void testHomePageVerification(){
//        hard assert
//        Assert.assertEquals(true,true, "The welcome link is not correct on home page ");

//        soft assert
        softAssert.assertEquals(false,true,"The welcome link is not correct on home page ");
        System.out.println(" 3. verify welcome link");

//        hard assert
//        Assert.assertFalse(false, "The admin tab is not displayed on the home page");

//        soft assert
        softAssert.assertFalse(false, "The admin tab is not displayed on the home page");
        System.out.println("4. verify admin tab");

//        hard assert
//        Assert.assertTrue(true,"The dashboard is not correct on the home page");
//
//        soft assert
        softAssert.assertTrue(false,"The dashboard is not correct on the home page");
        System.out.println("5. verify dash board");

        softAssert.assertAll();
    }

    @Test
    public void userSearch() {
        WebElement menu_admin_viewAdminModule = driver.findElement(By.id("menu_admin_viewAdminModule"));
        menu_admin_viewAdminModule.click();

        WebElement searchSystemUser_userName = driver.findElement(By.id("searchSystemUser_userName"));
        searchSystemUser_userName.sendKeys("Admin");

        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        searchBtn.click();

        System.out.println("6. Search for User");

    }

        @Test
    public void userSignout() throws InterruptedException {
        WebElement welcome = driver.findElement(By.id("welcome"));
        welcome.click();

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[2]/a")).click();


        System.out.println("7. Sign Out");


    }


    @AfterClass
    public void tearDown(){
        driver.quit();

        System.out.println("8. Close Chrome & Application");
    }



}
