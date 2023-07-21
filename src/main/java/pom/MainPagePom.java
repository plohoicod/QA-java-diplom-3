package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPagePom extends BasePom {

    private final WebDriver driver;

    private final By userAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    private final By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");


    private final By logInDownButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    private boolean findCreteOrderButton() {
        return find(driver, createOrderButton);
    }

    public MainPagePom(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLogInDownButton() {
        click(driver, logInDownButton);
    }

    private void waitForUserAccountButton() {
        wait(driver, userAccountButton);
    }

    private void clickUserAccountButton() {
        click(driver, userAccountButton);
    }

    public LogInPom loginFromUserAccountButton() {
        waitAndClick(driver, userAccountButton);
        return new LogInPom(driver);
    }

    public ProfilePom goToProfilePage() {
        waitForUserAccountButton();
        clickUserAccountButton();
        return new ProfilePom(driver);
    }

    public LogInPom loginFromDownButton() {
        waitLogInDownButton();
        clickLogInDownButton();
        return new LogInPom(driver);
    }

    public boolean checkCreateOrderButton() {
        waitCreateOrderButton();
        return findCreteOrderButton();
    }

    private void waitCreateOrderButton() {
       wait(driver, createOrderButton);
    }

    private void waitLogInDownButton() {
        wait(driver, logInDownButton);
    }
}
