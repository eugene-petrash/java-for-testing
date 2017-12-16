package petrash.java.tests.selenium.tests;

import org.testng.annotations.Test;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().goToGroupPage();
    }

}
