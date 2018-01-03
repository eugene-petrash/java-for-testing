package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        int before = app.getContactHelper().getContactsCount();
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Eugene", "Petrash",
                "+380957119579", "petrash.evgeniy@gmail.com", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContactHelper().getContactsCount();
        Assert.assertEquals(after, before + 1);
    }

}
