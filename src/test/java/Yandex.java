import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class Yandex {
    @Test
    public void searchCleaner() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.yandex.ru/search/?lr=2&text=%D0%BF%D1%8B%D0%BB%D0%B5%D1%81%D0%BE%D1%81%20%D0%B4%D0%B0%D0%B9%D1%81%D0%BE%D0%BD");
        driver.findElement(By.partialLinkText("dyson.com.ru")).click();
       // sleep(10000);
        //Assert(driver.getWindowHandle())
                //("Wikipedia").click()
       // Assert.assertEquals(driver.findElement(By.partialLinkText("//shop.dyson.ru")), "//shop.dyson.ru");
        driver.close();
    }

}