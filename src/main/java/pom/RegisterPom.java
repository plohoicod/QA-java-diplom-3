package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPom extends BasePom {

    private final WebDriver driver;


    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    private final By passwordInput = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type = 'password']");
    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");

    private final By incorrectPasswordStatus = By.xpath(".//p[text() = 'Некорректный пароль']");

    private final By logInButton = By.xpath(".//a[text() = 'Войти']");

    public RegisterPom(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPom goToLogInPage() {
        click(driver, logInButton);
        return new LogInPom(driver);
    }

    public boolean checkPasswordCorrectness() {
        click(driver, nameInput);
        return find(driver, incorrectPasswordStatus);
    }

    public void setName(String input) {
       wait(driver, registrationButton);

       setInput(driver, nameInput, input);
    }

    public void setEmail(String input) {
        setInput(driver, emailInput, input);
    }

    public void setPassword(String input) {
        setInput(driver, passwordInput, input);
    }


    public LogInPom clickRegistrationButton() {
        click(driver, registrationButton);
        return new LogInPom(driver);
    }
}
