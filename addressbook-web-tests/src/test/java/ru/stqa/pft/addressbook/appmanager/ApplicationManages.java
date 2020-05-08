package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ApplicationManages {
    public WebDriver driver;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    public String baseUrl;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
        driver =  new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin","secret");
    }

    public void login(String username, String password) {
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void returnToGroupPage(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation(String s) {
        driver.findElement(By.name(s)).click();
    }

    public void initContactCreation(String s) {
        driver.findElement(By.name(s)).click();
    }

    public void gotoGroupPage(String groups) {
        returnToGroupPage(groups);
    }

    public void gotoAddNewPage(String addnew) {
        returnToGroupPage(addnew);
    }

    public void gotoHomePage(String home) {
        returnToGroupPage(home);
    }

    public void stop() {
        driver.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
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

    public void deleteSelectedGroups(String s) {
      driver.findElement(By.xpath(s)).click();
    }

    public void selectGroup() {
      driver.findElement(By.xpath("(//input[@name='selected[]'])[1]")).click();
    }

    public void deleteSelectedContacts() {
      driver.findElement(By.xpath("//input[@value='Delete']")).click();
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectContact(By name) {
      driver.findElement(name).click();
    }

    public void fillContactForm(ContactData contactData) {
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

    public void returnToHomePage(String s) {
        driver.findElement(By.linkText(s)).click();
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void initContactCreation(By add_new) {
        driver.findElement(add_new).click();
    }
}
