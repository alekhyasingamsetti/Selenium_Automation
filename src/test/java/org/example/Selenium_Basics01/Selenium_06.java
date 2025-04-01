package org.example.Selenium_Basics01;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Selenium_06 {
    @Description("Open the URL")
    @Test
    public void test01(){
        WebDriver driver=new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        if(driver.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("CURA Healthcare Service is visbile");
            //Assert.assertTrue(true);
        }
        else {
            //Assert.assertFalse(false);
            System.out.println("CURA Healthcare Service is not visible");
        }
        driver.quit();
    }
}
