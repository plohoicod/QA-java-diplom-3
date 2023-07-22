package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoverPom extends BasePom {

    private final WebDriver driver;

    private final By signInButton = By.xpath(".//a[text() = 'Войти']");

    public PasswordRecoverPom(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPom goToLogInPage() {
        waitAndClick(driver, signInButton);
        return new LogInPom(driver);
    }
}
