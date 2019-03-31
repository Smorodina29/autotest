import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class ResendPage {
    @FindBy(xpath = "//label/button")
    @CacheLookup
    WebElement veryInterestedButton;

    @FindBy(xpath = "//label[2]/button")
    @CacheLookup
    WebElement justLookingButton;

    @FindBy(xpath = "//div[2]/label/button")
    @CacheLookup
    WebElement a_button;

    @FindBy(xpath = "//div[2]/label[2]/button")
    @CacheLookup
    WebElement b_button;

    @FindBy(xpath = "//label[3]/button")
    @CacheLookup
    WebElement c_button;

    @FindBy(xpath = "//label[4]/button")
    @CacheLookup
    WebElement d_button;

    @FindBy(xpath = "//label[5]/button")
    @CacheLookup
    WebElement e_button;

    @FindBy(xpath = "//div[3]/label/button")
    @CacheLookup
    WebElement yes_button;

    @FindBy(xpath = "//div[3]/label[2]/button")
    @CacheLookup
    WebElement no_button;

    @FindBy(xpath = "//div[3]/label[3]/button")
    @CacheLookup
    WebElement otherButton;

    @FindBy(xpath = "//span/input")
    @CacheLookup
    WebElement otherCaause;

    @FindBy(xpath = "//div[2]/div/div[2]/div/form/button")
    @CacheLookup
    WebElement submitButton;

    @FindBy(css = ".survey-success")
    @CacheLookup
    WebElement survey_success;

    @FindBy(xpath = "//div[2]/div/div/p[3]/button")
    @CacheLookup
    WebElement resendMail;

    @FindBy(css = ".wg-footer__social-item:nth-child(1) a")
    @CacheLookup
    WebElement twitter;

    @FindBy(css = ".wg-footer__social-item:nth-child(1) use")
    @CacheLookup
    WebElement twitterImg;

    public void clickRandomInterest() {
        boolean flag = Math.random() < 0.5;
        if (flag) {
            veryInterestedButton.click();
        } else {
            justLookingButton.click();
        }
    }

    public void clickRandomTotalTeamMembers() {
        int randomNumberInRange = getRandomNumberInRange(1, 5);
        switch (randomNumberInRange) {
            case (1):
                a_button.click();
                break;

            case (2):
                b_button.click();
                break;

            case (3):
                c_button.click();
                break;

            case (4):
                d_button.click();
                break;

            default:
                e_button.click();
                break;
        }
    }

    public void clickRandomTeamFollow() {
        int randomNumberInRange = getRandomNumberInRange(1, 3);
        switch (randomNumberInRange) {
            case (1):
                yes_button.click();
                break;

            case (2):
                no_button.click();
                break;

            default:
                otherButton.click();
                otherCaause.sendKeys("because");
                break;
        }
    }

    public void clickSubmit() {
        submitButton.click();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public boolean checkCss() {
        return "block".equals(survey_success.getCssValue("display"));
    }

    public void resendEmail() {
        resendMail.click();
    }

    public boolean checkResend() {
        return "inline-block".equals(resendMail.getCssValue("display"));
    }

    public boolean checkIcon(){
        return "/content/themes/wrike/dist/img/sprite/vector/footer-icons.symbol.svg?v2#twitter".equals(twitterImg.getAttribute("xlink:href"));
    }

    public boolean checkAddress(){
        return "https://twitter.com/wrike".equals(twitter.getAttribute("href"));
    }
}
