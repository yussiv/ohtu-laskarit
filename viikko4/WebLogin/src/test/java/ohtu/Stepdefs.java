package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Stepdefs {
    WebDriver driver;
    String baseUrl = "http://localhost:4567";
    
    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }
    
    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();          
    } 

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }
    
    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }
    
    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }
    
    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }
    
    @When("^incorrect username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void incorrect_username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user in not logged in and an error message is shown$")
    public void user_in_not_logged_in_and_an_error_message_is_shown() throws Throwable {
        pageHasContent("invalid username or password");
    }

    @When("^incorrect username \"([^\"]*)\" and correct password \"([^\"]*)\" are given$")
    public void incorrect_username_and_correct_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    
    @Given("^new user is selected$")
    public void new_user_is_selected() throws Throwable {
        driver.get(baseUrl);
        driver.findElement(By.linkText("register new user")).click();    
    }

    @When("^a valid unused username \"([^\"]*)\" and valid password \"([^\"]*)\" are given$")
    public void a_valid_unused_username_and_valid_password_are_given(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @Then("^the user is added and a welcome message is shown$")
    public void the_user_is_added_and_a_welcome_message_is_shown() throws Throwable {
        pageHasContent("Welcome to Ohtu Application");
    }

    @When("^a too short username \"([^\"]*)\" and valid password \"([^\"]*)\" are given$")
    public void a_too_short_username_and_valid_password_are_given(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @Then("^user is not created and error \"([^\"]*)\" is reported$")
    public void user_is_not_created_and_error_is_reported(String message) throws Throwable {
        pageHasContent(message);
    }

    @When("^a valid unused username \"([^\"]*)\" and a too short password \"([^\"]*)\" are given$")
    public void a_valid_unused_username_and_a_too_short_password_are_given(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @When("^a valid unused username \"([^\"]*)\" and a long enough password without a special character or number \"([^\"]*)\" are given$")
    public void a_valid_unused_username_and_a_long_enough_password_without_a_special_character_or_number_are_given(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @When("^a used correct username \"([^\"]*)\" and valid password \"([^\"]*)\" are given$")
    public void a_used_correct_username_and_valid_password_are_given(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @When("^a valid username \"([^\"]*)\" and a valid password \"([^\"]*)\" and a different confirmation \"([^\"]*)\" are given$")
    public void a_valid_username_and_a_valid_password_and_a_different_confirmation_are_given(String username, String password, String confirmation) throws Throwable {
        registerWith(username, password, confirmation);
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
    
    private void registerWith(String username, String password, String confirmation) {
        pageHasContent("Create username and give password");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("passwordConfirmation")).sendKeys(confirmation);
        driver.findElement(By.name("signup")).click();  
    } 
}
