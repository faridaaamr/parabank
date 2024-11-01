package StepDefin;


import static Data.DataPrep.getData;
import static Data.ScreenShots.takeScreenShotFail;
import static Data.ScreenShots.takeScreenShotPass;
import static Hooks.Hooks.extent;
import static Hooks.Hooks.test;
import static Locators.Locators.*;


import java.io.IOException;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BillPay {

    //User navigates to bill pay Page and define payment

    @Given("user navigates to bill pay page")
    public void user_navigates_to_bill_pay_page() {
        findElement(BillPayBut).click();

    }

    @When("user fill all bill pay page details")
    public void user_fill_all_bill_pay_page_details() throws IOException {

        findElement(PayeeName).sendKeys(getData(2, 0));
        findElement(PayeeNameAddress).sendKeys(getData(2, 2));
        findElement(PayeeNameCity).sendKeys(getData(2, 3));
        findElement(PayeeNameState).sendKeys(getData(2, 4));
        findElement(PayeeNameZipCode).sendKeys(getData(2, 5));
        findElement(PayeeNamePhoneNumber).sendKeys(getData(2, 6));
        findElement(PayeeNameAccountNumber).sendKeys("15500");
        findElement(PayeeNameVerifyAccountNumber).sendKeys("15500");
        findElement(PayeeNameAmount).sendKeys("300");

    }

    @And("user click on send payment")
    public void userClickOnSendPayment() {
        findElement(SendPayment).click();
    }

    @Then("the user redirected to confirmation page")
    public void the_user_redirected_to_confirmation_page() throws InterruptedException, IOException {
        test = extent.createTest("Bill Pay", "customer pay the bill");
        Thread.sleep(2000);
        String x = findElement(BillPaySuccessMassage).getText();
        System.out.println(x);

        boolean BillPaySuccessMessage = findElement(BillPaySuccessMassage).getText().equals("Bill Payment Complete");
        if (BillPaySuccessMessage) {
            test.log(Status.PASS, "Transfer Complete! successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "Transfer Complete! successfully will not be displayed");
            takeScreenShotFail();

        }

        test.log(Status.PASS,"Bill Payment Complete Successfully");
        Assert.assertEquals("Bill Payment Complete", findElement(BillPaySuccessMassage).getText());

    }
}
