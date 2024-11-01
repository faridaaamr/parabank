package StepDefin;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

import static Data.DataPrep.getData;
import static Data.ScreenShots.takeScreenShotFail;
import static Data.ScreenShots.takeScreenShotPass;
import static Hooks.Hooks.extent;
import static Hooks.Hooks.test;
import static Locators.Locators.*;

public class Login {

//Scenario: User login with username & password
    @Given("User fill the details For Login")
    public static void userFillTheDetailsForLogin() throws IOException {

        findElement(UsernameLogin).sendKeys("y");
        findElement(PasswordLogin).sendKeys("y");

//        findElement(UsernameLogin).sendKeys(getData(1, 8));
//        findElement(PasswordLogin).sendKeys(getData(1, 9));

    }

    @When("User click on Login button")
    public static void userClickOnLoginButton() {

        findElement(SignInButton).click();
    }

    @Then("User will be logged in successfully")
    public static void userWillBeLoggedInSuccessfully() throws IOException, InterruptedException {
        test = extent.createTest("Sign In", "user Sign In");
        Thread.sleep(2000);
        boolean welcomeMessage = findElement(SignInPage).getText().equals("Accounts Overview");
        if (welcomeMessage) {
            test.log(Status.PASS, "Sign in successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "sign in successfully will not be displayed");
            takeScreenShotFail();

        }
        Assert.assertTrue("Accounts Overview", welcomeMessage);

        test.log(Status.PASS,"User Login Successfully");

    }

//Scenario: User login with forget password

    @Given("User navigate to forget info page")
    public void User_navigate_to_forget_info_page() {
        findElement(ForgotPass).click();

    }

    @When("User fill info")
    public void User_fill_info() throws IOException {
        findElement(ForgotFirstName).sendKeys(getData(1, 0));
        findElement(ForgotLastName).sendKeys(getData(1, 1));
        findElement(ForgotAddress).sendKeys(getData(1, 2));
        findElement(ForgotCity).sendKeys(getData(1, 3));
        findElement(ForgotState).sendKeys(getData(1, 4));
        findElement(ForgotZipCode).sendKeys(getData(1, 5));
        findElement(ForgotSsn).sendKeys(getData(1, 7));

    }

    @And("User click on find info button")
    public void User_click_on_find_info_button()
    {
        findElement(FindInfoButton).click();
    }



    @Then("User will get into successfully")
    public void User_will_get_into_successfully() throws IOException, InterruptedException {

    }


}

