package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        int contactIndex = 0;

        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Eugene", "Petrash",
                    "+380957119579", "petrash.evgeniy@gmail.com", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactsList();
        ContactData contact = new ContactData(before.get(contactIndex).getId(), "Albert", "Einstein",
                "+1234567890", "instein@gmail.com", null);

        app.getContactHelper().initContactModification(contactIndex);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(contactIndex);
        before.add(contact);
        Comparator<? super ContactData> byID = Comparator.comparingInt(ContactData::getId);
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}
