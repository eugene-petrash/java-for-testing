package petrash.java.tests.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import petrash.java.tests.selenium.model.ContactData;
import petrash.java.tests.selenium.model.GroupData;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactHelper extends HelperBase {

    private final NavigationHelper getNavigationHelper;
    private final GroupHelper getGroupHelper;

    public ContactHelper(WebDriver wd) {
        super(wd);
        this.getNavigationHelper = new NavigationHelper(wd);
        this.getGroupHelper = new GroupHelper(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contact, boolean creation) {
        sendKeys(By.name("firstname"), contact.getFirstName());
        sendKeys(By.name("lastname"), contact.getLastName());
        sendKeys(By.name("mobile"), contact.getMobilePhone());
        sendKeys(By.name("email"), contact.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("[alt='Edit']")).get(index).click();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContacts() {
        click(By.cssSelector("input[value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void createContact(ContactData contactData) {
        getNavigationHelper.goToGroupPage();
        if (! getGroupHelper.isThereAGroup()) {
            getGroupHelper.createGroup(new GroupData("test1", null, null));
        }
        getNavigationHelper.goToContactPage();
        fillContactForm(contactData, true);
        submitContactCreation();
        getNavigationHelper.returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
