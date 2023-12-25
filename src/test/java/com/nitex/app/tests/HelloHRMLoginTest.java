package com.nitex.app.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloHRMLoginTest {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the HelloHRM login page
            driver.get("https://app.hellohrm.com/login");

            // Input username or email and password
            WebElement usernameInput = driver.findElement(By.id("username"));
            WebElement passwordInput = driver.findElement(By.id("password"));

            Thread.sleep(2000);
            usernameInput.sendKeys("farhademp24feb");
            Thread.sleep(2000);
            passwordInput.sendKeys("123456");

            // Submit the login form
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"kt_login_signin_form\"]/div[4]/button"));
            loginButton.click();
            Thread.sleep(3000);

            // Verify successful login
            String expectedUrl = "https://app.hellohrm.com/dashboard";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Login is successful.");
            } else {
                System.out.println("Login is not successful.");
            }

        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}