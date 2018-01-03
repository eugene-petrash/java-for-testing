package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.GroupData;

import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupsList();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test11", "test22", "test33"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupsList();
        if (before.size() > 0) {
            Assert.assertEquals(after.size(), before.size());
        }
        else if (before.size() == 0) {
            Assert.assertEquals(after.size(), before.size() + 1);
        }
    }

}
