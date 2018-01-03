package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;
import petrash.java.tests.selenium.model.GroupData;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        int before = app.getContactHelper().getContactsCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Eugene", "Petrash",
                    "+380957119579", "petrash.evgeniy@gmail.com", "test1"));
        }
        app.getContactHelper().initContactModification(0);
        app.getContactHelper().fillContactForm(new ContactData("Albert", "Einstein",
                "+1234567890", "instein@gmail.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContactHelper().getContactsCount();
        if (before > 0) {
            Assert.assertEquals(after, before);
        }
        else if (before == 0) {
            Assert.assertEquals(after, before + 1);
        }
    }
}
