import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.lang.Thread.sleep;

public class AboutAsTest {
    WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://comaqa.by/en/");
    }

    @AfterMethod()
    public void tearDown(){
        driver.close();
    }

    @Test()
    public void checkAboutUsTitle() throws InterruptedException {
        WebElement aboutUsButton = driver.findElement(By.cssSelector("a[href*=\"about-us-en\"]"));
        aboutUsButton.click();
        sleep(3000);
        Assert.assertEquals(driver.getTitle(), "About us | COMAQA.BY – QA Automation Community Belarus");
    }
}

