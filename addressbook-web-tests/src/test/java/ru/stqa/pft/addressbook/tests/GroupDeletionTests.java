package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    applicationManages.gotoGroupPage("groups");
    applicationManages.selectGroup();
    applicationManages.deleteSelectedGroups("(//input[@name='delete'])[1]");
    applicationManages.returnToGroupPage("group page");

  }


}
