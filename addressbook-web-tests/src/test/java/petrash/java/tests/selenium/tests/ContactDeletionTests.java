package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;

import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        int contactIndex = 0;
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Eugene", "Petrash",
                    "+380957119579", "petrash.evgeniy@gmail.com", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactsList();
        app.getContactHelper().selectContact(contactIndex);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(contactIndex);
        Assert.assertEquals(before, after);
    }
}
