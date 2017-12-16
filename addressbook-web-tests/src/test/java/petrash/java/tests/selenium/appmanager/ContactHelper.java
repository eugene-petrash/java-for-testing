package petrash.java.tests.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import petrash.java.tests.selenium.model.ContactData;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactHelper {
    private ChromeDriver wd;

    public ContactHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillContactForm(ContactData contact) {
        wd.findElement(By.name("firstname")).sendKeys(contact.getFirstName());
        wd.findElement(By.name("lastname")).sendKeys(contact.getLastName());
        wd.findElement(By.name("mobile")).sendKeys(contact.getMobilePhone());
        wd.findElement(By.name("email")).sendKeys(contact.getEmail());
    }
}
