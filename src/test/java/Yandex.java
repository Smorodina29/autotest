
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Yandex {
    @Test
    public void searchCleaner() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.yandex.ru/");
        WebElement search = driver.findElement(By.name("text"));
        search.sendKeys("пылесос дайсон");
        driver.findElement(By.className("search2__button")).click();
        driver.findElement(By.partialLinkText("dyson.com.ru")).click();
        sleep(300);
        //driver.findElement(By.name("ctl00_content_0_InnerCarousel_SlidesRepeater_ctl00_standardSlide_StandardSlideDiv"));
        driver.findElement(By.partialLinkText("a[href*=\"http://shop.dyson.ru/accessories/?_ga=2.15555189.2118758860.1525258819-759201117.1525258819\"]")).click();


        //driver.findElement(By.className("videoContentOverlay rsABlock slideContentBlock SlideContentLeftAligned"));

        //проверка по слайду на наличие пылесоса small ball
        //Assert.assertEquals(driver.findElement(By.name("ctl00_content_0_InnerCarousel_SlidesRepeater_ctl02_standardSlide_StandardSlideDiv")), "ctl00_content_0_InnerCarousel_SlidesRepeater_ctl02_standardSlide_StandardSlideDiv");
        //driver.findElement(By.linkText("Ассортимент")).click();
        /*driver.findElement(By.cssSelector("ul#navFlag li:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector("ul#megamenu li:nth-of-type(6)")).click();*/
        //driver.findElement(By.cssSelector("//div[@id='ctl00_wrapperContent']/header/nav/nav/ul/li[2]")).click();
        //driver.findElement(By.name("ctl00_cphNavigation_topNavigation1_TopNavigationLinksRepeater_ctl02_TopNavigationDetailRepeater_ctl06_SubMenuLink")).click();
       // driver.findElement(By.linkText("Насадки и аксессуары")).click();
        driver.close();
    }

    @Test
    public void TestDyson() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.dyson.com.ru/");
        sleep(3000);
        driver.findElement(By.cssSelector("a[href*=\"http://shop.dyson.ru/accessories/?_ga=2.15555189.2118758860.1525258819-759201117.1525258819\"]"));
        sleep(3000);

        /*//driver.findElement(By.cssSelector("ul#navFlag li:nth-of-type(2)")).click();
        driver.findElement(By.cssSelector("a[href*=\"shop.dyson.ru/accessories\"]")).click();*/
        driver.close();

    }

}