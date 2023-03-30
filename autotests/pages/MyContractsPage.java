package objects.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyContractsPage {

    protected final SelenideElement actContractPage = $(".TabButtonstyled__Tab-sc-bzwk46-1.hRoHiK");
    protected final SelenideElement unContractPage = $(".TabButtonstyled__Tab-sc-bzwk46-1.eoKHvu");
    protected final SelenideElement paginationButton = $(".ElementsPerPageSelectstyled__Container-sc-1udn857-0.gKCeLx");
    protected final SelenideElement downloadCardButton = $(".CardArticlestyled__OptionsButton-sc-1a6xpiv-4.hESjFF");
    protected final SelenideElement acceptDownCardButton = $(".PrimaryButtonstyled__Button-sc-xjhvuw-0.PrimaryButtonstyled__ButtonWithText-sc-xjhvuw-1");
    protected final SelenideElement checkboxDonwCard = $(".PrimaryCheckboxstyled__CustomCheckbox-sc-1gs29au-2.kiEAyE");
    protected final SelenideElement errorDownCard = $(".Toaststyled__ToastDescription-sc-1xqzcb5-1.gsMcUE");
    protected final SelenideElement downloadButton = $(".light-button.light");
    protected final SelenideElement downloadButtonXLSX = $(".Y5gv7KUwQpl8RjKm7VL4OQ\\=\\=");
    protected final SelenideElement actspage = $(".page-content-header-pathsContainer > .page-content-header-title");


    protected final ElementsCollection activeTransitcont = $$(".ArticleCountButtonstyled__ButtonLink-sc-o7zdzh-1.fuDLhp");
    protected final ElementsCollection actspageCards = $$(".CardArticlestyled__Container-sc-1a6xpiv-0.dORoYL");
    protected final ElementsCollection cardContainerCollection = $$(".CardArticlestyled__Container-sc-1a6xpiv-0.dORoYL");
    protected final ElementsCollection paginationButtonsCollection = $$(".ElementsPerPageSelectstyled__Item-sc-1udn857-2.dpOoiw");

    @Step("Нажатие на кнопку пагинации")
    public void pressPaginationButton() {
        paginationButton.click();
    }
    @Step("Выбор пагинации из коллекции")
    public void choosePagination(String count) {
        paginationButtonsCollection.findBy(text(count)).click();
    }
    @Step("Проверка открытия страницы авторизации")
    public void checkPaginationContracts(int count) {
        cardContainerCollection.shouldHave(size(count));
    }
    @Step("Нажатие на кнопку выгрузкит карточки")
    public void pressDownCardButton() {
        downloadCardButton.click();
        assertFalse(acceptDownCardButton.isEnabled());
        checkboxDonwCard.click();
        assertTrue(acceptDownCardButton.isEnabled());
        acceptDownCardButton.click();
    }
    @Step("Нажатие на кнопку выгрузкит карточки")
    public void checkDownCardButton() {
        assertFalse(errorDownCard.isDisplayed());
    }
    @Step("Проверка выгрузки")
    public void pressDownButtom(){
        downloadButton.click();
        downloadButtonXLSX.shouldBe(visible);
        downloadButtonXLSX.click();
    }
    @Step("Проверка переходов в Акты")
    public void checkTransitContrActs() {
        activeTransitcont.findBy(attribute("href")).shouldBe(visible);
        activeTransitcont.findBy(attribute("href")).click();
        sleep(5000);
        actspage.shouldHave(text("АКТЫ ПО ДОГОВОРУ"));
        assertFalse(actspageCards.isEmpty());
    }
    @Step("Проверка переходов в Договоры")
    public void checkTransitContrRel() {
        assertTrue(activeTransitcont.findBy(cssClass("a[href^='/relcontracts']")).isDisplayed());
        activeTransitcont.findBy(cssClass("a[href^='/relcontracts']")).click();
    }
    @Step("Проверка переходов в Доп. соглашения")
    public void checkTransitContrAgree() {
        assertTrue(activeTransitcont.findBy(cssClass("a[href^='/agreement']")).isDisplayed());
        activeTransitcont.findBy(cssClass("a[href^='/agreement']")).click();
    }
}
