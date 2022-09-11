package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoCheckoutInformationPage extends BasePage {
    private WebElement firstName;
    private WebElement lastName;
    private WebElement zipCode;

    private WebElement continueButton;
    public SauceDemoCheckoutInformationPage(BasePage handedOffPage) {
        super(handedOffPage);
        By first = By.cssSelector("input[name='firstName']");
        firstName = findElement(first);

        By last = By.cssSelector("input[name='lastName']");
        lastName = findElement(last);

        By zip = By.cssSelector("input[name='postalCode']");
        zipCode = findElement(zip);

        By continueBtn = By.cssSelector("input[name='continue']");
        continueButton = findElement(continueBtn);
    }

    public SauceDemoReviewOrderPage clickContinue() {
        continueButton.click();
        return new SauceDemoReviewOrderPage(this);
    }

    private void enterFirstName(String first) {
        firstName.sendKeys(first);
    }

    private void enterLastName(String last) {
        lastName.sendKeys(last);
    }

    private void enterZipCode(String zip) {
        zipCode.sendKeys(zip);
    }

    public void fillOutPersonalInformation(String first, String last, String zip) {
        enterFirstName(first);
        enterLastName(last);
        enterZipCode(zip);
    }
}
