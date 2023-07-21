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
public class BurgerLogInTest extends BurgersBaseTest {

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    @Description("Проверка по кнопке 'Оформить заказ' перехода на главную страницу после успешного входа")
    public void logInFromMainPageDownButtonSuccess() {
        assertTrue("Неудачный вход по кнопке «Войти в аккаунт»",
                logIn(new MainPagePom(driver).loginFromDownButton()));
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Личный кабинет» на главной")
    @Description("Проверка по кнопке 'Оформить заказ' перехода на главную страницу после успешного входа")
    public void logInUserAccountButtonSuccess() {
        assertTrue("Неудачный вход по кнопке «Личный кабинет»",
                logIn(new MainPagePom(driver).loginFromUserAccountButton()));
    }

    @Test
    @DisplayName("Проверка входа по кнопке в форме регистрации")
    @Description("Проверка по кнопке 'Оформить заказ' перехода на главную страницу после успешного входа")
    public void logInFromRegistrationPageButtonSuccess() {
        assertTrue("Неудачный вход по кнопке в форме регистрации",
                logIn(new MainPagePom(driver)
                        .loginFromDownButton()
                        .goToRegisterPage()
                        .goToLogInPage()));
    }

    @Test
    @DisplayName("Проверка входа по кнопке в в форме восстановления пароля")
    @Description("Проверка по кнопке 'Оформить заказ' перехода на главную страницу после успешного входа")
    public void logInFromRecoverPasswordButtonSuccess() {
        assertTrue("Неудачный вход по кнопке в форме восстановления пароля",
                logIn(new MainPagePom(driver)
                        .loginFromDownButton()
                        .goToPasswordRecoverPage()
                        .goToLogInPage()));
    }

    private boolean logIn(LogInPom logInPom) {
        client.registerUser(new RegisterDto(TestData.EMAIL_1, TestData.PASSWORD_1, TestData.NAME_1));
        logInPom.setEmail(TestData.EMAIL_1);
        logInPom.setPassword(TestData.PASSWORD_1);

        return logInPom.goToMainPage().checkCreateOrderButton();
    }
}
