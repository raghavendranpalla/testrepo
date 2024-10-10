package com.orangehrmlive.demo.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public By username = By.name("username");
    public By password = By.name("password");
    public By loginButton = By.tagName("button");

    public WebDriver driver;
    private String baseURL = "https://opensource-demo.orangehrmlive.com";

    @BeforeMethod(alwaysRun = true)
    public void beforeTestMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(baseURL);
        login("Admin", "admin123");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTestMethod() {
        driver.quit();
    }

    public void login(String usernameVal, String passwordVal) {
        type(username, usernameVal);
        type(password, passwordVal);
        click(loginButton);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void type(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void pause(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (Exception e) {

        }
    }

}
