package spareTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parentTest.ParentTest;

import static pages.ParentPage.configProperties;

/**
 * Test Case 7 - Создание нового аппарата
 * Preconditions:
 * 1) Открыть ссылку http://v3.test.itpmgroup.com/
 * 2) В форме авторизации в поле пароль ввести Student
 * 3) В поле пароль ввести 909090
 * 4) Кликнуть на кнопку "Вход"
 * 5) Кликнуть на пункт меню "Словари"
 * 6) Кликнуть на пункт меню "Аппарат"
 * 7) Проверить, что в списке нету аппарата с комментарием "Каляка Маляка", если есть, то удалить всё
 * <p>
 * Steps to reproduce:
 * 1) Кликнуть на кнопку +
 * 2) В инпут Названия аппарата ввести "Каляка Маляка"
 * 3) В дропдауне выбрать "Датчики"
 * 4) Кликнуть на кнопку "Создать"
 * 5) Проверить, что аппарат с комментарием создался" Каляка Маляка"
 * Postconditions:
 * 1) Удалить аппарат с комментарием "Каляка Маляка"
 */

public class AddNewSpareTest extends ParentTest {

    final String spareName = "Lorem ipsum";
    final String spareTypeText = "Some data";

    @Before
    public void beforeAddNewSpare() {
        loginPage.userLogin(configProperties.valid_user_login(), configProperties.valid_user_password());
        mainPage.clickOnMenuDictionary();
        mainPage.clickOnSubMenuSpare();
        sparesPage.deleteAllSparesWhenTheyArePresent(spareName);
    }

    @Test
    public void addNewSpare() {
        sparesPage.createNewSpare(spareName, spareTypeText);
        Assert.assertTrue("Created spare isn't present", sparesPage.isCreatedSpareIsPresent(spareName));
    }

    @After
    public void afterAddNewSpare() {
        if (sparesPage.isCreatedSpareIsPresent(spareName)) {
            sparesPage.deleteSpare(spareName);
        }
    }

}
