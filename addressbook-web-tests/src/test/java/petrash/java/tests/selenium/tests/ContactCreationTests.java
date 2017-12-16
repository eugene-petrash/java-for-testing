package petrash.java.tests.selenium.tests;

import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goToContactPage();
        app.fillContactForm(new ContactData("Eugene", "Petrash",
                "+380957119579", "petrash.evgeniy@gmail.com"));
        app.submitContactCreation();
        app.returnToHomePage();
    }

}
