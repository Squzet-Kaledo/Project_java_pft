package ru.stqa.pft.addressbook;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    gotoGroupPage("groups");
    selectGroup();
    deleteSelectedGroups("(//input[@name='delete'])[1]");
    returnToGroupPage("group page");

  }


}
