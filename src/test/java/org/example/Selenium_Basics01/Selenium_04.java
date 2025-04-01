package org.example.Selenium_Basics01;

import io.qameta.allure.Description;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selenium_04 {

    @Description("Open the URL")
    @Test
    public void VerifyURL(){
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
