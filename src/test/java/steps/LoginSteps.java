package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver webDriver = null;

    @Given("^I open login page$")
    public void iOpenLoginPage() throws Throwable {
        System.setProperty("webdriver.chrome.driver","tools/chrome/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://localhost:8080/login.html");
    }

    @When("^I enter correct \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterValidCredentail(String userName, String password) throws Throwable {
        webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }


    @When("^I click login$")
    public void iClickLoginBtn() throws Throwable{
        webDriver.findElement(By.xpath("//input[@value='登录']")).click();
    }

    @Then("^I go to home page$")
    public void iGoToHomePage() throws Throwable{
        webDriver.navigate().to("http://localhost:8080/index.html");
        String actualTxt = webDriver.findElement(By.xpath("//div[@name='succeed']")).getText();
        String expectedTxt = "登录成功";
        Assert.assertEquals("校验是否登录成功", actualTxt, expectedTxt);
        webDriver.quit();
    }


    @When("^I enter incorrect \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterIncorrectAnd(String userName, String password) throws Throwable {
        webDriver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    @Then("^I see \"([^\"]*)\"$")
    public void iSee(String errorMessage) throws Throwable {
        String actualAlertTxt = webDriver.switchTo().alert().getText().toString();
        Assert.assertEquals("错误信息校验", actualAlertTxt, errorMessage);
        webDriver.quit();
    }
}
