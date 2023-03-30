package uiTests;

import config.baseConfiguration.BaseConfiguration;
import objects.pages.HomePage;
import objects.pages.LoginPage;
import objects.pages.MyContractsPage;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@Tag("MyContracts")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class MyContractsTests extends BaseConfiguration {
    MyContractsPage myContractsPage = new MyContractsPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    @Test // �������� ���� ���������
    @Tag("OpenMyContracts")
    @DisplayName("1.�������� ����������� � �������� ��� ��������")
    public void login() {
        setUp();
        open("https://erir-uat.grfc.ru/login");
        loginPage.openLoginPage()
                .enterUserName("org_1")
                .enterUserPassword("GLEJzT0m");
        loginPage.clickLogin();
        homePage.openHomePage();
        homePage.openMenu();
        homePage.openMycontacts();
        sleep(1000);
    }

    @Test
    @Tag("PaginationMyContracts")
    @DisplayName("�������� �������� ��������� 100 � 10 � ��� ��������")
    public void paginationMycontr100(){
        myContractsPage.pressPaginationButton();
        myContractsPage.choosePagination("100");
        myContractsPage.checkPaginationContracts(100);
        myContractsPage.pressPaginationButton();
        myContractsPage.choosePagination("10");
        myContractsPage.checkPaginationContracts(10);

    }
    @Test
    @DisplayName("�������� �������� ��������� 50 � ��� ��������")
    public void paginationMycontr50(){
        myContractsPage.pressPaginationButton();
        myContractsPage.choosePagination("50");
        myContractsPage.checkPaginationContracts(50);
    }
    @Test
    @DisplayName("�������� �������� ��������� 20 � ��� ��������")
    public void paginationMycontr20(){
        myContractsPage.pressPaginationButton();
        myContractsPage.choosePagination("20");
        myContractsPage.checkPaginationContracts(20);
    }
    @Test
    @Tag("DonwnloadMyContracts")
    @DisplayName("�������� �������� ��������")
    public void cardDownload() {
        myContractsPage.pressDownCardButton();
        sleep(5000);
        myContractsPage.checkDownCardButton();
    }
    @Test
    @DisplayName("�������� �������� ��������")
    public void downloadMycont(){
        myContractsPage.pressDownButtom();
        sleep(5000);
        myContractsPage.checkDownCardButton();
    }
    @Test
    @Tag("TransitContracts")
    @DisplayName("2. �������� �������� � ����")
    public void transitActsCont(){
        myContractsPage.checkTransitContrActs();
    }
    /*@Test
    @DisplayName("�������� �������� � ����")
    public void transitRelCont(){
        myContractsPage.checkTransitContrRel();
    }
    @Test
    @DisplayName("�������� �������� � ����")
    public void transitAgreeCont(){
        myContractsPage.checkTransitContrAgree();
    }
*/
}
