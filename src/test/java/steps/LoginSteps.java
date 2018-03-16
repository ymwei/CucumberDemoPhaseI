package steps;

import base.BaseManagement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps extends BaseManagement{
    public BaseManagement base;
    public LoginPage loginPage;
    public HomePage homePage;

    public LoginSteps(BaseManagement base){
        this.base = base;
        loginPage = new LoginPage(base.webDriver);
        homePage = new HomePage(base.webDriver);
    }

    @When("^I enter correct \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterValidCredentail(String userName, String password) throws Throwable {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }


    @When("^I click login$")
    public void iClickLoginBtn() throws Throwable{
        loginPage.clickLoginBtn();
    }

    @Then("^I go to home page$")
    public void iGoToHomePage() throws Throwable{
        base.webDriver.navigate().to("http://localhost:8081/index.html");
        Assert.assertEquals("校验是否登录成功", homePage.getSucceedTxt(), "登录成功");
        base.webDriver.quit();
    }


    @When("^I enter incorrect \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterIncorrectAnd(String userName, String password) throws Throwable {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @Then("^I see \"([^\"]*)\"$")
    public void iSee(String errorMessage) throws Throwable {
        Assert.assertEquals("错误信息校验", loginPage.getAlertText(), errorMessage);
    }
}
