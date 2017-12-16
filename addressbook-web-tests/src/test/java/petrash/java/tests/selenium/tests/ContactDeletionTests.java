package petrash.java.tests.selenium.tests;

import org.testng.annotations.Test;

/**
 * Created by petrash on 12/16/17.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().returnToHomePage();
    }
}
