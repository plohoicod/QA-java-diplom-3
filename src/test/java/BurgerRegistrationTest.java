import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import pom.MainPagePom;
import pom.RegisterPom;

import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BurgerRegistrationTest extends BurgersBaseTest {

    @Test
    @DisplayName("Проверка успешного создания пользователя")
    @Description("Проверка перехода на страницу входа после успешной регистрации")
    public void userRegistrationSuccess() {
        assertTrue("Регистрация не прошла",
                checkRegistration(TestData.PASSWORD_1)
                        .clickRegistrationButton().waitUntilSignInButtonDisplayed());
    }

    @Test
    @DisplayName("Проверка ошибки некорректного пароля")
    @Description("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void userRegistrationPasswordFail() {
        assertTrue("Пароль не проверен на корректность",
                checkRegistration(TestData.WRONG_PASSWORD_1)
                        .checkPasswordCorrectness());
    }

    private RegisterPom checkRegistration(String password) {
        MainPagePom mainPagePom = new MainPagePom(driver);
        RegisterPom registerPom = mainPagePom.loginFromDownButton().goToRegisterPage();

        registerPom.setName(TestData.NAME_1);
        registerPom.setEmail(TestData.EMAIL_1);
        registerPom.setPassword(password);


        return registerPom;
    }
}
