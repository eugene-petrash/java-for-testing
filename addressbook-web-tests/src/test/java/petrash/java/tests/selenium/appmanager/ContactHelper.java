package petrash.java.tests.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import petrash.java.tests.selenium.model.ContactData;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contact) {
        sendKeys(By.name("firstname"), contact.getFirstName());
        sendKeys(By.name("lastname"), contact.getLastName());
        sendKeys(By.name("mobile"), contact.getMobilePhone());
        sendKeys(By.name("email"), contact.getEmail());
    }
}
