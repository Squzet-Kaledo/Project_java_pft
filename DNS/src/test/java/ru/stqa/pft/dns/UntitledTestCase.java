package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.stqa.pft.dns.SeleniumAssertion;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test
  public void testAssertion() {
    driver.get("https://www.dns-shop.ru/catalog/");
    WebElement element1 = driver.findElement(By.cssSelector(".catalog-spoiler"));
    new Actions(driver)
            .moveToElement(element1,160,5)
            .click()
            .perform();
    WebElement element2 = driver.findElement(By.linkText("Компьютеры"));
    new Actions(driver)
    .moveToElement(element2)
            .perform();
    WebElement element3 = driver.findElement(By.linkText("Комплектующие для ПК"));
    new Actions(driver)
            .moveToElement(element3)
            .click()
            .perform();
    driver.findElement(By.linkText("Процессоры")).click();
    driver.findElement(By.cssSelector(".ui-checkbox-dropdown__label")).click();

    SeleniumAssertion check = new SeleniumAssertion(driver);
    check.assertNotPresentElementLocated(By.cssSelector(".product-price__current"));

    boolean a = isElementPresent(By.cssSelector(".product-price__current"));
    boolean b = isElementPresent(By.cssSelector(".product-price__currenfjgjt"));
    SoftAssert s = new SoftAssert();
    s.assertEquals(a,false,"Элемент присутствует");
    s.assertEquals(b,true,"Элемент отсутствует");
    s.assertAll();



    /*SoftAssert a = new SoftAssert();
    a.assertEquals(By.cssSelector(".product-price__current"));

    a.assertAll();
   /* assertFalse(isElementPresent(By.cssSelector("label:nth-child(2) span")));*/

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
