import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class DeletePage extends PageObject {
    @FindBy(xpath = "//*[@id=\"js-repo-pjax-container\"]/div[1]/nav/a[5]")
    WebElement settings;
    @FindBy(css = "#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > summary")
    WebElement deleteRepoButton;
    @FindBy(css = "#options_bucket > div.Box.Box--danger > ul > li:nth-child(4) > details > details-dialog > div.Box-body.overflow- auto > form > p > input")
    WebElement deleteButton;
    public DeletePage(WebDriver driver) {
        super(driver);
    }
    public void delete(){
        settings.click();
        deleteRepoButton.click();
    }
    public void pressDeleteButton(){
        deleteRepoButton.click();
    }
    public boolean buttonIsEnabled(){
        return deleteRepoButton.isEnabled();
    }
}
