package StepDefin;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static Data.ScreenShots.takeScreenShotFail;
import static Data.ScreenShots.takeScreenShotPass;
import static Hooks.Hooks.extent;
import static Hooks.Hooks.test;
import static Locators.Locators.*;

public class RequestLoan {
//User Request loan with valid data

    @Given("User Navigate to the Request Loan page")
    public void User_Navigate_to_the_Request_Loan_page() {
        findElement(RequestLoan).click();
    }
    @When("User Request loan amount")
    public void User_Request_loan_amount()  {
        findElement(LoanAmount).sendKeys("320");
        findElement(DownPayment).sendKeys("30");
        findElement(fromAccount).click();
    }


    @Then("User Submit the loan request")
    public void User_Submit_the_loan_request() {
        findElement(LoanButton).click();
    }

    @And("User Enter the loan amount and down payment and select the account with insufficient funds")
    public void userEnterTheLoanAmountAndDownPaymentAndSelectTheAccountWithInsufficientFunds() {
        findElement(LoanAmount).sendKeys("5000");
        findElement(DownPayment).sendKeys("500");
        findElement(fromAccount).click();
    }
}
