import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestCase {
    private WebDriver driver;

    @Before
    public void start(){
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http://wrike.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void method() throws InterruptedException {
        StartPage startPage = new StartPage();
        PageFactory.initElements(driver, startPage);
        startPage.getStartedForFree();
        startPage.setEmailAddressToForm();
        startPage.clickToCreateMyAccount();

        ResendPage resendPage = new ResendPage();
        PageFactory.initElements(driver, resendPage);
        TimeUnit.SECONDS.sleep(3);
        Assert.assertEquals(this.driver.getTitle(), "Thank you for choosing Wrike!");

        resendPage.clickRandomInterest();
        resendPage.clickRandomTeamFollow();
        resendPage.clickRandomTotalTeamMembers();
        resendPage.clickSubmit();
        TimeUnit.SECONDS.sleep(2);
        Assert.assertEquals(resendPage.checkCss(), true);

        resendPage.resendEmail();
        Assert.assertEquals(resendPage.checkResend(), true);

        Assert.assertEquals(resendPage.checkAddress(), true);
        Assert.assertEquals(resendPage.checkIcon(), true);

    }
}
