package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    private final GroupHelper groupHelper = new GroupHelper();
    public StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    public void init() {
        groupHelper.driver = new ChromeDriver();
        groupHelper.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper.driver.get("http://localhost/addressbook/group.php");
        login("admin", "secret");
    }

    public void login(String username, String password) {
        groupHelper.driver.findElement(By.name("user")).click();
        groupHelper.driver.findElement(By.name("user")).clear();
        groupHelper.driver.findElement(By.name("user")).sendKeys(username);
        groupHelper.driver.findElement(By.name("pass")).clear();
        groupHelper.driver.findElement(By.name("pass")).sendKeys(password);
        groupHelper.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    }

    public void gotoGroups() {
        groupHelper.driver.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        groupHelper.driver.quit();
    }

    public boolean isElementPresent(By by) {
        try {
            groupHelper.driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            groupHelper.driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = groupHelper.driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
