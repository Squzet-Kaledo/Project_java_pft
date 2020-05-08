package ru.stqa.pft.addressbook;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    gotoGroupPage("home");
    selectContact(By.name("selected[]"));
    deleteSelectedContacts();
  }

}