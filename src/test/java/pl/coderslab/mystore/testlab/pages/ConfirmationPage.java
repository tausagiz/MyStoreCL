package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    @FindBy(id = "content-hook_order_confirmation")
    private WebElement confirmationBanner;

    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isConfirmationBannerVisible() {
        return this.confirmationBanner.isDisplayed();
    }
}
