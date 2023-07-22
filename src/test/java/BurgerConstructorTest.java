import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pom.MainPagePom;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerConstructorTest extends BurgersBaseTest {

    private final String constructorItem1;

    private final String constructorItem2;


    public BurgerConstructorTest(String constructorItem1, String constructorItem2) {
        this.constructorItem1 = constructorItem1;
        this.constructorItem2 = constructorItem2;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Начинки", "Булки"},
                {"Соусы", "Начинки"},
                {"Начинки", "Соусы"}
        };
    }

    @Test
    @DisplayName("Проверка перехода к разделу конструтора")
    @Description("Проверка изменения элемента конструктора")
    public void clickAndCheckConstructorItemSuccess() {
        assertTrue("Элемент конструктора не изменился",
                new MainPagePom(driver)
                        .selectConstructorTab(constructorItem1)
                        .selectConstructorTab(constructorItem2)
                        .checkConstructorTabIsActive(constructorItem2));
    }
}
