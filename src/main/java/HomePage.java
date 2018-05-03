import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static final By aboutAs = By.cssSelector("#menu-item-636 a");

    private static final By TITLE = new By.ByTagName("title");

    public void shouldAppear(WebDriver driver) {
        WebElement title = (new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(TITLE)));
    }
}

