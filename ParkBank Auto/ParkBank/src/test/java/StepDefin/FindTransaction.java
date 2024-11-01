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
import static Locators.Locators.TransactionSuccessMassage;

public class FindTransaction {

    public static String id;
    public static String date;

    @And("User select the account to get the transaction Id")
    public void UserSelectTheAccountToGetTheTransactionId() {
        findElement(Account).click();
        findElement(Transaction).click();
        id = findElement(TransactionId).getText();
        System.out.println(id);
    }

    @And("User navigate to find transaction page")
    public void UserNavigateToFindTransactionPage() {
        findElement(Find_transactions).click();

    }

    @And("User fill the transaction Id")
    public void UserFillTheTransactionId() {
        findElement(TransactionIdField).sendKeys(id);

    }

    @And("User click on search id button")
    public void UserClickOnSearchIdButton() throws InterruptedException, IOException {
        findElement(SearchButtonById).click();
        Thread.sleep(2000);

    }


    @And("User should see the transaction details")
    public void UserShouldSeeTheTransactionDetails() throws InterruptedException, IOException {
        test = extent.createTest("Find transaction by id", "Customer Customer find transaction by id");
        Thread.sleep(2000);
        takeScreenShotFail();

    }



    @When("User select the account to get the transaction date")
    public void UserSelectTheAccountToGetTheTransactionDate() {
        findElement(AccountOverview).click();
        findElement(Account).click();
        findElement(Transaction).click();
        date = findElement(TransactionDate).getText();
        System.out.println(date);

    }
    @And("User fill the transaction date")
    public void UserFillTheTransactionDate() throws InterruptedException {
        findElement(TransactionDatedField).sendKeys(date);
        Thread.sleep(2000);

    }

    @And("User click on search date button")
    public void UserClickOnSearchDateButton() {

        findElement(SearchButtonByDate).click();
    }

    @Then("User should see the transaction details of this date")
    public void UserShouldSeeTheTransactionDetailsOfThisDate() throws InterruptedException, IOException {
        test = extent.createTest("Find Transaction by date", "Customer see the transaction details of this date");
        Thread.sleep(2000);
        boolean TransactionMassage = findElement(TransactionSuccessMassage).getText().equals("Transaction Results");

        if (TransactionMassage) {
            test.log(Status.PASS, "Transaction Results successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "Transaction Results will not be displayed");
            takeScreenShotFail();

        }
        Assert.assertEquals("Transaction Results", findElement(TransactionSuccessMassage).getText());


    }

    @And("User fill the transaction Date Range")
    public void UserFillTheTransactionDateRange() {
        findElement(FromDate).sendKeys("01-01-2020");
        findElement(ToDate).sendKeys(date);
    }

    @And("User click on search Date Range button")
    public void UserClickOnSearchDateRangeButton() {
        findElement(SearchButtonByDateRange).click();
    }

    @Then("User should see the transaction details of this Date Range")
    public void UserShouldSeeTheTransactionDetailsOfThisDateRange() throws InterruptedException, IOException {
        test = extent.createTest("Find Transaction by Date Range", "Customer see the transaction details of this Date Range");
        Thread.sleep(2000);
        boolean TransactionMassage = findElement(TransactionSuccessMassage).getText().equals("Transaction Results");

        if (TransactionMassage) {
            test.log(Status.PASS, "Transaction Results successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "Transaction Results will not be displayed");
            takeScreenShotFail();

        }
        Assert.assertEquals("Transaction Results", findElement(TransactionSuccessMassage).getText());


    }

    @And("User fill the transaction Amount")
    public void UserFillTheTransactionAmount() {
        findElement(TransactionAmount).sendKeys("200");
    }

    @And("User click on search Amount button")
    public void UserClickOnSearchAmountButton() {
        findElement(SearchButtonByAmount).click();
    }

    @Then("User should see the transaction details of this Amount")
    public void UserShouldSeeTheTransactionDetailsOfThisAmount() throws InterruptedException, IOException {
        test = extent.createTest("Find Transaction by Amount", "Customer see the transaction details of this Amount");
        Thread.sleep(2000);
        boolean TransactionMassage = findElement(TransactionSuccessMassage).getText().equals("Transaction Results");

        if (TransactionMassage) {
            test.log(Status.PASS, "Transaction Results successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "Transaction Results will not be displayed");
            takeScreenShotFail();

        }
        Assert.assertEquals("Transaction Results", findElement(TransactionSuccessMassage).getText());


        test.log(Status.PASS,"All Find Transaction Working Successfully");
    }


}

