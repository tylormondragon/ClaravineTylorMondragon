package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SauceDemoProductsPage extends BasePage {
    private List<WebElement> products;
    private WebElement productsPageTitle;
    public SauceDemoProductsPage(BasePage handedOffPage) {
        super(handedOffPage);

        By allProducts = By.cssSelector("div[class='inventory_item_name']");
        products = findElements(allProducts);

        By productsTitle = By.cssSelector("span[class='title']");
        productsPageTitle = findElement(productsTitle);
    }

    public String getFirstProductName() {
        return products.get(0).getText();
    }

    public SauceDemoProductDetailsPage selectFirstProduct() {
        products.get(0).click();
        return new SauceDemoProductDetailsPage(this);
    }
}
