package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage{
    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By userNameLoginText=By.cssSelector("#login-username");
    private final By passwordLoginText=By.cssSelector("#login-password");
    private final By loginButton=By.cssSelector("#login-button");

    //Actions
    public LoginPage enterCredentialsFromConfig(){

            Properties properties=new Properties();
            try {
                FileInputStream file = new FileInputStream("src/test/resources/config.properities");
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sendKeysToElement(userNameLoginText, properties.getProperty("dynamicEmail"));
            sendKeysToElement(passwordLoginText, properties.getProperty("dynamicPassword"));
            return this;
    }
    public HomePage login(){
        clickElement(loginButton);
        return new HomePage(driver);
    }

}
