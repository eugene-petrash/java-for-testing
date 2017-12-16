package petrash.java.tests.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import petrash.java.tests.selenium.model.GroupData;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(ChromeDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        sendKeys(By.name("group_name"), groupData.getName());
        sendKeys(By.name("group_header"), groupData.getHeader());
        sendKeys(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
