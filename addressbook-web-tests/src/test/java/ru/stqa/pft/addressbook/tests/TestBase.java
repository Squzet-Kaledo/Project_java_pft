package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.addressbook.appmanager.ApplicationManages;

import static org.testng.Assert.fail;

public class TestBase {

    protected final ApplicationManages applicationManages = new ApplicationManages();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        applicationManages.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        applicationManages.stop();
        String verificationErrorString = applicationManages.verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
