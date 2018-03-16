package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepsCH {
    WebDriver webDriver = null;

    @假如("^我打开登录页面$")
    public void iOpenLoginPage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","tools/chrome/chromedrivermac");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://localhost:8081/login.html");
    }

    @当("^我输入正确的用户名\"([^\"]*)\"和密码\"([^\"]*)\"$")
    public void iEnterValidCredentail(String userName, String password) throws Throwable {
        webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @当("^我点击登录$")
    public void iClickLoginBtn() throws Throwable {
        webDriver.findElement(By.xpath("//input[@value='登录']")).click();
    }
    @那么("^我跳转到首页$")
    public void iLoginToHomePage() throws Throwable {
        webDriver.navigate().to("http://localhost:8081/index.html");
        String actualTxt = webDriver.findElement(By.xpath("//div[@name='succeed']")).getText();
        String expectedTxt = "登录成功";
        Assert.assertEquals("校验是否登录成功", actualTxt, expectedTxt);
        webDriver.quit();
    }

    @当("^我输入错误的用户名\"([^\"]*)\"和密码\"([^\"]*)\"$")
    public void iEnterIncorrectAnd(String userName, String password) throws Throwable {
        webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @那么("^显示错误\"([^\"]*)\"$")
    public void iSee(String errorMessage) throws Throwable {
        String actualAlertTxt = webDriver.switchTo().alert().getText().toString();
        Assert.assertEquals("错误信息校验", actualAlertTxt, errorMessage);
        webDriver.quit();
    }
}
