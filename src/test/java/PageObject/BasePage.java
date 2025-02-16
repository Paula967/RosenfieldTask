package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    protected  WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }
    public void clickElement(By locator){
        findElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text){
        findElement(locator).sendKeys(text);
    }

    public void waitForElementClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickElement(locator);
    }

    public void chooseFromDropDownListWithVisibleText(By locator, String VisibleText){
        Select select=new Select(findElement(locator));
        select.selectByVisibleText(VisibleText);
    }
    public String getTextFromElement(By locator){
        return findElement(locator).getText();
    }

}
