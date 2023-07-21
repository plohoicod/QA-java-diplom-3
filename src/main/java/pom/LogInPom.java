package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPom extends BasePom {

    private final WebDriver driver;

    private final By registrationButton = By.xpath(".//a[text() = 'Зарегистрироваться']");

    private final By signInButton = By.xpath(".//button[text() = 'Войти']");

    private final By emailInput = By.xpath(".//input[@type = 'text']");

    private final By passwordInput = By.xpath(".//input[@type = 'password']");

    private final By recoverPasswordButton = By.xpath(".//a[text() = 'Восстановить пароль']");

    public LogInPom(WebDriver driver) {
        this.driver = driver;
    }

    public PasswordRecoverPom goToPasswordRecoverPage() {
        waitAndClick(driver, recoverPasswordButton);
        return new PasswordRecoverPom(driver);
    }

    public void setEmail(String input) {
        wait(driver, registrationButton);
        setInput(driver, emailInput, input);
    }

    public void setPassword(String input) {
        setInput(driver, passwordInput, input);
    }

    public boolean findSignInButton() {
        return find(driver, signInButton);
    }

    private void clickSignInButton() {
       click(driver, signInButton);
    }

    public boolean waitUntilSignInButtonDisplayed() {
        wait(driver, signInButton);
        return findSignInButton();
    }

    public RegisterPom goToRegisterPage() {
        waitAndClick(driver, registrationButton);
        return new RegisterPom(driver);
    }

    public MainPagePom goToMainPage() {
        clickSignInButton();
        return new MainPagePom(driver);
    }
}
