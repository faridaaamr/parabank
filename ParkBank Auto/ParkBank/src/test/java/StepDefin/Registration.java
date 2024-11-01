package StepDefin;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import static Data.DataPrep.getData;
import static Data.DataPrep.setData;
import static Data.ScreenShots.takeScreenShotFail;
import static Data.ScreenShots.takeScreenShotPass;
import static Locators.Locators.*; // anything on locators package will be import
import static Hooks.Hooks.*;
import static Locators.Locators.RegisterButton;

public class Registration {


    @Given("the user is on the ParaBank registration page")
    public static void the_user_is_on_the_para_bank_registration_page()  throws IOException {
        setData();
        findElement(RegisterButton).click();
        String SignUpPage = findElement(SignPage).getText();
        Assert.assertEquals(SignUpPage, "Signing up is easy!");


    }

    //Scenario: Successful registration with valid data
    @When("the user enters valid registration details")
    public static void the_user_enters_valid_registration_details() throws IOException {
        findElement(FirstName).sendKeys(getData(1, 0));
        findElement(LastName).sendKeys(getData(1, 1));
        findElement(AddressStreet).sendKeys(getData(1, 2));
        findElement(AddressCity).sendKeys(getData(1, 3));
        findElement(AddressState).sendKeys(getData(1, 4));
        findElement(AddressZipCode).sendKeys(getData(1, 5));
        findElement(PhoneNumber).sendKeys(getData(1, 6));
        findElement(SSN).sendKeys(getData(1, 7));
        findElement(Username).sendKeys(getData(1, 8));
        findElement(Password).sendKeys(getData(1, 9));
        findElement(RepeatPassword).sendKeys(getData(1, 10));

    }

    @And("submits the registration form")

    public static void submits_the_registration_form() {

        findElement(ClickSignBtn).click();
    }

    @Then("the user should see a registration success message")
    public static void the_user_should_see_a_registration_success_message() throws IOException {
        test = extent.createTest("Registration", "user register");
        boolean successMessage = findElement(Massage).getText().equals("Your account was created successfully. You are now logged in.");
        if (successMessage) {
            test.log(Status.PASS, "Register successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "Register successfully will not be displayed");
            takeScreenShotFail();

        }
        Assert.assertTrue("Your account was created successfully. You are now logged in.", successMessage);
    }


    //Scenario: Unsuccessful registration with missing required fields

    @When("the user submits the form without filling required fields")
    public void theUserSubmitsTheFormWithoutFillingRequiredFields() throws InterruptedException {
        Thread.sleep(2000);
        findElement(ClickSignBtn).click();
        
    }

    @Then("the user should see error messages for missing fields")
    public void theUserShouldSeeErrorMessagesForMissingFields() {
        boolean errorDisplayed = findElement(errorMessage).isDisplayed();
       Assert.assertTrue("Error message should be displayed for missing fields.", errorDisplayed);

       test.log(Status.PASS,"Can't register");
    }
    }
