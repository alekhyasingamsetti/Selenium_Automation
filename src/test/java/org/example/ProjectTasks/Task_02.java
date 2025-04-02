package org.example.ProjectTasks;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class Task_02  {
    @Description("Automate the full flow for the Katalong site and logout")
    @Test
    public void Fullflow() throws Exception{
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

        //Makeappointment
        //<select id="combo_facility" name="facility" class="form-control">
        //<option value="Tokyo CURA Healthcare Center">Tokyo CURA Healthcare Center</option>
        //<option value="Hongkong CURA Healthcare Center">Hongkong CURA Healthcare Center</option>
        //<option value="Seoul CURA Healthcare Center">Seoul CURA Healthcare Center</option>
        //</select>
        WebElement Facility= driver.findElement(By.id("combo_facility"));
        Select dropdown=new Select(Facility);
        dropdown.selectByIndex(1);
        //checkbox
        //<input type="checkbox" id="chk_hospotal_readmission" name="hospital_readmission" value="Yes">
        WebElement checkbox=driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();
        //select radio button
        //<input type="radio" name="programs" id="radio_program_medicare" value="Medicare" checked="">
        WebElement radiobutton=driver.findElement(By.id("radio_program_medicare"));
        radiobutton.click();
        //provide dateofbirth
        //<input type="text" class="form-control"
        // id="txt_visit_date" name="visit_date" placeholder="dd/mm/yyyy" autocomplete="off" required="">
        WebElement visitDate=driver.findElement(By.id("txt_visit_date"));
        visitDate.sendKeys("02/04/2025");
        //add comment
        //<textarea class="form-control" id="txt_comment" name="comment" placeholder="Comment" rows="10"></textarea>
       WebElement comment=driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Need to make an Appointment");
        //Book Appointment button
        //<button id="btn-book-appointment" type="submit" class="btn btn-default">Book Appointment</button>
        WebElement Button=driver.findElement(By.id("btn-book-appointment"));
        Button.click();
        //<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i class="fa fa-bars"></i></a>
        driver.findElement(By.id("menu-toggle")).click();
        //<a href="authenticate.php?logout" onclick="$('#menu-close').click();">Logout</a>
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        driver.quit();

    }
}
