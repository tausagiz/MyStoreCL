package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourAddressesPage {
    @FindBy(css = "#content > div.addresses-footer > a")
    private WebElement createNewAddressLink;
    @FindBy(css = "div.address-body > address")
    List<WebElement> allAddresses;

    public YourAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCreateNewAddressLink() {
        this.createNewAddressLink.click();
    }

    public String getAllAddressesAsText() {
        StringBuilder allAddresses = new StringBuilder();
        for (WebElement address : this.allAddresses) allAddresses.append(address.getText());
        String allAddressesAsText = allAddresses.toString();
        allAddressesAsText = allAddressesAsText.replace(System.getProperty("line.separator"), "");
        allAddressesAsText = allAddressesAsText.replace("\n", "");
        return allAddressesAsText;
    }
}
