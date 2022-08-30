package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogPage {
    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]//a")
    private WebElement proceedToCheckoutButton;

    public ModalDialogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
