package pages;

import base.BaseManagement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rcadmin on 17/03/2018.
 */
public class LoginPage extends BaseManagement{

    public WebDriver webDriver;

    public LoginPage(WebDriver webDriver){

        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;

    }

    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement userNameInputBox;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(how = How.XPATH, using = "//input[@value='登录']")
    public WebElement loginBtn;


    public void enterUserName(String userName){
        userNameInputBox.sendKeys(userName);
    }

    public void enterPassword(String password){
        passwordInputBox.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String getAlertText(){

        return webDriver.switchTo().alert().getText().toString();
    }

}
