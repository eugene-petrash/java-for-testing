package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;
import petrash.java.tests.selenium.model.GroupData;

import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        List<ContactData> before = app.getContactHelper().getContactsList();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Eugene", "Petrash",
                    "+380957119579", "petrash.evgeniy@gmail.com", "test1"));
        }
        app.getContactHelper().initContactModification(0);
        app.getContactHelper().fillContactForm(new ContactData("Albert", "Einstein",
                "+1234567890", "instein@gmail.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        if (before.size() > 0) {
            Assert.assertEquals(after.size(), before.size());
        }
        else if (before.size() == 0) {
            Assert.assertEquals(after.size(), before.size() + 1);
        }
    }
}
