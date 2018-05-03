
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://comaqa.by/en/");
    }

    @After    public void close(){
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
