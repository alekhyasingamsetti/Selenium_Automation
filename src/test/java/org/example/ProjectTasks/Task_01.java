package org.example.ProjectTasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_01 {

    @Description("Login to the page")
    @Test
    public void LoginPage() throws Exception{
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("---start-maximized");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        //1.give User name
        //<input type="text" class="form-control" id="txt-username" name="username"
        // placeholder="Username" value="" autocomplete="off">
        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");
        Thread.sleep(2000);
        //2.Enter password
        //<input type="password" class="form-control" id="txt-password"
        // name="password" placeholder="Password" value="" autocomplete="off">
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("ThisIsNotAPassword");
        //3.click on login button
        //<button id="btn-login" type="submit" class="btn btn-default">Login</button>
        WebElement loginbutton = driver.findElement(By.id("btn-login"));
        loginbutton.click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        // **Verify Page contains "Make Appointment" heading**
        Assert.assertTrue(driver.getPageSource().contains("Make Appointment"), "Page does not contain expected heading!");
         driver.quit();

    }
}
