package pl.coderslab.mystore.testlab.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.coderslab.mystore.testlab.helper.BaseFunctions;

public class ProductPage {
    @FindBy(id = "group_1")
    private WebElement sizeListInput;
    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;
    @FindBy(className = "add-to-cart")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void chooseSizeFromList(String size) {
        Select sizeList = new Select(sizeListInput);
        sizeList.selectByVisibleText(size);
    }

    public void setQuantity(String quantity) {
        int quantityNumber = 0;
        try {
            quantityNumber = Integer.parseInt(quantity);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        for (int i = 1; i < quantityNumber; i++) {
            quantityInput.click();
            BaseFunctions.waitFor(1);
            quantityInput.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
