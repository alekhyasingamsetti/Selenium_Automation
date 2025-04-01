package org.example.Selenium_Basics01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_07 {
    @Description("Open the URL")
    @Test
    public void test02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.navigate().to("https://bing.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
