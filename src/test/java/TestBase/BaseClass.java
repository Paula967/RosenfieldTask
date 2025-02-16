package TestBase;

import PageObject.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setup() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://open.spotify.com/");
        homePage=new HomePage(driver);
    }
   @AfterClass
    public void tearDown() {
        driver.close();
    }
}
