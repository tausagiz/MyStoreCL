package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillEmailInput(String email) {
        this.emailInput.sendKeys(email);
    }

    public void fillPasswordInput(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickOnSignInButton() {
        this.signInButton.click();
    }
}
