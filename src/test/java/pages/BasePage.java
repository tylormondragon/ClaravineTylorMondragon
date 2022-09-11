package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BasePage {
    private final WebDriver classDriver;

    public BasePage(BasePage handedOffPage) {
        this.classDriver = handedOffPage.classDriver;
    }

    public BasePage(WebDriver driver) {
        classDriver = driver;
    }

    public WebDriver getClassDriver() {
        return this.classDriver;
    }

    public <T extends BasePage> Object goTo(String url, Class<T> expectedPage) {
        classDriver.get(url);
        try {
            return (T) expectedPage.getConstructors()[0].newInstance(this);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElement(By by) {
        // These aren't necessary, but as behaviors become repeated across pages I can create consolidation methods here
        // Helps for special handling or tracking
        return classDriver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return classDriver.findElements(by);
    }
}
