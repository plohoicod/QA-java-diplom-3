package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePom extends BasePom {

    private final WebDriver driver;

    private final By profileText = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    private final By constructorButton = By.xpath(".//p[text() = 'Конструктор']");

    private final By exitButton = By.xpath(".//button[text() = 'Выход']");

    private final By logo = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']");

    public ProfilePom(WebDriver driver) {
        this.driver = driver;
    }

    public LogInPom goToLoginPageWithExitButton() {
        waitAndClick(driver, exitButton);
        return new LogInPom(driver);
    }

    public MainPagePom goToMainPageWithConstructorButton() {
        waitAndClick(driver, constructorButton);
        return new MainPagePom(driver);
    }

    public MainPagePom goToMainPageWithLogo() {
        waitAndClick(driver, logo);
        return new MainPagePom(driver);
    }

    private void waitProfileText() {
        wait(driver, profileText);
    }

    private boolean findProfileText() {
        return find(driver, profileText);
    }

    public boolean checkProfileText(){
        waitProfileText();
        return findProfileText();
    }
}
