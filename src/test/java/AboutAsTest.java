
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AboutAsTest {
    private WebDriver driver;

    @Before()
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://comaqa.by/en/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After()
    public void tearDown(){
        driver.close();
    }

    @Test
    public void checkAboutUsTitle() throws InterruptedException {
        WebDriver driver = this.driver;
        WebElement element = driver.findElement(By.cssSelector("a[href*=\"about-us-en\"]"));
        element.click();
        sleep(3000);
        Assert.assertEquals(this.driver.getTitle(), "About us | COMAQA.BY – QA Automation Community Belarus");
    }
}

