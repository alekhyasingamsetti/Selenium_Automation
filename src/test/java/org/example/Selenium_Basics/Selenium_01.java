package org.example.Selenium_Basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium_01 {

    @Test
    public void verifyLogin()
    {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getSessionId());
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
