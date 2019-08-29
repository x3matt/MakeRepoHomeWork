import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;


public class LoginPage extends PageObject{

    @FindBy(id = "login_field")
    WebElement login;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(css = "#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block")
    WebElement button;
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public MainPage login(String user,String pass){
        login.sendKeys(user);
        password.sendKeys(pass);
        button.click();
        return new MainPage(driver);
    }
}
