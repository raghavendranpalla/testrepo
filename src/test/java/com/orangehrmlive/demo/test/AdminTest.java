package com.orangehrmlive.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    public By adminLoc = By.xpath("kdukccbsjkbjkb");
    public By adminLocCorrect = By.xpath("//a//span[text()='Admin']");

    @Test
    public void testNavigateToAdminPage() {
        try {
            click(adminLoc);
        } catch (NoSuchElementException e) {
            pause(2);
            click(adminLocCorrect);
        }
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
        String currentPageURL = driver.getCurrentUrl();
        pause(3);
        Assert.assertTrue(currentPageURL.contains("admin"), "Validate url contains Admin");
        Assert.assertEquals(currentPageURL, expectedUrl);

    }
}
