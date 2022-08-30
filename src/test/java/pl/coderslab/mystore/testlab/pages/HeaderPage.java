package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    @FindBy(css = "#_desktop_user_info > div > a")
    private WebElement signInLink;
    @FindBy(id = "category-3")
    private WebElement clothesCategoryLink;

    public HeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignInLink() {
        signInLink.click();
    }

    public void clickOnClothesCategoryLink() {
        clothesCategoryLink.click();
    }
}
