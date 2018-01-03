package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.GroupData;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupsCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupsCount();
        if (before > 0) {
            Assert.assertEquals(after, before - 1);
        }
        else if (before == 0) {
            Assert.assertEquals(after, before);
        }
    }

}
