package steps;

import base.BaseManagement;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepsCH extends BaseManagement{
    public BaseManagement base;
    public LoginPage loginPage;
    public HomePage homePage;

    public LoginStepsCH(BaseManagement base){
        this.base = base;
        loginPage = new LoginPage(base.webDriver);
        homePage = new HomePage(base.webDriver);
    }

    @当("^我输入正确的用户名\"([^\"]*)\"和密码\"([^\"]*)\"$")
    public void iEnterValidCredentail(String userName, String password) throws Throwable {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @当("^我点击登录$")
    public void iClickLoginBtn() throws Throwable {
        loginPage.clickLoginBtn();
    }

    @那么("^我跳转到首页$")
    public void iLoginToHomePage() throws Throwable {
        base.webDriver.navigate().to("http://localhost:8081/index.html");
        Assert.assertEquals("校验是否登录成功", homePage.getSucceedTxt(), "登录成功");
    }

    @当("^我输入错误的用户名\"([^\"]*)\"和密码\"([^\"]*)\"$")
    public void iEnterIncorrectAnd(String userName, String password) throws Throwable {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @那么("^显示错误\"([^\"]*)\"$")
    public void iSee(String errorMessage) throws Throwable {
        Assert.assertEquals("错误信息校验", loginPage.getAlertText(), errorMessage);
    }
}
