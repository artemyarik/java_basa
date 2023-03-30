package uiTests;

import config.baseConfiguration.BaseConfiguration;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("�������� UI �������")
public class LoginTests extends BaseConfiguration {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test // ���� ����� login
    @Tag("Login")
    @DisplayName("�������� ����������� ����� �����")
    public void login(){

        loginPage.openLoginPage()
                .enterUserName("org_1");
        loginPage.enterUserPassword("GLEJzT0m");
        loginPage.clickLogin();
        homePage.openHomePage();
    }

}
