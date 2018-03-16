package steps;

import base.BaseManagement;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by rcadmin on 17/03/2018.
 */
public class Hooks extends BaseManagement{

    public BaseManagement base;
    public String loginURL = "http://localhost:8081/login.html";

    public Hooks(BaseManagement base){
        this.base = base;
    }


    @Before("@web")
    public void startBrowser(){

        System.setProperty("webdriver.chrome.driver","tools/chrome/chromedrivermac");
        base.webDriver = new ChromeDriver();
        base.webDriver.navigate().to(loginURL);
    }

    @After("@web")
    public void closeBrowser(){

        base.webDriver.quit();

    }
}
