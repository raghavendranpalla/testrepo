package com.orangehrmlive.demo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends  BaseTest {


    public By dashBoard = By.xpath("//h6[text()='Dashboard']");
    public By invalidaCredentials = By.xpath("//p[text()='Invalid credentials']");


    @Test(priority = 0)
    public void testLogInPositive() {
        boolean isDashBoardDisplayed =find(dashBoard).isDisplayed();
        Assert.assertTrue(isDashBoardDisplayed, "validate dashboard header displayed");
    }

    @Test(priority = 1)
    public void testLogInNeg() {
        login("Admin", "admin12364567");
        boolean isInValidDisplayed = find(invalidaCredentials).isDisplayed();
        Assert.assertTrue(isInValidDisplayed, "validate invalid credentials displayed");
    }





}
