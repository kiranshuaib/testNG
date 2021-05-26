package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class DependsOnMethods {

    WebDriver driver;

    @Test
    public void test1_setupchrome(){
        System.setProperty("webdriver.chrome.driver","/Users/Shuaib/Downloads/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();



        System.out.println("1. Open Chrome");
    }

    @Test(dependsOnMethods = "test1_setupchrome")
    public void test2_OpenOrangeHRM() {

        driver.get("https://opensource-demo.orangehrmlive1234.com/");

        Assert.assertEquals(false,true, "Could not Open OrangeHRM");
        System.out.println("2. open test application");
    }

    @Test(dependsOnMethods = "test2_OpenOrangeHRM")
    public void test3_SignIn(){
        WebElement textUsername = driver.findElement(By.id("txtUsername"));
        textUsername.sendKeys("Admin");

        WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        btnLogin.click();

        System.out.println("2. SignIn");
    }


    @Test(dependsOnMethods = "test3_SignIn")
    public void test4_SearchUser() {
        WebElement menu_admin_viewAdminModule = driver.findElement(By.id("menu_admin_viewAdminModule"));
        menu_admin_viewAdminModule.click();

        WebElement searchSystemUser_userName = driver.findElement(By.id("searchSystemUser_userName"));
        searchSystemUser_userName.sendKeys("Admin");

        WebElement searchBtn = driver.findElement(By.id("searchBtn"));
        searchBtn.click();

        System.out.println("3. Search for User");

    }

    @Test(dependsOnMethods = {"test2_OpenOrangeHRM","test3_SignIn"})
    public void test5_SearchEmployee() {

        WebElement menu_pim_viewPimModule = driver.findElement(By.id("menu_pim_viewPimModule"));
        HighlighterMethod.highLighterMethod(driver,menu_pim_viewPimModule);
        menu_pim_viewPimModule.click();

        WebElement buttonSearch = driver.findElement(By.id("searchBtn"));
        HighlighterMethod.highLighterMethod(driver,buttonSearch);
        buttonSearch.click();

        System.out.println("5. Search For Employee");



        System.out.println("3. Search for Employee");
    }

    @Test(dependsOnMethods = {"test2_OpenOrangeHRM","test3_SignIn"})
    public void test6_SearchCandidate() {
        WebElement menuRecruitment = driver.findElement(By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b"));
        HighlighterMethod.highLighterMethod(driver, menuRecruitment);
        menuRecruitment.click();

        WebElement buttonSearch = driver.findElement(By.id("btnSrch"));
        HighlighterMethod.highLighterMethod(driver,buttonSearch);

        buttonSearch.click();

        System.out.println("6. Search For Candidate");
    }

    @Test(dependsOnMethods = {"test2_OpenOrangeHRM","test3_SignIn"})
    public void test7_SignOut() throws InterruptedException {
        WebElement welcome = driver.findElement(By.id("welcome"));
        HighlighterMethod.highLighterMethod(driver,welcome);
        welcome.click();


        WebElement linkLogout = driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a"));
        HighlighterMethod.highLighterMethod(driver,linkLogout);
        linkLogout.click();


        System.out.println("7. Sign Out");


    }


    @AfterClass
    public void tearDown(){
        driver.quit();

        System.out.println("8. Close Chrome & Application");
    }


}

