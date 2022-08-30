package pl.coderslab.mystore.testlab.steps;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.testlab.helper.BaseFunctions;
import pl.coderslab.mystore.testlab.pages.*;

import java.io.IOException;

public class StepDefinitions {
    private ChromeDriver driver;
    private String addressToCheck;

    @Given("User is on {string} website")
    public void userIsOnWebsite(String url) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        try {
            this.driver = new ChromeDriver();
        } catch (IllegalStateException e) {
            System.out.println("chromedriver.exe is missing in drivers/ directory.");
        }
        this.driver.manage().window().maximize();
        this.driver.get(url);
    }

    @And("User is logged in with {string} as username and {string} as password")
    public void userIsLoggedInWithAsUsernameAndAsPassword(String username, String password) {
        BaseFunctions.waitFor(1);
        HeaderPage onHeaderPage = new HeaderPage(driver);
        onHeaderPage.clickOnSignInLink();
        LogInPage onLoginPage = new LogInPage(driver);
        onLoginPage.fillEmailInput(username);
        onLoginPage.fillPasswordInput(password);
        onLoginPage.clickOnSignInButton();
    }

    @When("User clicks on Addresses button")
    public void userClicksOnAddressesButton() {
        BaseFunctions.waitFor(1);
        YourAccountPage onYourAccountPage = new YourAccountPage(driver);
        onYourAccountPage.clickOnAddressesTile();
    }

    @And("User clicks on Create new address")
    public void userClicksOnCreateNewAddress() {
        BaseFunctions.waitFor(1);
        YourAddressesPage onYourAddressesPage = new YourAddressesPage(driver);
        onYourAddressesPage.clickOnCreateNewAddressLink();
    }

    @And("User fills the form with {string}, {string}, {string}, {string}, {string}, {string}")
    public void userFillsTheFormWith(String alias, String address, String city, String zip, String country, String phone) {
        BaseFunctions.waitFor(1);
        NewAddressPage onNewAddressPage = new NewAddressPage(driver);
        onNewAddressPage.fillAliasInput(alias);
        onNewAddressPage.fillAddressInput(address);
        onNewAddressPage.fillCityInput(city);
        onNewAddressPage.fillPostcodeInput(zip);
        onNewAddressPage.setCountry(country);
        onNewAddressPage.fillPhoneInput(phone);
        this.addressToCheck = address + city + zip + country + phone;
        onNewAddressPage.clickOnSubmitButton();
    }

    @Then("Address with proper data is on this User account page")
    public void addressWithProperDataIsOnThisUserAccountPage() {
        BaseFunctions.waitFor(1);
        YourAddressesPage onYourAddressesPage = new YourAddressesPage(driver);
        String allAddresses = onYourAddressesPage.getAllAddressesAsText();
        Assertions.assertThat(allAddresses).contains(this.addressToCheck);
    }

    @And("Browser is closed")
    public void browserIsClosed() {
        this.driver.quit();
    }

    @When("User clicks on Clothes category")
    public void userClicksOnClothesCategory() {
        BaseFunctions.waitFor(1);
        HeaderPage onHeaderPage = new HeaderPage(driver);
        onHeaderPage.clickOnClothesCategoryLink();
    }

    @And("User clicks on {string}")
    public void userClicksOn(String productName) {
        BaseFunctions.waitFor(1);
        ClothesCategoryPage onClothesCategoryPage = new ClothesCategoryPage(driver);
        onClothesCategoryPage.clickOnProduct(productName);
    }

    @And("User chooses {string} size")
    public void userChoosesSize(String size) {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.chooseSizeFromList(size);
    }

    @And("User chooses {string} quantity")
    public void userChoosesQuantity(String quantity) {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.setQuantity(quantity);
    }

    @And("User clicks on ADD TO CART button")
    public void userClicksOnADDTOCARTButton() {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.clickAddToCartButton();
    }

    @And("User clicks on PROCEED TO CHECKOUT button")
    public void userClicksOnPROCEEDTOCHECKOUTButton() {
        BaseFunctions.waitFor(1);
        ModalDialogPage onModalDialogPage = new ModalDialogPage(driver);
        onModalDialogPage.clickProceedToCheckoutButton();
        BaseFunctions.waitFor(1);
        ShoppingCartPage onShoppingCartPage = new ShoppingCartPage(driver);
        onShoppingCartPage.clickProceedToCheckoutButton();
    }

    @And("User confirms his address")
    public void userConfirmsHisAddress() {
        BaseFunctions.waitFor(1);
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.clickContinueToConfirmAddress();
    }

    @And("User chooses PrestaShop Pick up in-store")
    public void userChoosesPrestaShopPickUpInStore() {
        BaseFunctions.waitFor(1);
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.clickOnPrestaShopPickUp();
        onOrderPage.clickContinueToConfirmShipping();
    }

    @And("User chooses Pay by Check")
    public void userChoosesPayByCheck() {
        BaseFunctions.waitFor(1);
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.clickPayByCheck();
        onOrderPage.clickAgreeTermsCheckbox();
    }

    @And("User clicks on order with an obligation to pay")
    public void userClicksOnOrderWithAnObligationToPay() {
        OrderPage onOrderPage = new OrderPage(driver);
        onOrderPage.clickOrderWithAnObligationToPayButton();
    }

    @Then("Order is confirmed")
    public void orderIsConfirmed() {
        BaseFunctions.waitFor(1);
        ConfirmationPage onConfirmationPage = new ConfirmationPage(driver);
        Assert.isTrue(onConfirmationPage.isConfirmationBannerVisible(), "Order is not confirmed!");
    }

    @And("Screenshot of confirmation is taken")
    public void screenshotOfConfirmationIsTaken() {
        try {
            BaseFunctions.takeScreenshot(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
