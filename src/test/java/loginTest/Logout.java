package loginTest;

/**
 * Test Case 2 - Выход из системы
 * Steps to reproduce:
 * 1) Открыть ссылку http://v3.test.itpmgroup.com/
 * 2) В форме авторизации в поле пароль ввести Student
 * 3) В поле пароль ввести 909090
 * 4) Кликнуть на кнопку "Вход"
 * 5) Кликнуть на аватарку пользователя в правом верхнем углу страницы
 * 6) Кликнуть на кнопку "Выход"
 * <p>
 * Expected result:
 * 1) Доступно текстовое название формы "Авторизация"
 * 2) Доступен инпут логин
 * 2) Доступна кнопка "Вход"
 */

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

public class Logout extends ParentTest {

    @Test
    public void userLogOut() {
        loginPage.userLogin(configProperties.valid_user_login(), configProperties.valid_user_password());
        Assert.assertTrue("Avatar isn't present", mainPage.isAvatarPresent());
        Assert.assertTrue("Menu isn't present", mainPage.isMenuItemsPresent());
        loginPage.userLogOut();
        loginPage.checkLoginFormPresentOnPage();
    }
}