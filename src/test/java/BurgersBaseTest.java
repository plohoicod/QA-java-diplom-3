import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BurgersBaseTest {

    WebDriver driver;

    AuthClient client = new AuthClient();

    @Before
    public void startUp() {
        RestAssured.baseURI = TestData.BASE_URL;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        switch (TestData.BROWSER_NAME) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver","/Users/ydpolivt/Downloads/yandexdriver");
                driver = new ChromeDriver(options);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver(options);
                break;
            default:
                throw new RuntimeException("Wrong browser");
        }
        driver.get(TestData.BASE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
        client.deleteUser(TestData.EMAIL_1, TestData.PASSWORD_1);
    }
}
