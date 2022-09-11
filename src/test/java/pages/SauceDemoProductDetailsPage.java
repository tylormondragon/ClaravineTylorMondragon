package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoProductDetailsPage extends BasePage {
    private WebElement productName;
    private WebElement addButton;
    private WebElement shoppingCart;
    public SauceDemoProductDetailsPage(BasePage handedOffPage) {
        super(handedOffPage);

        By pdtName = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
        productName = findElement(pdtName);

        By addToCart = By.cssSelector("button[class*='btn_inventory']");
        addButton = findElement(addToCart);

        By goToCart = By.cssSelector("a[class='shopping_cart_link']");
        shoppingCart = findElement(goToCart);
    }

    public String getProductName() {
        return productName.getText();
    }

    public void addProductToCart() {
        addButton.click();
    }

    public SauceDemoShoppingCartPage goToCart() {
        shoppingCart.click();
        return new SauceDemoShoppingCartPage(this);
    }
}
