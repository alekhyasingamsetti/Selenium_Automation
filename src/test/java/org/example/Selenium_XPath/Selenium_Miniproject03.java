package org.example.Selenium_XPath;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//1. Navigate to the URL - [﻿katalon-demo-cura.herokuapp.com/](https://katalon-demo-cura.herokuapp.com/)
//2. Enter the username, password
//3. Verify that after submit, URL changes to appointment url
public class Selenium_Miniproject03 {
    @Description("Verify the email,password,make appointment")
    @Test
    public void Appointment(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("---start-maximized");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        //click on make appointment button
        //<a id="btn-make-appointment" href="./profile.php#login"
        // class="btn btn-dark btn-lg">Make Appointment</a>
        WebElement makeappointment = driver.findElement(By.id("btn-make-appointment"));
        makeappointment.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");
        //fill the email and password
        //<input type="text" class="form-control"
        // id="txt-username" name="username" placeholder="Username" value="" autocomplete="off">
        //<input type="password" class="form-control"
        // id="txt-password" name="password" placeholder="Password" value="" autocomplete="off">
        List<WebElement> emailId=driver.findElements(By.xpath("//input[@name='username']"));
        emailId.get(0).sendKeys("John Doe");
        List<WebElement> password=driver.findElements(By.xpath("//input[@id='txt-password']"));
        password.get(0).sendKeys("ThisIsNotAPassword");
        List<WebElement> Loginbutton=driver.findElements(By.xpath("//button[@id='btn-login']"));
        Loginbutton.get(0).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        driver.quit();

    }
}
