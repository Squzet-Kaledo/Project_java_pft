package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

/*import org.openqa.selenium.firefox.FirefoxOptions;*/
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.fail;

public class GroupCreationTests {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
        driver =  new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin","secret");
    }

    private void login(String username, String password) {
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }



    @Test
    public void testGroupCreation() {
        gotoGroupPage("groups");
        initGroupCreation("new");
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage("group page");
    }

    private void returnToGroupPage(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    private void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation(String s) {
        driver.findElement(By.name(s)).click();
    }

    private void gotoGroupPage(String groups) {
        returnToGroupPage(groups);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}