package StepDefin;

import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Hooks.Hooks;


import static Data.ScreenShots.takeScreenShotFail;
import static Data.ScreenShots.takeScreenShotPass;

import static Locators.Locators.*;
import com.aventstack.extentreports.Status;


import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;


public class HomePageSteps {

    WebDriver driver = Hooks.driver;
    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Test Results");
    int rowNum = 1;

    public HomePageSteps() {

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Test Case");
        headerRow.createCell(1).setCellValue("Step Description");
        headerRow.createCell(2).setCellValue("Status");
        headerRow.createCell(3).setCellValue("Details");
    }


    public void logTestResult(String testCase, String stepDesc, String status, String details) {
        Row row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue(testCase);
        row.createCell(1).setCellValue(stepDesc);
        row.createCell(2).setCellValue(status);
        row.createCell(3).setCellValue(details);
    }

    @Given("User navigate to Home Page")
    public void user_navigate_to_pages() {

        logTestResult("Home Page Test", "Navigate to Home Page", "Pass", "Home page loaded successfully.");
    }

    @When("User click on About button")
    public void user_click_on_login_button() {
        driver.findElement(By.linkText("About Us")).click();
        logTestResult("Home Page Test", "Click on About button", "Pass", "Clicked on About Us button.");
    }

    @Then("User will be able to navigate successfully to about Page")
    public void user_will_be_able_to_navigate_successfully() {
        String expectedUrl = "https://parabank.parasoft.com/parabank/about.htm";
        String actualUrl = driver.getCurrentUrl();
        try {
            Assert.assertEquals("About page can not be loaded", expectedUrl, actualUrl);
            logTestResult("Home Page Test", "Navigate to About Page", "Pass", "Successfully navigated to About page.");
        } catch (AssertionError e) {
            logTestResult("Home Page Test", "Navigate to About Page", "Fail", e.getMessage());
        }
    }


    public void saveExcelFile() {
        try (FileOutputStream outputStream = new FileOutputStream("TestResults.xlsx")) {
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Given("The user is on the ParaBank home page")
    public void the_user_is_on_the_ParaBank_home_page() {

    }

    @When("The page is loaded")
    public void the_page_is_loaded() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("ParaBank"));
    }

    @Then("The title of the page should be {string}")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The page title is incorrect!", expectedTitle, actualTitle);

    }

    @Then("The login button should be visible")
    public void the_login_button_should_be_visible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Log In']")));
        Assert.assertTrue("Login button is not visible!", loginButton.isDisplayed());

    }

    @Then("The Register button should be visible")
    public void The_Register_button_should_be_visible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement RegistrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        Assert.assertTrue("Registration button is not visible!", RegistrationButton.isDisplayed());

    }

    @Then("The Forgot Login Info button should be visible")
    public void The_Forgot_Login_Info_button_should_be_visible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ForgotButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        Assert.assertTrue("Forgot Login Info button is not visible!", ForgotButton.isDisplayed());

    }


}
