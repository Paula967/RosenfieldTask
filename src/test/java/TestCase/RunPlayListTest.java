package TestCase;
import PageObject.MyNewPlayListPage;
import PageObject.RegisterPage;
import TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunPlayListTest extends BaseClass {
    @Test
    public void VerifyThatPlayListRun() throws InterruptedException {
        RegisterPage registerPage = homePage
                .goToSignUp();

        String UserName=registerPage.enterUserName();
        registerPage.clickNext();
        String Password=registerPage.enterPassword();

        Thread.sleep(1000);
        homePage=registerPage.storeCredentials(UserName,Password).clickNext()
                        .enterBirthAndGenderData().clickSignUp();

        MyNewPlayListPage myNewPlayListPage =homePage
                .searchFor().openAccountMenu().logout()
                .goToLogin().enterCredentialsFromConfig()
                .login()
                .clickOnAddNewPlayList();

        //Assert on Added PlayList
        Assert.assertEquals(myNewPlayListPage.getPlayListName(),
                "My Playlist #1","PlayList Cannot Added Successfully");

        //Assert on Run PlayList
        Assert.assertTrue(myNewPlayListPage.searchForSong("البخت").selectFirstSong().clickOnPlayButton(),
                "Can not run PlayList");
    }
}
