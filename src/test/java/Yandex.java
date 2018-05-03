
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Yandex {

    @Test
    public void searchCleaner() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yandex.ru/");
        WebElement search = driver.findElement(By.name("text"));
        search.sendKeys("пылесос дайсон");
        driver.findElement(By.className("search2__button")).click();
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        driver.findElement(By.partialLinkText("dyson.com.ru")).click();

        String newWindowHandle = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        //Boolean found = driver.findElement(By.id("ctl00_content_0_InnerCarousel_SlidesRepeater_ctl00_standardSlide_StandardSlideDiv"));
    }

    @Test
    public void TestDyson() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.dyson.com.ru/");
        WebElement element = driver.findElement(By.id("ctl00_cphNavigation_topNavigation1_TopNavigationLinksRepeater_ctl02_TopNavigationLink"));
        Thread.sleep(3000);
        element.click();
        WebElement element2 = driver.findElement(By.id("ctl00_cphNavigation_topNavigation1_TopNavigationLinksRepeater_ctl02_TopNavigationDetailRepeater_ctl06_SubMenuLink"));
        Thread.sleep(3000);
        element2.click();
        Thread.sleep(3000);
        boolean isPresent = driver.findElements(By.cssSelector("a[href*=\"/accessories/hepa-filter-968125-05\"]")).size() > 0;
        Assert.assertEquals(isPresent, true);
    }

}