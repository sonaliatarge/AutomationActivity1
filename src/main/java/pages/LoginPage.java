package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id="username")
    WebElement Username;

    @FindBy(id="password")
    WebElement Password;

    @FindBy(id="_wpnonce")
    WebElement loginbtn;


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void login(String user,String pass){
        Username.sendKeys(user);
        Password.sendKeys(pass);
        loginbtn.click();
    }

}
