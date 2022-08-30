package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    @FindBy(name = "alias")
    private WebElement aliasInput;
    @FindBy(name = "address1")
    private WebElement addressInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "postcode")
    private WebElement postcodeInput;
    @FindBy(name = "id_country")
    private WebElement countryInput;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(css = "#content > div > div > form > footer > button")
    private WebElement submitButton;


    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillAliasInput(String alias) {
        this.aliasInput.sendKeys(alias);
    }

    public void fillAddressInput(String address) {
        this.addressInput.sendKeys(address);
    }

    public void fillCityInput(String city) {
        this.cityInput.sendKeys(city);
    }

    public void fillPostcodeInput(String postcode) {
        this.postcodeInput.sendKeys(postcode);
    }

    public void setCountry(String country) {
        Select countryList = new Select(countryInput);
        countryList.selectByVisibleText(country);
    }

    public void fillPhoneInput(String phone) {
        this.phoneInput.sendKeys(phone);
    }

    public void clickOnSubmitButton() {
        this.submitButton.click();
    }
}
