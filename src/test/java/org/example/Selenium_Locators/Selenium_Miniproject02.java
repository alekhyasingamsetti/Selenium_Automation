package org.example.Selenium_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Selenium_Miniproject02 {
    @Description("click on the link and give invalid emailID and check the Error")
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
        Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/free-trial/?utm_medium=website&utm_source=login-page&utm_campaign=mof_eg_loginpage");
        //Fill the invalid emailID
        //<input class="W(100%) Py(14px) input-text" placeholder="name@yourcompany.com"
        // type="email" id="page-v1-step1-email" name="email" data-qa="page-su-step1-v1-email" required="">
        WebElement EmailId = driver.findElement(By.id("page-v1-step1-email"));
        EmailId.sendKeys("abcd");
        //checkbox <input class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)" type="checkbox"
        // name="gdpr_consent_checkbox" id="page-free-trial-step1-cu-gdpr-consent-checkbox"
        // value="true" data-qa="page-free-trial-step1-gdpr-consent-checkbox">
        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();
        //submit button
        //<button type="submit" disabled="" class="button button--disabled-primary W(100%) btn-modal-form-submit"
        // data-qa="page-su-submit">Create a Free Trial Account</button>
        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //check the error
        //<div class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s)
        // Op(0) invalid-input+Op(1) invalid-reason">
        // The email address you entered is incorrect.</div>
        WebElement ErrorMsg = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(ErrorMsg.getText(),"The email address you entered is incorrect.");


        driver.quit();
    }
}
