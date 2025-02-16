package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Locators
    private final By signUpButton= By.xpath("//button[normalize-space()='Sign up']");
    private final By loginButton = By.xpath("//button[@data-testid='login-button']");
    private final By myAccountButton=By.cssSelector("button[aria-label='Paula']");
    private final By logoutButton=By.cssSelector("button[data-testid='user-widget-dropdown-logout']");
    private final By searchTextBox=By.cssSelector("input[placeholder='What do you want to play?']");
    private final By createNewPlayListButton=By.xpath("//div[@class=\"wv308QWnPnkI8n0GdqYO\"]/button[@data-encore-id=\"buttonPrimary\"]");

    //Actions
    public RegisterPage goToSignUp(){
        clickElement(signUpButton);
        return new RegisterPage(driver);
    }
    public LoginPage goToLogin(){
        clickElement(loginButton);
        return new LoginPage(driver);
    }
    public HomePage openAccountMenu(){
        clickElement(myAccountButton);
        return this;
    }
    public HomePage logout(){
        clickElement(logoutButton);
        return this;
    }
    public HomePage searchFor(){
        sendKeysToElement(searchTextBox,"Wegz");
        return this;
    }
    public MyNewPlayListPage clickOnAddNewPlayList(){
       toggleLibraryAndClickCreatePlaylist();
        return new MyNewPlayListPage(driver);
    }

  public void toggleLibraryAndClickCreatePlaylist(){

      try {
          Thread.sleep(1000);

          WebElement libraryButton = driver.findElement(By.xpath("//button[contains(@aria-label, 'Your Library')]"));

          String ariaLabel = libraryButton.getAttribute("aria-label");

          if (ariaLabel.contains("Collapse Your Library")) {
              Thread.sleep(1000);
              clickElement(createNewPlayListButton);
          }
          else {
              libraryButton.click();
              Thread.sleep(1000);
              clickElement(createNewPlayListButton);
          }

      } catch (Exception e) {
          e.printStackTrace();
      }
  }

}
