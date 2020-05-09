package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        applicationManages.getNavigationHelper().gotoGroupPage();
        applicationManages.getGroupHelper().initGroupCreation("new");
        applicationManages.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        applicationManages.getGroupHelper().submitGroupCreation();
        applicationManages.getGroupHelper().returnToGroupPage("group page");
    }

}