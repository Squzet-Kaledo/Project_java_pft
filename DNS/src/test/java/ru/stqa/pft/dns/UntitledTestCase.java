package com.example.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;
import static org.testng.Assert.*;

public class UntitledTestCase<pumo> {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private WebElement f;
  private Object p;
  private WebElement jo;
  private int n;
  private Object String;


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
            .moveToElement(element1, 160, 5)
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
/*
    SeleniumAssertion check = new SeleniumAssertion(driver);
    check.assertNotPresentElementLocated(By.cssSelector(".product-price__current"));

    boolean a = isElementPresent(By.cssSelector(".product-price__current"));
    boolean b = isElementPresent(By.cssSelector(".product-price__currenfjgjt"));
    SoftAssert s = new SoftAssert();
    s.assertEquals(a,false,"Элемент присутствует");
    s.assertEquals(b,true,"Элемент отсутствует");
    s.assertAll();

    isElementPresent(By.cssSelector(".product-price__current"));
*/
   /*WebElement n = driver.findElement(By.cssSelector(".ui-checkbox-group"));
   n.findElement(By.cssSelector("span:nth-child(3)"));

   assertTrue(driver.findElement(By.cssSelector(".ui-checkbox-group")).getText().contains("Мурино на Шувалова"));
*/

/*
    List<WebElement> linksToClick = driver.findElement(By.cssSelector(".ui-checkbox-group")).findElements(By.cssSelector(".ui-checkbox"));
    List<String> myList = linksToClick.collect(Collectors.toList());
*/
/*
   String linksToClik = driver.findElement(By.cssSelector(".ui-checkbox-group")).getText();
   ArrayList<String> arrayList=new ArrayList(Arrays.asList(linksToClik.split("\n",183)));
   Collections.sort(arrayList);
   System.out.print(arrayList.size());
   ArrayList<String> arrayList2=new ArrayList(Arrays.asList(linksToClik.split("\n",183)));
   Assert.assertEquals(arrayList,arrayList2);
*/
    jo = driver.findElement(By.cssSelector(".ui-checkbox-group"));
    ArrayList<WebElement> element = (ArrayList<WebElement>) jo.findElements(By.cssSelector(".ui-checkbox"));
    String pumo = "ААААААААААААААААААААААААААААААААААААА";
    for (WebElement elements: element) {
      pumo+="><><><" + elements.getText(); }
    ArrayList<String> jin = new ArrayList(Arrays.asList(pumo.split("><><><",100)));
    jin.remove("ААААААААААААААААААААААААААААААААААААА");
   Collections.sort(jin);
    ArrayList<String> jin2 = new ArrayList(Arrays.asList(pumo.split("><><><",100)));
    jin2.remove("ААААААААААААААААААААААААААААААААААААА");
    ;Assert.assertEquals(jin2,jin);
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
