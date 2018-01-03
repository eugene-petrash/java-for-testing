package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;
import petrash.java.tests.selenium.model.GroupData;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        int before = app.getContactHelper().getContactsCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Eugene", "Petrash",
                    "+380957119579", "petrash.evgeniy@gmail.com", "test1"));
        }
        app.getContactHelper().selectContact(0);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContactHelper().getContactsCount();
        if (before > 0) {
            Assert.assertEquals(after, before - 1);
        }
        else if (before == 0) {
            Assert.assertEquals(after, before);
        }
    }
}
