package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage extends BasePage {
    private final WebElement userName;
    private final WebElement passwordField;
    private final WebElement loginButton;

    public SauceDemoLoginPage(BasePage handedOffPage) {
        super(handedOffPage);
        By userNameField = By.cssSelector("input[id='user-name']");
        userName = findElement(userNameField);

        By password = By.cssSelector("input[id='password']");
        passwordField = findElement(password);

        By loginBtn = By.cssSelector("input[id='login-button']");
        loginButton = findElement(loginBtn);
    }

    public void enterUsername(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public SauceDemoProductsPage login() {
        loginButton.click();
        return new SauceDemoProductsPage(this);
    }
}
