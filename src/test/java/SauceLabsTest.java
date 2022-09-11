import org.junit.jupiter.api.Test;
import pages.*;

public class SauceLabsTest extends BaseTest {
    @Test
    public void completeAnOrder() {
        //login to sauce demo with given test user and password
        SauceDemoLoginPage loginPage = (SauceDemoLoginPage) page.goTo("https://www.saucedemo.com", SauceDemoLoginPage.class);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        SauceDemoProductsPage productsPage = loginPage.login();

        //Select the first product and verify the title from the products page matches the product details page
        String firstProductName = productsPage.getFirstProductName();
        SauceDemoProductDetailsPage productDetailsPage = productsPage.selectFirstProduct();
        String firstProductNameDetails = productDetailsPage.getProductName();
        assert(firstProductName.equals(firstProductNameDetails));

        //Go to the shopping cart
        SauceDemoShoppingCartPage shoppingCart = productDetailsPage.goToCart();

        //checkout in the shopping cart and enter personal information for order
        SauceDemoCheckoutInformationPage checkout = shoppingCart.clickCheckout();
        checkout.fillOutPersonalInformation("Test", "Tester", "12345");

        SauceDemoReviewOrderPage reviewOrder = checkout.clickContinue();

        //Submit the order and verify success page
        SauceDemoSuccessPage successPage = reviewOrder.clickFinishOrder();
        assert(successPage.getSuccessTitle().isDisplayed());
        assert(successPage.getThankYou().isDisplayed());
    }
}
