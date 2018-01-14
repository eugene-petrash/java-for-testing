package petrash.java.tests.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import petrash.java.tests.selenium.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupsList();
        GroupData group = new GroupData("test2", null, null);
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() + 1 );

        group.setId(
            after.stream().max(
                    (group1, group2) -> Integer.compare( group1.getId(), group2.getId() )
            )  // find and return group with max ID
            .get().getId() // Return ID from group with max ID
        );

        before.add(group);

        Assert.assertEquals(new HashSet<GroupData>(before), new HashSet<GroupData>(after));
    }
}
