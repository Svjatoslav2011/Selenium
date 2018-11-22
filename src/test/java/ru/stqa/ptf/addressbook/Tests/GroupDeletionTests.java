package ru.stqa.ptf.addressbook.Tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testGroupDeletion() throws Exception {
        app.gotoGroups();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

}
