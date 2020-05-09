package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    applicationManages.getNavigationHelper().gotoGroupPage();
    applicationManages.getGroupHelper().selectGroup();
    applicationManages.getGroupHelper().deleteSelectedGroups("(//input[@name='delete'])[1]");
    applicationManages.getGroupHelper().returnToGroupPage("group page");

  }


}
