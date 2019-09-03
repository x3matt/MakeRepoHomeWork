import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import java.util.concurrent.TimeUnit;

public class CreatePage extends PageObject {
    @FindBy(css = "#new_repository > div.js-with-permission-fields > button")
    WebElement createRepoButton;
    @FindBy(css = "#js-repo-pjax-container > div.pagehead.repohead.instapaper_ignore.readability-menu.experiment-repo-nav > div > h1 > span.author > a")
    WebElement repoName;
    @FindBy(css = "#js-repo-pjax-container > div.pagehead.repohead.instapaper_ignore.readability-menu.experiment-repo-nav > div > h1 > strong > a")
    WebElement name;
    public CreatePage(WebDriver driver){
        super(driver);
    }
    public boolean createBtnEnabled(){
        return createRepoButton.isEnabled();
    }
    public void create() throws Exception{
        TimeUnit.SECONDS.sleep(1);
        createRepoButton.click();
    }
    public String getUserLabel(){
        return repoName.getText();
    }
    public String getResponsable(){
        return name.getText();
    }

}
