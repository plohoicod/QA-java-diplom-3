import dto.RegisterDto;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pom.LogInPom;
import pom.MainPagePom;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BurgerUserAccountTest extends BurgersBaseTest {

    @Test
    @DisplayName("Проверка перехода по клику на «Личный кабинет».")
    @Description("Проверка перехода в личный кабинет по тексту")
    public void clickUserAccountSuccess() {
        assertTrue("Не удалось перейти в личный кабинет",
                autoLoginToMainPage()
                        .goToProfilePage()
                        .checkProfileText()
        );
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на «Конструктор»")
    @Description("Проверка по кнопке 'Оформить заказ' перехода на конструктор")
    public void clickConstructorSuccess() {
        assertTrue("Не удалось перейти в конструктор",
                autoLoginToMainPage()
                        .goToProfilePage()
                        .goToMainPageWithConstructorButton().checkCreateOrderButton());
    }

    @Test
    @DisplayName("Проверка перехода в конструктор по клику на логотип")
    @Description("Проверка по кнопке 'Оформить заказ' перехода на конструктор")
    public void clickLogoSuccess() {
        assertTrue("Не удалось перейти в конструктор",
                autoLoginToMainPage()
                        .goToProfilePage()
                        .goToMainPageWithLogo().checkCreateOrderButton());
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    @Description("Проверка по кнопке 'Войти' перехода на страницу входа")
    public void clickExitSuccess() {
        assertTrue("Не удалось выйти из аккаунта", autoLoginToMainPage()
                .goToProfilePage().goToLoginPageWithExitButton()
                .waitUntilSignInButtonDisplayed());
    }

    private MainPagePom autoLoginToMainPage() {
        client.registerUser(new RegisterDto(TestData.EMAIL_1, TestData.PASSWORD_1, TestData.NAME_1));
        LogInPom logInPom = new MainPagePom(driver).loginFromUserAccountButton();
        logInPom.setEmail(TestData.EMAIL_1);
        logInPom.setPassword(TestData.PASSWORD_1);

        return logInPom.goToMainPage();
    }
}
