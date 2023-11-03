package anhtester.testcases;
import anhtester.pages.SignInpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest {
    private WebDriver driver;
    public SignInpage signInpage;
    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://anhtester.com");

        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 1)
    public void signIn() throws Exception{
        signInpage = new SignInpage(driver);
        signInpage.signin("admin@demo.com", "riseDemo");
    }
}
