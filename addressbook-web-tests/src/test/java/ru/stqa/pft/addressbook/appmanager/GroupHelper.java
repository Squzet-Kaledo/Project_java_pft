package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.openqa.selenium.By.*;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage(String s) {
        click(linkText(s));
    }

    public void submitGroupCreation() {
        click(name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation(String s) {
        click(name(s));
    }

    public void deleteSelectedGroups(String s) {
        click(xpath(s));
    }

    public void selectGroup() {
        click(xpath("(//input[@name='selected[]'])[1]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}

