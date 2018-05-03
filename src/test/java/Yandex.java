
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class Yandex {
    private WebDriver driver;

    @BeforeMethod
    public void start(){
        driver = new ChromeDriver();
    }

    @AfterMethod
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
    }

    @Test
    public void TestDyson() throws InterruptedException {
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