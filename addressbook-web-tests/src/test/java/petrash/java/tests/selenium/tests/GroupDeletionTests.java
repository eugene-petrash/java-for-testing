package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.GroupData;

import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        int groupIndex = 0;
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupsList();
        app.getGroupHelper().selectGroup(groupIndex);
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(groupIndex);
        Assert.assertEquals(before, after);
    }

}
