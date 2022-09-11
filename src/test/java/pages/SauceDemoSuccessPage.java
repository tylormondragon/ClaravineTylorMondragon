package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoSuccessPage extends BasePage {
    private WebElement successTitle;
    private WebElement thankYou;
    public SauceDemoSuccessPage(BasePage handedOffPage) {
        super(handedOffPage);

        By success = By.cssSelector("span[class='title']");
        successTitle = findElement(success);

        By thanks = By.cssSelector("h2[class='complete-header']");
        thankYou = findElement(thanks);
    }

    public WebElement getSuccessTitle() {
        return successTitle;
    }

    public WebElement getThankYou() {
        return thankYou;
    }
}
