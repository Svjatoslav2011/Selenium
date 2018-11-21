package ru.stqa.ptf.addressbook.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.gotoGroups();
        app.driver.findElement(By.name("new")).click();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Y7", "Y7", "Y7"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
