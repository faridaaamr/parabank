package StepDefin;


import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

import static Data.ScreenShots.takeScreenShotFail;
import static Data.ScreenShots.takeScreenShotPass;
import static Hooks.Hooks.*;
import static Locators.Locators.*;

public class UpdateContactInfo {
    @Given("user navigate to update contact info")
    public void navigatingToUpdateContactInfo()  {
        findElement(UpdateContactInfoPage).click();
    }

    //User updates account information First name and Last Name successfully
    @And("the user clear the filed place and write the new First Name and Last Name")
    public void the_user_clear_the_filed_place_and_write_the_new_First_Name_and_Last_Name() throws InterruptedException {
        Thread.sleep(2000);
        findElement(CustomerFirstName).clear();
        findElement(CustomerFirstName).sendKeys("Shurooq");
        findElement(CustomerLastName).clear();
        findElement(CustomerLastName).sendKeys("Diaa");

    }

    @When("click on the update profile button")
    public void click_on_the_update_profile_button() {
        findElement(updateProfileButton).click();

    }

    @Then("contact info is updated successfully")
    public void contact_info_is_updated_successfully() throws InterruptedException, IOException {
        test = extent.createTest("Update Contact", "Customer updated contact info");
        Thread.sleep(2000);
        boolean updateMessage = findElement(successUpdate).getText().equals("Your updated address and phone number have been added to the system.");
         System.out.println(updateMessage);
        String x = findElement(successUpdate).getText();
        System.out.println(x);
        if (updateMessage) {
            test.log(Status.PASS, "Your updated address and phone number have been added to the system. successfully will be displayed");
            takeScreenShotPass();

        } else {
            test.log(Status.FAIL, "Your updated address and phone number have been added to the system. successfully will not be displayed");
            takeScreenShotFail();

        }
        test.log(Status.PASS,"Update Contact Successfully");

        Assert.assertEquals("Your updated address and phone number have been added to the system.", findElement(successUpdate).getText());

    }

    //user updates account information Address and City And State successfully
    @When("the user clear the filed place and write the new Address City State")
    public void theUserClearTheFiledPlaceAndWriteTheNewAddressCityState() throws InterruptedException {
        Thread.sleep(2000);
        findElement(CustomerAddress).clear();
        findElement(CustomerAddress).sendKeys("Sheraton");
        findElement(CustomerCity).clear();
        findElement(CustomerCity).sendKeys("Misr Elgadeda");
        findElement(CustomerState).clear();
        findElement(CustomerState).sendKeys("Cairo");

    }


    @When("the user clear the filed place and write the new ZipCode And Phone")
    public void theUserClearTheFiledPlaceAndWriteTheNewZipCodeAndPhone() throws InterruptedException {
        Thread.sleep(2000);
        findElement(CustomerZipCode).clear();
        findElement(CustomerZipCode).sendKeys("15514");
        findElement(CustomerPhone).clear();
        findElement(CustomerPhone).sendKeys("01144777836");



    }
}
