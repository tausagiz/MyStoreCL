package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(css = "div.checkout.cart-detailed-actions.card-block > div > a")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
