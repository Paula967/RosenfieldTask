package PageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RegisterPage extends BasePage{

    Faker faker=new Faker();
    //Constructor
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By userNameText=By.cssSelector("#username");
    private final By nextButton=By.cssSelector("button[data-testid=\"submit\"]");
    private final By passwordText=By.cssSelector("#new-password");
    private final By nameText=By.cssSelector("#displayName");
    private final By dayOfBirthText=By.cssSelector("#day");
    private final By monthOfBirthDropDown=By.cssSelector("#month");
    private final By yearOfBirthText= By.cssSelector("#year");
    private final By maleGenderRadioButton=By.cssSelector("label[for='gender_option_male'] span[class='Indicator-sc-hjfusp-0 jRuGOG']");
    private final By closeButton=By.cssSelector("div [id=\"onetrust-close-btn-container\"] button[aria-label=\"Close\"]");

    private static final String DEFAULT_PASSWORD = "PaulaFarid#78@nnnea";
    private static final String DEFAULT_NAME = "Paula";
    private static final String DEFAULT_BIRTH_MONTH = "January";
    private static final String DEFAULT_BIRTH_DAY = "09";
    private static final String DEFAULT_BIRTH_YEAR = "2000";

    //Actions
    public String enterUserName(){
        String userName=faker.internet().emailAddress();
        sendKeysToElement(userNameText,userName);
        clickElement(closeButton);
        return userName;
    }
    public RegisterPage clickNext(){
        //waitForElementVisibility(nextButton);
        waitForElementClickable(nextButton);
        return this;
    }
    public String enterPassword(){
        sendKeysToElement(passwordText,DEFAULT_PASSWORD);
        return DEFAULT_PASSWORD;
    }
    public RegisterPage enterBirthAndGenderData(){
        sendKeysToElement(nameText,DEFAULT_NAME);
        sendKeysToElement(dayOfBirthText,DEFAULT_BIRTH_DAY);
        chooseFromDropDownListWithVisibleText(monthOfBirthDropDown,DEFAULT_BIRTH_MONTH);
        sendKeysToElement(yearOfBirthText,DEFAULT_BIRTH_YEAR);
        clickElement(maleGenderRadioButton);
        clickNext();
        return this;
    }
    public HomePage clickSignUp(){
        clickNext();
        return new HomePage(driver);
    }
    public RegisterPage storeCredentials(String Email, String Password) {
        Properties properties = new Properties();
        try (FileOutputStream out = new FileOutputStream("src/test/resources/config.properities")) {

            properties.setProperty("dynamicEmail", Email);
            properties.setProperty("dynamicPassword", Password);

            properties.store(out, "Updated dynamic email and password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }
}
