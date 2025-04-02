package org.example.Selenium_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Selenium_08 {
    @Description("verify the link")
    @Test
    public void link(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("---start-maximized");
        WebDriver driver =  new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com");
        WebElement Partiallink = driver.findElement(By.partialLinkText("trial"));
        Partiallink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }












   // <a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage"
    // class="text-link"
    // data-qa="bericafeqo">Start a free trial</a>
}
