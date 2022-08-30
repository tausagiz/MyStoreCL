package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ClothesCategoryPage {
    @FindBy(xpath = "//*[@id=\"js-product-list\"]//a")
    List<WebElement> productLinks;

    public ClothesCategoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnProduct(String productName) {
        WebElement linkToClick = null;
        for (WebElement productLink :
                productLinks) {
            if (productLink.getText().contains(productName)) {
                linkToClick = productLink;
            }
        }
        assert null != linkToClick;
        linkToClick.click();
    }
}
