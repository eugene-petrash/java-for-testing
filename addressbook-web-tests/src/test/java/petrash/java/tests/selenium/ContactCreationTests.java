package petrash.java.tests.selenium;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        goToContactPage();
        fillContactForm(new ContactData("Eugene", "Petrash",
                "+380957119579", "petrash.evgeniy@gmail.com"));
        submitContactCreation();
        returnToHomePage();
    }

}
