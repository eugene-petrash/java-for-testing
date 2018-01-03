package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.GroupData;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupsCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test11", "test22", "test33"));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupPage();
        int after = app.getGroupHelper().getGroupsCount();
        if (before > 0) {
            Assert.assertEquals(after, before);
        }
        else if (before == 0) {
            Assert.assertEquals(after, before + 1);
        }
    }

}
