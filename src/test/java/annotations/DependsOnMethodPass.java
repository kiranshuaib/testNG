package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class DependsOnMethodPass {
    WebDriver driver;

    @Test
    public void test1_SetUpChrome() {
        System.setProperty("webdriver.chrome.driver","/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("1. Set Up Chrome");
    }

    @Test(dependsOnMethods = "test1_SetUpChrome")
    public void test2_OpenOrangeHRM() {
        driver.get("https://opensource-demo.orangehrmlive.com/");

        System.out.println("2. Open OrangeHRM");
    }

    @Test(dependsOnMethods = "test2_OpenOrangeHRM")
    public void test3_SignIn() {
        WebElement textUsername = driver.findElement(By.id("txtUsername"));
        HighlighterMethod.highLighterMethod(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.id("txtPassword"));
        HighlighterMethod.highLighterMethod(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.id("btnLogin"));
        HighlighterMethod.highLighterMethod(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("3. Sign In");
    }

    @Test(dependsOnMethods = "test3_SignIn")
    public void test4_SearchUser() {
        WebElement menuAdmin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        HighlighterMethod.highLighterMethod(driver, menuAdmin);
        menuAdmin.click();

        WebElement textUserName = driver.findElement(By.id("searchSystemUser_userName"));
        HighlighterMethod.highLighterMethod(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        HighlighterMethod.highLighterMethod(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("4. Search For User");
    }

    @Test(dependsOnMethods = {"test2_OpenOrangeHRM", "test3_SignIn"})
    public void test5_SearchEmployee() {
        WebElement menuPIM = driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"));
        HighlighterMethod.highLighterMethod(driver, menuPIM);
        menuPIM.click();

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        HighlighterMethod.highLighterMethod(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("5. Search For Employee");
    }

    @Test(dependsOnMethods = {"test2_OpenOrangeHRM", "test3_SignIn"})
    public void test6_SearchCandidate() {
        WebElement menuRecruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
        HighlighterMethod.highLighterMethod(driver, menuRecruitment);
        menuRecruitment.click();

        WebElement buttonSearch = driver.findElement(By.id("btnSrch"));
        HighlighterMethod.highLighterMethod(driver, buttonSearch);

        buttonSearch.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println("6. Search For Candidate");
    }

    @Test(dependsOnMethods = {"test2_OpenOrangeHRM", "test3_SignIn"})
    public void test7_SignOut() {
        WebElement welcome = driver.findElement(By.id("welcome"));
        HighlighterMethod.highLighterMethod(driver,welcome);
        welcome.click();


        WebElement linkLogout = driver.findElement(By.xpath("//div[@id='welcome-menu']/descendant::a[contains(@href,'logout')]"));
        HighlighterMethod.highLighterMethod(driver,linkLogout);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        linkLogout.click();


        System.out.println("7. Sign Out");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();

        System.out.println("8. Close Chrome & Application");
    }

}