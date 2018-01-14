package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by petrash on 12/16/17.
 */
public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification () {
        int groupIndex = 0;

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupsList();
        GroupData group = new GroupData(before.get(groupIndex).getId(), "test11", "test22", "test33");

        app.getGroupHelper().selectGroup(groupIndex);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(groupIndex);
        before.add(group);
        Comparator<? super GroupData> byID = (group1, group2) -> Integer.compare(group1.getId(), group2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }

}
