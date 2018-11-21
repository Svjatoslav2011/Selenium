package ru.stqa.ptf.addressbook.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.ptf.addressbook.appmanager.ApplicationMAnager;

import static org.testng.Assert.fail;

public class TestBase {

    protected final ApplicationMAnager app = new ApplicationMAnager();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
        String verificationErrorString = app.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}