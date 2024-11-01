package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Hooks.Hooks.driver;

public class Locators {

    //Registration Locators

    public static By RegisterButton = By.xpath("//*[text()=\"Register\"]");
    public static By FirstName = By.id("customer.firstName");
    public static By LastName = By.id("customer.lastName");
    public static By AddressStreet = By.id("customer.address.street");
    public static By AddressCity = By.id("customer.address.city");
    public static By AddressState = By.id("customer.address.state");
    public static By AddressZipCode = By.id("customer.address.zipCode");
    public static By PhoneNumber = By.id("customer.phoneNumber");
    public static By SSN = By.id("customer.ssn");
    public static By Username = By.id("customer.username");
    public static By Password = By.id("customer.password");
    public static By RepeatPassword = By.id("repeatedPassword");
    public static By WarningMassage = By.id("customer.username.errors");
    public static By Massage = By.xpath("//*[@id=\"rightPanel\"]/p");
    public static By ClickSignBtn = By.xpath("//input[@value='Register']");
    public static By SignPage = By.xpath("//*[@class= \"title\"]");
    public static By errorMessage = By.cssSelector(".error");

    // Login locators
    public static By UsernameLogin = By.xpath("//*[@type=\"text\"]");
    public static By PasswordLogin = By.xpath("//*[@type=\"password\"]");
    public static By SignInButton = By.xpath("//*[@type=\"submit\"]");
    public static By SignInPage = By.xpath("//h1[contains(text(),\"Accounts Overview\")]");

    // open new Account locators
    public static By OpeenNewAccount = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    public static By NewAccountPage = By.xpath("//h1[contains(text(),\"Open New Account\")]");
    public static By Cheking = By.xpath("//option[@value=\"0\"]");
    public static By Saving = By.xpath("//option[@value=\"1\"]");
    public static By Accounts = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
    public static By MassageNewAcc = By.xpath("//*[@id=\"openAccountResult\"]/h1");
    public static By NewAccountId = By.xpath("//a[@id=\"newAccountId\"]");
    public static By ClickNewAccountBtn = By.xpath("//input[@class=\"button\"]");
    public static By AccountOverview = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    public static By NewAccountid = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[2]/td[1]/a");
    public static By NewAccountIdcheck = By.xpath("//td[@id=\"accountId\"]");
    public static By AccountOpenMassage = By.xpath("//*[contains(text(),\"Account Opened!\")]");




    // Transfer Funds Locators
    public static By TransferFunds = By.xpath("//*[@href=\"transfer.htm\"]");
    public static By Amount = By.xpath("//input[@id=\"amount\"]");
    public static By FromAccount = By.xpath("//*[@id=\"fromAccountId\"]/option[1]");
    public static By ToAccount = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    public static By TransferButton = By.xpath("//*[@type=\"submit\"]");
    public static By TransferSuccessMassage = By.xpath("//*[text()=\"Transfer Complete!\"]");

    //bill pay Locators
    public static By BillPayBut = By.xpath("//*[@id=\"leftPanel\"]/ul/li[4]/a");
    public static By PayeeName = By.name("payee.name");
    public static By PayeeNameAddress = By.name("payee.address.street");
    public static By PayeeNameCity = By.name("payee.address.city");
    public static By PayeeNameState = By.name("payee.address.state");
    public static By PayeeNameZipCode = By.name("payee.address.zipCode");
    public static By PayeeNamePhoneNumber = By.name("payee.phoneNumber");
    public static By PayeeNameAccountNumber = By.name("payee.accountNumber");
    public static By PayeeNameVerifyAccountNumber = By.name("verifyAccount");
    public static By PayeeNameAmount = By.name("amount");
    public static By SendPayment = By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[14]/td[2]/input");
    public static By BillPaySuccessMassage = By.xpath("//h1[contains(text(),\"Bill Payment Complete\")]");


    //Find transactions locators
    public static By TransactionId = By.xpath("//*[@id=\"rightPanel\"]/table/tbody/tr[1]/td[2]");
    public static By Account = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    public static By Transaction = By.xpath("//*[@id=\"transactionTable\"]/tbody/tr[1]/td[2]/a");
    public static By Find_transactions = By.xpath("//*[@href=\"findtrans.htm\"]");
    public static By TransactionIdField = By.id("transactionId");
    public static By SearchButtonById = By.id("findById");
    public static By TransactionDate = By.xpath("//*[@id=\"rightPanel\"]/table/tbody/tr[2]/td[2]");
    public static By TransactionDatedField = By.id("transactionDate");
    public static By SearchButtonByDate = By.id("findByDate");
    public static By TransactionSuccessMassage = By.xpath("//*[contains(text(),\"Transaction Results\")]");
    public static By FromDate = By.id("fromDate");
    public static By ToDate = By.id("toDate");
    public static By SearchButtonByDateRange = By.id("findByDateRange");
    public static By TransactionAmount = By.id("amount");
    public static By SearchButtonByAmount = By.id("findByAmount");


    //update contact info locators
    public static By UpdateContactInfoPage = By.xpath("//a[@href='updateprofile.htm']");
    public static By CustomerFirstName = By.xpath("//*[@id=\"customer.firstName\"]");
    public static By CustomerLastName =By.xpath("//*[@id=\"customer.lastName\"]");
    public static By CustomerAddress = By.xpath("//*[@id=\"customer.address.street\"]");
    public static By CustomerCity = By.xpath("//*[@id=\"customer.address.city\"]");
    public static By CustomerState =By.xpath("//*[@id=\"customer.address.state\"]");
    public static By CustomerZipCode = By.xpath("//input[@id='customer.address.zipCode']");
    public static By CustomerPhone = By.xpath("//*[@id=\"customer.phoneNumber\"]");
    public static By updateProfileButton = By.xpath("//*[@colspan=\"2\"]/input");
    public static By successUpdate = By.xpath("//div[@id=\"updateProfileResult\"]/p");

    // request Loan Loactors
    public static By RequestLoan = By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a");
    public static By LoanAmount = By.xpath("//*[@id=\"amount\"]");
    public static By DownPayment = By.xpath("//*[@id=\"downPayment\"]");
    public static By fromAccount = By.xpath("//select[@id='fromAccountId']/option[1]");
    public static By LoanButton = By.xpath("//*[@type=\"button\"]");
    public static By LoanSuccMassage = By.xpath("//*[@id=\"loanRequestApproved\"]/p[1]");


    // logout & forgot password login
    public static By LogOut = By.xpath("//*[contains(text(),\"Log Out\")]");
    public static By ForgotPass = By.xpath(" //*[contains(text(),\"Forgot login info?\")]");
    public static By ForgotFirstName = By.id("firstName");
    public static By ForgotLastName = By.id("lastName");
    public static By ForgotAddress = By.id("address.street");
    public static By ForgotCity = By.id("address.city");
    public static By ForgotState = By.id("address.state");
    public static By ForgotZipCode = By.id("address.zipCode");
    public static By ForgotSsn = By.id("ssn");
    public static By FindInfoButton = By.xpath("//*[@value=\"Find My Login Info\"]");
    public static By ForgotSuccessMassage = By.xpath("//h1[contains(text(),\"Customer Lookup\")]");

      /*
    public static By Username = By.xpath("//*[@type=\"text\"]");
    public static By Password = By.xpath("//*[@type=\"password\"]");
    public static By LoginBut = By.xpath("//*[@type=\"submit\"]");
    public static By LoginPage = By.xpath("//h1[contains(text(),\"Accounts Overview\")]");

     */


    public static WebElement findElement(By Locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
        return driver.findElement(Locator);
    }

    public static List<WebElement> findElements(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return driver.findElements(locator);
    }


}
