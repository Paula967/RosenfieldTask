package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyNewPlayListPage extends BasePage{

    public MyNewPlayListPage(WebDriver driver) {
        super(driver);
    }
    //Locators
    private final By searchForNewSongInMyPlayList= By.xpath("(//input[@role=\"searchbox\"])[2]");
    private final By myPlayListName=By.xpath("//h1[normalize-space()='My Playlist #1']");
    private final By firstSongInSearchResult=By.xpath("(//button[@data-testid=\"add-to-playlist-button\"])[1]");
    private final By playButton=By.xpath("(//button[starts-with(@aria-label, 'Play')])[1]");

    public MyNewPlayListPage searchForSong(String song){
        sendKeysToElement(searchForNewSongInMyPlayList,song);
        return this;
    }
    public MyNewPlayListPage selectFirstSong(){
        clickElement(firstSongInSearchResult);
        return this;
    }
    public boolean clickOnPlayButton() throws InterruptedException {
        Thread.sleep(1000);
        clickElement(playButton);
        return findElement(playButton).isEnabled();
    }
    public String getPlayListName(){
        return getTextFromElement(myPlayListName);
    }
}
