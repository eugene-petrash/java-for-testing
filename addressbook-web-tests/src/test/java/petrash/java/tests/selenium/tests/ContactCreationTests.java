package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactsList();
        ContactData contact = new ContactData("Eugene", "Petrash",
                "+380957119579", "petrash.evgeniy@gmail.com", "test1");
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().fillContactForm(contact, true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactsList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byID = Comparator.comparingInt(ContactData::getId);
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }

}
