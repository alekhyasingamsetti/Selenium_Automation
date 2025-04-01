package org.example.Selenium_Basics01;

import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_03 {
    @Description("Open the URL")
    @Test
    public void Login(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println(driver.getPageSource());
        driver.quit();
    }
}
