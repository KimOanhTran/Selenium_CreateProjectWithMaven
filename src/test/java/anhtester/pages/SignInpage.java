package anhtester.pages;

import anhtester.base.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInpage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    public WebDriverWait wait;

    @FindBy(xpath = "//h2[contains(text(),'Sign in')]")
    private WebElement headerPageText;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    private WebElement signinBtn;

    @FindBy(id = "signInError")
    private WebElement errorMsgText;

    @FindBy(id = "Pin")
    private WebElement pinInput;

    @FindBy(id = "RequestPinForm_SubmitButton")
    private WebElement submitBtn;

    @FindBy(id = "RequestPinForm_Back")
    private WebElement backBtn;

    @FindBy(id = "RequestPinForm_ResetPin")
    private WebElement resetPintBtn;

    public SignInpage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);

    }

    public void signin(String username, String password) throws Exception{
        validateHelper.waitForPageLoaded();
        validateHelper.setText(emailInput,username);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(signinBtn);
        Thread.sleep(1000);
    }
}
