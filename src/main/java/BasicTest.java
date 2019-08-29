import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.FunctionalTest;
import java.util.List;

import static junit.framework.TestCase.*;

public class BasicTest extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    CreatePage createPage;
    RepoListPage repoListPage = new RepoListPage(driver);
    DeletePage deletePage = new DeletePage(driver);

    String user = "your Email";
    String password = "Your Password";
    String baseUrl = "https://www.github.com/login";
    String repoListURL = "https://github.com/x3matt?tab=repositories";
    String repoName = "MyRepo";
    String userName= "Your nickName";
    String repoDescr = "Some Valid Description";

    //All tests passed

    @Before
    public void init(){
        PageFactory.initElements(driver,this);
    }
    @Test
    public void loginTest(){
        driver.get(baseUrl);
        LoginPage page = new LoginPage(driver);
        page.login("test","test");
        assertEquals("Incorrect username or password.",driver.findElement(By.cssSelector("#js-flash-container > div > div")).getText());
        page.login.clear();
        page.password.clear();
        page.login(user,password);
        assertTrue(driver.findElement(By.cssSelector("body > div.position-relative.js-header-wrapper > header > div.Header-item.position-relative.mr-0.d-none.d-lg-flex > details > summary > img")).isDisplayed());
    }
    @Test
    public void createRepo(){

       driver.get(baseUrl);
       mainPage = loginPage.login(user,password);

       createPage = mainPage.createRepo(repoName,repoDescr);
       assertTrue(createPage.createBtnEnabled());

       createPage.create();

        assertEquals(createPage.getResponsable(), repoName);
        assertEquals(createPage.getUserLabel(), userName);

       driver.get(repoListURL);

       driver.get("https://github.com/"+userName+"/"+repoName);
        deletePage.delete();
        assertTrue(deletePage.buttonIsEnabled());
        deletePage.pressDeleteButton();
    }
}
