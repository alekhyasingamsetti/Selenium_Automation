package org.example.Selenium_Basics01;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium_Miniproject01 {

    @Description("Login to the page")
    @Test
    public void Login() throws Exception{
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("---start-maximized");
        WebDriver driver=new ChromeDriver(chromeoptions);
        driver.get("https://app.vwo.com");
        // 1. Find the email inputbox and enter the email
        //<input type="email"
        // class="text-input W(100%)"
        // name="username" id="login-username" data-qa="hocewoqisi">
        WebElement emailinput = driver.findElement(By.id("login-username"));
        emailinput.sendKeys("admin@admin.com");
        // 2. Find the password inputbox and enter the password
        //<input type="password"
        // class="text-input W(100%)"
        // name="password" id="login-password" data-qa="jobodapuxe">
        WebElement Passwordinput = driver.findElement(By.name("password"));
        Passwordinput.sendKeys("admin");
        //3.Click on submit button
        //<button type="submit" id="js-login-btn"
        // class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
        //									<span class="icon loader hidden" data-qa="zuyezasugu"></span>
        //									<span data-qa="ezazsuguuy">Sign in</span>
        //								</button>
        WebElement Submitbutton = driver.findElement(By.id("js-login-btn"));
        Submitbutton.click();
        Thread.sleep(3000);
        //4.Error notification
        //<div class="notification-box-description" id="js-notification-box-msg"
        // data-qa="rixawilomi">Your email, password, IP address or location did not match</div>
        WebElement notification = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(notification.getText(),"Your email, password, IP address or location did not match");
        driver.quit();

    }
}
