package uiTests;

import config.baseConfiguration.BaseConfiguration;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка UI системы")
public class LoginTests extends BaseConfiguration {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test // Вход через login
    @Tag("Login")
    @DisplayName("Успешная авторизация через логин")
    public void login(){

        loginPage.openLoginPage()
                .enterUserName("org_1");
        loginPage.enterUserPassword("GLEJzT0m");
        loginPage.clickLogin();
        homePage.openHomePage();
    }

}
