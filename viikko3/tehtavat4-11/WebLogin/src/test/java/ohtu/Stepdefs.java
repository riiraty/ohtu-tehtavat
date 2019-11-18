package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    //WebDriver driver = new FirefoxDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }   
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }    
    
    @When("nonexistent username {string} and valid password {string} are given")
    public void nonexistentUsernameAndValidPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }
    
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();
    }
    
    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordMatchingPasswordConfirmationAreEntered(String username, String password) {
        createUser(username, password, password);
    }
    
    @Then("a new user is created")
    public void aNewUserIsCreated(){
        pageHasContent("Welcome to Ohtu Application!");
    }
    
    @When("a too short username {string} and valid password {string} are entered")
    public void aTooShortUsernameAndValidPasswordAreEntered(String shortUsername, String password) {
        createUser(shortUsername, password, password);
    }
    
    @Then("user is not created and short username error {string} is reported")
    public void UserIsNotCreatedAndShortUsernameErrorIsReported(String error) {
        pageHasContent(error);   
    }
    
    @When("a valid username {string} and a too short password {string} are entered")
    public void aValidUsernameAndATooShortPasswordAreEntered(String username, String shortPassword) {
        createUser(username, shortPassword, shortPassword);
    }
    
    @Then("user is not created and short password error {string} is reported")
    public void userIsNotCreatedAndShortPasswordErrorMessageIsReported(String error) {
        pageHasContent(error);   
    }
    
    @When("a valid username {string} and valid password {string} and nonmatching confirmation {string} are entered")
    public void aValidUsernameAndValidPasswordAndNonmatchingConfirmationAreEntered(String username, String password, String confirmation) {
        createUser(username, password, confirmation);
    }
    
    @Then("user is not created and confirmation error {string} is reported")
    public void userIsNotCreatedAndConfirmationErrorIsReported(String error) {
        pageHasContent(error);
    }
    
    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
    
    private void createUser(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit(); 
    }
}
