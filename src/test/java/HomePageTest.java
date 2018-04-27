
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class HomePageTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://comaqa.by/en/");
    }
    @Test
    public void chechTitleTest(){
        Assert.assertEquals(driver.getTitle(), "QA Conference in Minsk COMAQA Spring | COMAQA.BY – QA Automation Community Belarus");
        driver.close();

        /*WebDriver driver = new FirefoxDriver();
        driver.get("https://www.yandex.ru/");
        driver.findElement("input__control input__input").
        Assert.assertEquals(driver.getTitle(), "MyWish");
        driver.close();*/
    }
}
