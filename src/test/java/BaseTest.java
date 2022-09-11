import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseTest {
    private WebDriver driver;
    BasePage page;

    @BeforeEach
    public void setup() {
        WebDriver driver = DriverFactory.getDriver(DriverType.CHROME);
        this.page = new BasePage(driver);
        this.driver = page.getClassDriver();
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }
}
