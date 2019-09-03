import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class DeletePage extends PageObject {
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/a[5]")
    WebElement settings;
    @FindBy(css = "#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > summary")
    WebElement deleteRepoButton;
    @FindBy(css = "#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > details-dialog > div.Box-body.overflow-auto > form > p > input")
    WebElement repoName;
    @FindBy(css = "#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > details-dialog > div.Box-body.overflow-auto > form > button")
    WebElement deleteButton;

    public DeletePage(WebDriver driver) {
        super(driver);
    }
    public void delete(String name){
        settings.click();
        deleteRepoButton.click();
        repoName.sendKeys(name);
    }
    public void pressDeleteButton(){
        deleteButton.click();
    }
    public boolean buttonIsEnabled(){
        return deleteButton.isEnabled();
    }
}
