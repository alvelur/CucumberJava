package com.prueba.step;

import com.prueba.base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class StepDefinitionClass extends BaseUtil {

    private BaseUtil baseUtil;

    public StepDefinitionClass(BaseUtil util){
        this.baseUtil = util;
    }

    @Before()
    public void setup(){
        System.setProperty("webdriver.gecko.driver","src\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    private WebDriver driver;
    @Given("I am in the login page")
    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_Para_Bank_Application() {

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        driver.findElement(By.name("username")).sendKeys("Alejandro");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("username")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_Overview_page() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/ul/li[8]/a")).isDisplayed();

        String actualuserFullName = driver.findElement(By.className("smallText")).getText().toString();
        assertTrue(actualuserFullName, actualuserFullName.contains(baseUtil.userFullName));

    }

    @When("I enter valid {string} and {string} with {string}")
    public void iEnterValidUsernameAndPassword(String username, String password, String userFullName1) {

        baseUtil.userFullName = userFullName1;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();
    }

    @When("I enter valid credentials chart")
    public void iEnterValidCredentialsChart(DataTable table) {

        List<String> loginForm = table.asList();
        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.name("username")).submit();

    }

    @After()
    public void quitBrowser(){
        driver.quit();
    }

}
