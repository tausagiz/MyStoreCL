package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressButton;
    @FindBy(xpath = "//span[text()='PrestaShop']")
    private WebElement deliveryPrestaShopInput;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmShippingButton;
    @FindBy(id = "payment-option-1")
    private WebElement payByCheckInput;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeTermsCheckbox;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]//button")
    private WebElement orderWithObligationToPayButton;

    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContinueToConfirmAddress() {
        this.confirmAddressButton.click();
    }

    public void clickOnPrestaShopPickUp() {
        this.deliveryPrestaShopInput.click();
    }

    public void clickContinueToConfirmShipping() {
        this.confirmShippingButton.click();
    }

    public void clickPayByCheck() {
        this.payByCheckInput.click();
    }

    public void clickAgreeTermsCheckbox() {
        this.agreeTermsCheckbox.click();
    }

    public void clickOrderWithAnObligationToPayButton() {
        this.orderWithObligationToPayButton.click();
    }
}
