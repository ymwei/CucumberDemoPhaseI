package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by rcadmin on 17/03/2018.
 */
public class HomePage {

    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@name='succeed']")
    public WebElement succeedTxt;

    public String getSucceedTxt(){
        return succeedTxt.getText().toString();
    }


}
