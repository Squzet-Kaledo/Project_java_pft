package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        applicationManages.gotoGroupPage("groups");
        applicationManages.initGroupCreation("new");
        applicationManages.fillGroupForm(new GroupData("test1", "test2", "test3"));
        applicationManages.submitGroupCreation();
        applicationManages.returnToGroupPage("group page");
    }

}