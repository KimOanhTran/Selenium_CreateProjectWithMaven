package anhtester.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidateHelper {
    private WebDriver driver;
    private  WebDriverWait wait;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setText(WebElement element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(value);
    }

    public void clickElement(WebElement element){

        //click vao mot phan tu cua element
        wait.until(ExpectedConditions.elementToBeClickable(element));
//        driver.findElement(element);
        element.click();
    }

    public void selectOptionByText(By element, String text){
        //Chuyen tu doi tuong By sang doi tuong WebElement thi them driver.findElement
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public void selectOptionByValue(By element, String value){
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
    }

    //Ham doi trang load xong roi thao tac
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {

                    @Override
                    public Boolean apply(WebDriver arg0) {
                        // TODO Auto-generated method stub
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
