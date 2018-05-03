import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Dyson {

    private WebDriver driver;

    @Before
    public void start(){
        driver = new ChromeDriver();
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void searchCleaner() throws InterruptedException {
        driver.get("https://www.yandex.ru/");
        String originalWindow = driver.getWindowHandle();
        final Set<String> oldWindowsSet = driver.getWindowHandles();

        WebElement search = driver.findElement(By.name("text"));
        search.sendKeys("пылесос дайсон");
        driver.findElement(By.className("search2__button")).click();


        driver.findElement(By.partialLinkText("dyson.com.ru")).click();

        String newWindow = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );

        driver.switchTo().window(newWindow);

        boolean isPresent = driver.findElements(By.id("ctl00_content_0_InnerCarousel_SlidesRepeater_ctl00_standardSlide_StandardSlideDiv")).size() > 0;
        Assert.assertEquals(isPresent, true);

        WebElement element = driver.findElement(By.id("ctl00_cphNavigation_topNavigation1_TopNavigationLinksRepeater_ctl02_TopNavigationLink"));
        Thread.sleep(3000);
        element.click();
        WebElement element2 = driver.findElement(By.id("ctl00_cphNavigation_topNavigation1_TopNavigationLinksRepeater_ctl02_TopNavigationDetailRepeater_ctl06_SubMenuLink"));
        Thread.sleep(3000);
        element2.click();
        Thread.sleep(3000);
        boolean isPresent2 = driver.findElements(By.cssSelector("a[href*=\"/accessories/hepa-filter-968125-05\"]")).size() > 0;
        Assert.assertEquals(isPresent2, true);
    }

}
