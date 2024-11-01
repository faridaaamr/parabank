package StepDefin;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import static Hooks.Hooks.test;
import static Locators.Locators.*;

public class LogOut {

    public static WebDriver driver;


    @When("User click on LogOut button")
    public void user_click_on_log_out_button() {
        // Click on Log out button
        findElement(LogOut).click();
    }

    @Then("User will be logged Out successfully")
    public void user_will_be_logged_out_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement RegistrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        org.junit.Assert.assertTrue("Registration button is not visible!", RegistrationButton.isDisplayed());

    }


    @When("User Close the browser without logging out.")
    public void user_Close_The_Browser_Without_Logging_Out() {
        driver.close();
    }

    @And("Reopen the browser and navigate back to the ParaBank website.")
    public void reopen_The_Browser_And_Navigate_Back_To_The_ParaBank_Website() {
        driver = new ChromeDriver();

        // Navigate back to the ParaBank login page
        driver.get("https://parabank.parasoft.com/parabank/login.htm");
    }

    @Then("The user should be required to log in again")
    public void the_User_Should_Be_Required_To_Log_In_Again() {
        try {
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            By buttonLocator = By.xpath("//input[@value='Log In']");
            boolean isButtonDisplayed;
            try{
                WebElement button = driver.findElement(buttonLocator);
                isButtonDisplayed = button.isDisplayed();

            } catch (NoSuchElementException e){
                isButtonDisplayed = false;
            }
            Assert.assertTrue(isButtonDisplayed,"Button Should Be Shown.");

        }
        finally {
            driver.quit();
        }
    }
//
//    @Given("User Logged in")
//    public void User_logged_in() {
//
//        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
//        usernameField.sendKeys("Menna_Saleh");
//        driver.findElement(By.name("password")).sendKeys("M@12345");
//
//        // Click on login button
//        driver.findElement(By.xpath("//input[@value='Log In']")).click();
//
//    }
//   @When("User click on LogOut button")
//    public void User_click_on_log_out_button() {
//        // Click on Log Out button
//        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
//    }
//    @When("Reopen the browser and navigate back to the Parabank website")
//    public void reopen_the_browser_and_navigate_back_to_the_parabank_website() {
//        // Reinitialize the WebDriver
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Set the correct path
//        driver = new ChromeDriver();
//
//        // Navigate back to the Parabank login page
//        driver.get("https://parabank.parasoft.com/parabank/login.htm");  // Replace with the actual URL
//    }
//
//    @When("User Open another tab and navigate to the ParaBank website.")
//    public void userOpenAnotherTabAndNavigateToTheParaBankWebsite() {
//        // Open a new tab
//        String newTab = "window.open('https://parabank.parasoft.com/parabank/login.htm', '_blank');";
//        ((JavascriptExecutor) driver).executeScript(newTab);
//
//        // Switch to the new tab
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//    }
//
//    @And("User click on LogOut button in one of the tabs")
//    public void userClickOnLogOutButtonInOneOfTheTabs() {
//        driver.findElement(By.linkText("Log Out")).click();
//    }
//
//
//    @Then("User is logged out of all tabs")
//    public void userIsLoggedOutOfAllTabs() {
//        boolean isLoginPageDisplayed = driver.findElement(By.name("login")).isDisplayed(); // Adjust the locator as needed
//        Assert.assertTrue(isLoginPageDisplayed);
//
//        // Close all tabs and quit the browser
//        driver.quit();
//    }

    @When("Reopen the browser and navigate back to the ParaBank website")
    public void reopen_the_browser_and_navigate_back_to_the_paraBank_website() {
        // Reinitialize the WebDriver
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Set the correct path
        driver = new ChromeDriver();

        // Navigate back to the ParaBank login page
        driver.get("https://parabank.parasoft.com/parabank/login.htm");  // Replace with the actual URL
    }


    @When("User Open another tab and navigate to the ParaBank website")
    public void user_open_another_tab_and_navigate_to_the_paraBank_website() {
        // Open a new tab
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('about:blank', '_blank');");

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));  // Switch to the second tab

        // Navigate to ParaBank in the new tab
        driver.get("https://parabank.parasoft.com/parabank/login.htm"); // Replace with actual URL
    }
    @And("User click on LoggedOut button in one of the tabs")
    public void user_click_on_logged_out_button_in_one_of_the_tabs() {
        // Switch to the first tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.getFirst());  // Switch to the first tab

        // Click the LogOut button
        driver.findElement(By.linkText("Log Out")).click();  // Adjust locator as needed
    }
    @When("User In the other tab, attempt to navigate to a protected page")
    public void user_in_the_other_tab_attempt_to_navigate_to_a_protected_page() {
        // Switch to the second tab
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));  // Switch to the second tab

        // Attempt to navigate to a protected page
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");


        test.log(Status.PASS,"user Logout Successfully");
    }


}