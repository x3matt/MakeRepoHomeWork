import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class MainPage extends PageObject {
    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[3]/div[3]/div[1]/form/div[2]/a")
    WebElement createRepoButton;
    @FindBy(id = "repository_name")
    WebElement repoName;
    @FindBy(id = "repository_description")
    WebElement description;
    public MainPage(WebDriver driver){
        super(driver);
    }
    public CreatePage createRepo(String name,String descr){
        driver.get("https://github.com/x3matt?tab=repositories");
        createRepoButton.click();
        repoName.sendKeys(name);
        description.sendKeys(descr);
        return new CreatePage(driver);
    }

}
