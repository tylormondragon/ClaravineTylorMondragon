package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SauceDemoReviewOrderPage extends BasePage {
    private WebElement finishButton;
    public SauceDemoReviewOrderPage(BasePage handedOffPage) {
        super(handedOffPage);

        By finish = By.cssSelector("button[name='finish']");
        finishButton = findElement(finish);
    }

    public SauceDemoSuccessPage clickFinishOrder() {
        finishButton.click();
        return new SauceDemoSuccessPage(this);
    }
}
