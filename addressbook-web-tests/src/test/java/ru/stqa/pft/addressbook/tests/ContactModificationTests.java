package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test

public void testContactModification(){
        applicationManages.getNavigationHelper().gotoHomePage();
        applicationManages.getContactHelper().initContactModification();
        applicationManages.getContactHelper().fillContactForm(new ContactData("abcde", "def", "ghj", "Kaledo", "Amaru", "The best", "la-la-la", "Kirovsk", "8-123-456-789", "tra-la-la", "123456789", "Kaledo", "Kaledo2", "Kaledo3", "1234", "28", "May", "1985", "28", "May", "1985", "BPS", "6", "1234567890"));
        applicationManages.getContactHelper().submitContactModification();
        applicationManages.getContactHelper().returnToHomePage("home page");
    }
}
