
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://comaqa.by/en/");
    }

    @AfterMethod    public void close(){
        driver.close();
    }
    @Test
    public void chechTitleTest(){
        Assert.assertEquals(driver.getTitle(), "QA Conference in Minsk COMAQA Spring | COMAQA.BY – QA Automation Community Belarus");

        /*WebDriver driver = new FirefoxDriver();
        driver.get("https://www.yandex.ru/");
        driver.findElement("input__control input__input").
        Assert.assertEquals(driver.getTitle(), "MyWish");
        driver.close();*/
    }
}
