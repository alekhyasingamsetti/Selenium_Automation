package org.example.Selenium_Basics01;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class Selenium_05 {
    @Test
    public void test() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");
        driver.quit();
    }
}
