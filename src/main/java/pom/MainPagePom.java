package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPagePom extends BasePom {

    private final WebDriver driver;

    private final By userAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");

    private final By createOrderButton = By.xpath(".//button[text() = 'Оформить заказ']");


    private final By logInDownButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    private final By createBurgerText = By.xpath(".//h1[text() = 'Соберите бургер']");

    private boolean findCreteOrderButton() {
        return find(driver, createOrderButton);
    }

    public void waitCreateBurgerText() {
        wait(driver, createBurgerText);
    }

    public MainPagePom selectConstructorTab(String item) {
        String constructorTabNotSelected = ".//span[text() = '%s']";
        click(driver, By.xpath(String.format(constructorTabNotSelected, item)));
        return new MainPagePom(driver);
    }

    public boolean checkConstructorTabIsActive(String item) {
        String constructorTabSelected = ".//div[@class[contains(.,'tab_tab_type_current__2BEPc')]]/span[text() = '%s']";
        wait(driver, By.xpath(String.format(constructorTabSelected, item)));

        return find(driver, By.xpath(String.format(constructorTabSelected, item)));
    }

    public MainPagePom(WebDriver driver) {
        this.driver = driver;
    }
    public LogInPom loginFromUserAccountButton() {
        waitAndClick(driver, userAccountButton);
        return new LogInPom(driver);
    }

    public ProfilePom goToProfilePage() {
        waitAndClick(driver, userAccountButton);
        return new ProfilePom(driver);
    }

    public LogInPom loginFromDownButton() {
        waitAndClick(driver, logInDownButton);
        return new LogInPom(driver);
    }

    public boolean checkCreateOrderButton() {
        waitCreateOrderButton();
        return findCreteOrderButton();
    }

    private void waitCreateOrderButton() {
       wait(driver, createOrderButton);
    }
}
