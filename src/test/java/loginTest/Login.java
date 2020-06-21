package loginTest;

/**
 * Test Case 1 - Авторизация в системе
 * Steps to reproduce:
 * 1) Открыть ссылку http://v3.test.itpmgroup.com/
 * 2) В форме авторизации в поле пароль ввести Student
 * 3) В поле пароль ввести 909090
 * 4) Кликнуть на кнопку "Вход"
 * <p>
 * Expected result:
 * 1) Доступна аватарка пользователя
 * 2) Доступно главное меню с пунктом "Главная"
 * 3) Доступно главное меню с пунктом "Cловари"
 * 4) Доступно главное меню с пунктом "Обслуживание"
 * 5) Доступно главное меню с пунктом "Установка"
 * 6) Доступно главное меню с пунктом "Сделки"
 * 7) Доступно главное меню с пунктом: "Отчёт"
 */

import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

public class Login extends ParentTest {

    @Test
    public void userLogin() {
        loginPage.userLogin(configProperties.valid_user_login(), configProperties.valid_user_password());
        checkAC("Avatar isn't present", mainPage.isAvatarPresent(), true);
        checkAC("Menu items aren't present", mainPage.isMenuItemsPresent(), true);
    }
}