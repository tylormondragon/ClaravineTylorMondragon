package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoShoppingCartPage extends BasePage {
    private WebElement checkoutButton;
    public SauceDemoShoppingCartPage(BasePage handedOffPage) {
        super(handedOffPage);

        By checkoutBtn = By.cssSelector("button[name='checkout']");
        checkoutButton = findElement(checkoutBtn);
    }

    public SauceDemoCheckoutInformationPage clickCheckout() {
        checkoutButton.click();
        return new SauceDemoCheckoutInformationPage(this);
    }
}
