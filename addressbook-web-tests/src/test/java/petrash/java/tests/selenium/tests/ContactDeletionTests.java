package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;
import petrash.java.tests.selenium.model.GroupData;

import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.getContactHelper().getContactsList();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Eugene", "Petrash",
                    "+380957119579", "petrash.evgeniy@gmail.com", "test1"));
        }
        app.getContactHelper().selectContact(0);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        if (before.size() > 0) {
            Assert.assertEquals(after.size(), before.size() - 1);
        }
        else if (before.size() == 0) {
            Assert.assertEquals(after.size(), before.size());
        }
    }
}
