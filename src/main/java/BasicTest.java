import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import utils.FunctionalTest;
import java.util.Scanner;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
public class BasicTest extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    CreatePage createPage;
    RepoListPage repoListPage = new RepoListPage(driver);

    Scanner scanner = new Scanner(System.in);
    String user = "x3matt21@mail.ru";
    String password;
    String baseUrl = "https://www.github.com/login";
    String repoListURL = "https://github.com/x3matt?tab=repositories";
    String repoName = "MyRepo";
    String userName= "x3matt";
    String repoDescr = "Some Valid Description";

    @Before
    public void init(){
        PageFactory.initElements(driver,this);
    }
    @Test
    public void createRepo(){
        password = scanner.nextLine();

       driver.get(baseUrl);
       mainPage = loginPage.login(user,password);

       createPage = mainPage.createRepo(repoName,repoDescr);
       assertTrue(createPage.createBtnEnabled());

       createPage.create();

        assertEquals(createPage.getResponsable(), repoName);
        assertEquals(createPage.getUserLabel(), userName);

       driver.get(repoListURL);

    }
}
