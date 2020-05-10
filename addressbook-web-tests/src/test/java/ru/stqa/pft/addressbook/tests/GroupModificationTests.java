package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        applicationManages.getNavigationHelper().gotoGroupPage();
        applicationManages.getGroupHelper().selectGroup();
        applicationManages.getGroupHelper().initGroupModification();
        applicationManages.getGroupHelper().fillGroupForm(new GroupData("test4", "test5", "test6"));
        applicationManages.getGroupHelper().submitGroupModification();
        applicationManages.getGroupHelper().returnToGroupPage("group page");
    }
}
