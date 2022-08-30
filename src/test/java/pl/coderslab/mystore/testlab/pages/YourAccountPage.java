package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    @FindBy(id = "addresses-link")
    private WebElement addressesTile;

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddressesTile() {
        addressesTile.click();
    }
}
