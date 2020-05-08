package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.ContactData;

public class ContactCreationTests {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
        driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
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
    public void testContactCreation() {
        initContactCreation(By.linkText("add new"));
        fillContactForm(new ContactData("abc", "def", "ghj", "Kaledo", "Amaru", "The best", "la-la-la", "Kirovsk", "8-123-456-789", "tra-la-la", "123456789", "Kaledo", "Kaledo2", "Kaledo3", "1234", "28", "May", "1985", "28", "May", "1985", "BPS", "6", "1234567890"));
        submitContactCreation();
        returnToGroupPage("home page");
    }

    private void fillContactForm(ContactData contactData) {
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

    private void returnToGroupPage(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    private void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }


    private void initContactCreation(By add_new) {
        driver.findElement(add_new).click();
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
