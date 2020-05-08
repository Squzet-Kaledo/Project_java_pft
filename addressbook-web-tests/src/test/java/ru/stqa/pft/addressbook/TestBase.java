package ru.stqa.pft.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class TestBase {
    public WebDriver driver;
    private String baseUrl;
    public boolean acceptNextAlert = true;
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

    protected void returnToGroupPage(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    protected void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initGroupCreation(String s) {
        driver.findElement(By.name(s)).click();
    }

    protected void initContactCreation(String s) {
        driver.findElement(By.name(s)).click();
    }

    protected void gotoGroupPage(String groups) {
        returnToGroupPage(groups);
    }

    protected void gotoAddNewPage(String addnew) {
        returnToGroupPage(addnew);
    }

    protected void gotoHomePage(String home) {
        returnToGroupPage(home);
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

    public String closeAlertAndGetItsText() {
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

    protected void deleteSelectedGroups(String s) {
      driver.findElement(By.xpath(s)).click();
    }

    protected void selectGroup() {
      driver.findElement(By.xpath("(//input[@name='selected[]'])[1]")).click();
    }

    protected void deleteSelectedContacts() {
      driver.findElement(By.xpath("//input[@value='Delete']")).click();
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    protected void selectContact(By name) {
      driver.findElement(name).click();
    }

    protected void fillContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(contactData.getHome());
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(contactData.getWork());
        driver.findElement(By.name("fax")).clear();
        driver.findElement(By.name("fax")).sendKeys(contactData.getFax());
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
        driver.findElement(By.name("email3")).clear();
        driver.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
        driver.findElement(By.name("homepage")).clear();
        driver.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
        driver.findElement(By.name("bday")).click();
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        driver.findElement(By.name("bmonth")).click();
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(contactData.getByear());
        driver.findElement(By.name("aday")).click();
        new Select(driver.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
        driver.findElement(By.name("aday")).click();
        driver.findElement(By.name("amonth")).click();
        new Select(driver.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());
        driver.findElement(By.name("amonth")).click();
        driver.findElement(By.name("ayear")).click();
        driver.findElement(By.name("ayear")).clear();
        driver.findElement(By.name("ayear")).sendKeys(contactData.getAyear());
        driver.findElement(By.name("address2")).click();
        driver.findElement(By.name("address2")).clear();
        driver.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
        driver.findElement(By.name("phone2")).click();
        driver.findElement(By.name("phone2")).clear();
        driver.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());


    }

    protected void returnToHomePage(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    protected void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    protected void initContactCreation(By add_new) {
        driver.findElement(add_new).click();
    }
}
