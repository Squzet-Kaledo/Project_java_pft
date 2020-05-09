package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    applicationManages.getNavigationHelper().gotoHomePage();
    applicationManages.getContactHelper().selectContact(By.name("selected[]"));
    applicationManages.getContactHelper().deleteSelectedContacts();
  }

}