package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ApplicationManages {
    public WebDriver driver;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();
    public String baseUrl;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
        driver =  new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin","secret");
    }


    /* public void initContactCreation(String s) {
        groupHelper.driver.findElement(By.name(s)).click();
    }*/

    public void gotoAddNewPage(String addnew) {
        groupHelper.returnToGroupPage(addnew);
    }

    public void gotoHomePage(String home) {
        groupHelper.returnToGroupPage(home);
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
/*
    public void deleteSelectedContacts() {
      groupHelper.driver.findElement(By.xpath("//input[@value='Delete']")).click();
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void selectContact(By name) {
      groupHelper.driver.findElement(name).click();
    }

    public void fillContactForm(ContactData contactData) {
        groupHelper.driver.findElement(By.name("firstname")).click();
        groupHelper.driver.findElement(By.name("firstname")).clear();
        groupHelper.driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        groupHelper.driver.findElement(By.name("middlename")).clear();
        groupHelper.driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        groupHelper.driver.findElement(By.name("lastname")).clear();
        groupHelper.driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        groupHelper.driver.findElement(By.name("nickname")).clear();
        groupHelper.driver.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        groupHelper.driver.findElement(By.name("title")).clear();
        groupHelper.driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
        groupHelper.driver.findElement(By.name("company")).clear();
        groupHelper.driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
        groupHelper.driver.findElement(By.name("address")).clear();
        groupHelper.driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
        groupHelper.driver.findElement(By.name("home")).clear();
        groupHelper.driver.findElement(By.name("home")).sendKeys(contactData.getHome());
        groupHelper.driver.findElement(By.name("mobile")).clear();
        groupHelper.driver.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
        groupHelper.driver.findElement(By.name("work")).clear();
        groupHelper.driver.findElement(By.name("work")).sendKeys(contactData.getWork());
        groupHelper.driver.findElement(By.name("fax")).clear();
        groupHelper.driver.findElement(By.name("fax")).sendKeys(contactData.getFax());
        groupHelper.driver.findElement(By.name("email")).clear();
        groupHelper.driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
        groupHelper.driver.findElement(By.name("email2")).clear();
        groupHelper.driver.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
        groupHelper.driver.findElement(By.name("email3")).clear();
        groupHelper.driver.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
        groupHelper.driver.findElement(By.name("homepage")).clear();
        groupHelper.driver.findElement(By.name("homepage")).sendKeys(contactData.getHomepage());
        groupHelper.driver.findElement(By.name("bday")).click();
        new Select(groupHelper.driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        groupHelper.driver.findElement(By.name("bday")).click();
        groupHelper.driver.findElement(By.name("bmonth")).click();
        new Select(groupHelper.driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        groupHelper.driver.findElement(By.name("bmonth")).click();
        groupHelper.driver.findElement(By.name("byear")).click();
        groupHelper.driver.findElement(By.name("byear")).clear();
        groupHelper.driver.findElement(By.name("byear")).sendKeys(contactData.getByear());
        groupHelper.driver.findElement(By.name("aday")).click();
        new Select(groupHelper.driver.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
        groupHelper.driver.findElement(By.name("aday")).click();
        groupHelper.driver.findElement(By.name("amonth")).click();
        new Select(groupHelper.driver.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());
        groupHelper.driver.findElement(By.name("amonth")).click();
        groupHelper.driver.findElement(By.name("ayear")).click();
        groupHelper.driver.findElement(By.name("ayear")).clear();
        groupHelper.driver.findElement(By.name("ayear")).sendKeys(contactData.getAyear());
        groupHelper.driver.findElement(By.name("address2")).click();
        groupHelper.driver.findElement(By.name("address2")).clear();
        groupHelper.driver.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
        groupHelper.driver.findElement(By.name("phone2")).click();
        groupHelper.driver.findElement(By.name("phone2")).clear();
        groupHelper.driver.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());


    }

    public void returnToHomePage(String s) {
        groupHelper.driver.findElement(By.linkText(s)).click();
    }

    public void submitContactCreation() {
        groupHelper.driver.findElement(By.name("submit")).click();
    }

    public void initContactCreation(By add_new) {
        groupHelper.driver.findElement(add_new).click();
    }*/

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
