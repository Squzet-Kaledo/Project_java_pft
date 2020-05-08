package com.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.ContactData;
import ru.stqa.pft.addressbook.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        initContactCreation(By.linkText("add new"));
        fillContactForm(new ContactData("abc", "def", "ghj", "Kaledo", "Amaru", "The best", "la-la-la", "Kirovsk", "8-123-456-789", "tra-la-la", "123456789", "Kaledo", "Kaledo2", "Kaledo3", "1234", "28", "May", "1985", "28", "May", "1985", "BPS", "6", "1234567890"));
        submitContactCreation();
        returnToHomePage("home page");
    }


}


