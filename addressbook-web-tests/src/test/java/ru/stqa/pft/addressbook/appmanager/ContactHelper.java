package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase{
    private WebDriver driver;
    private boolean acceptNextAlert;

    public ContactHelper(WebDriver driver) {
        this.driver=driver;
    }

    public void initContactCreation(String s) {
        click(By.name(s));
    }

    public void deleteSelectedContacts() {
        acceptNextAlert = true;
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
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
    public void selectContact(By name) {
        click(name);
    }

    public void fillContactForm(ContactData contactData) {
        type( By.name("firstname"), contactData.getFirstname());
        type( By.name("middlename"), contactData.getMiddlename());
        type( By.name("lastname"), contactData.getLastname());
        type( By.name("nickname"), contactData.getNickname());
        type( By.name("title"), contactData.getTitle());
        type( By.name("company"), contactData.getCompany());
        type( By.name("address"), contactData.getAddress());
        type( By.name("home"), contactData.getHome());
        type( By.name("mobile"), contactData.getMobile());
        type( By.name("work"), contactData.getWork());
        type( By.name("fax"), contactData.getFax());
        type( By.name("email"), contactData.getEmail());
        type( By.name("email2"), contactData.getEmail2());
        type( By.name("email3"), contactData.getEmail3());
        type( By.name("homepage"), contactData.getHomepage());
        click(By.name("bday"));
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        click(By.name("bday"));
        click(By.name("bmonth"));
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        click(By.name("bmonth"));
        type( By.name("byear"), contactData.getByear());
        click(By.name("aday"));
        new Select(driver.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
        click(By.name("aday"));
        click(By.name("amonth"));
        new Select(driver.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());
        click(By.name("amonth"));
        type( By.name("ayear"), contactData.getAyear());
        type( By.name("address2"), contactData.getAddress2());
        type( By.name("phone2"), contactData.getPhone2());


    }

    private void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void returnToHomePage(String s) {
        click(By.linkText(s));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    private void click(By locator) {
        driver.findElement(locator).click();
    }

    public void initContactCreation(By add_new) {
        click(add_new);
    }
}
