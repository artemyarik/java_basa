package objects.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    protected final SelenideElement homePage = $(".HomePagestyled__Content-sc-wdkbdd-1.iJBjSN");
    protected final SelenideElement menuPage = $(".Hamburgerstyled__Hamburger-sc-di95st-0.gOJCVM");
    protected final SelenideElement myContsPage = $(By.cssSelector("a[href='/contracts']"));

    @Step("Checking the opening of the main page")
    public void openHomePage() {
        assertFalse(homePage.isDisplayed());
    }
    @Step("Checking menu")
    public void openMenu(){
        assertFalse(menuPage.isDisplayed());
        menuPage.click();
    }
    @Step("Checking My Contracts button")
    public void openMycontacts(){
        myContsPage.click();
    }
}
