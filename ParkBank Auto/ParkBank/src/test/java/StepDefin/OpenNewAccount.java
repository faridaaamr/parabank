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
import static Locators.Locators.*;
import static Hooks.Hooks.*;

public class OpenNewAccount {
    @Then("user navigate open new account")
    public void userNavigateOpenNewAccount() throws IOException {
        findElement(OpeenNewAccount).click();

    }

    @And("the user choose the type of account")
    public void choseTheTypeOfAccountWouldOpen() {
        findElement(Saving).click();

    }
    @And("I click on open new account button")
    public void IClickOnOpenNewAccountButton() {
        findElement(ClickNewAccountBtn).click();
    }

//    @Then("the successful Message send")
//    public void theSuccessfulMessageSend() throws IOException, InterruptedException {
//        test = extent.createTest("Open new Account", "Customer opens a new account");
//        Thread.sleep(2000);
//        boolean AccountMassage = findElement(AccountOpenMassage).getText().equals("Account Opened!");
//        if (AccountMassage) {
//            test.log(Status.PASS, "Congratulations, your account is now open will displayed");
//            takeScreenShotPass();
//        } else {
//            test.log(Status.FAIL, "Congratulations, your account is now open will not displayed");
//            takeScreenShotFail();
//        }
//
//        Assert.assertEquals("Account Opened!", findElement(AccountOpenMassage).getText());
//    }


}