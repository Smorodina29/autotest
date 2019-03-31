import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class StartPage {
    @FindBy(xpath = "//div/div[2]/div/form/button")
    @CacheLookup
    WebElement getStartedForFreeButton;

    @FindBy(xpath = "//label/input")
    @CacheLookup
    WebElement email;

    @FindBy(xpath = "//label[2]/button")
    @CacheLookup
    WebElement createAccountButton;

    public void getStartedForFree(){
        getStartedForFreeButton.click();
    }

    public String generateRandomEmail(){
        RandomString gen = new RandomString(8);
        return gen.nextString()+"+wpt@wriketask.qaa";
    }

    public void setEmailAddressToForm(){
        email.sendKeys(generateRandomEmail());
    }

    public void clickToCreateMyAccount(){
        createAccountButton.click();
    }
}
