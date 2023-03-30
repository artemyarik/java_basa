package objects.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    protected final SelenideElement loginPage = $(By.xpath("//p[text()='Единый реестр интернет-рекламы']"));
    protected final SelenideElement userNameField = $(By.name("username"));
    protected final SelenideElement userPasswordField = $(By.name("password"));
    protected final SelenideElement HelpCenter = $(By.cssSelector("[href*='help']"));
    protected final SelenideElement Feedback = $(By.cssSelector("[href*='feedback']"));
    protected final SelenideElement buttonLogin = $(By.xpath("//button[@type='submit']"));


    @Step("Checking the opening of the authorization page")
    public LoginPage openLoginPage() {
        assertFalse(loginPage.isDisplayed());
        return this;
    }

    @Step("Enter the user name")
    public LoginPage enterUserName(String username) {
        userNameField.click();
        userNameField.sendKeys(username);
        return this;
    }

    @Step("Enter the user's password")
    public void enterUserPassword(String password) {
        userPasswordField.click();
        userPasswordField.sendKeys(password);
    }

    @Step("Click the \"Help Center\" button")
    public void enterHelpCenter() {
        HelpCenter.click();
        switchTo().window(1);
    }

    @Step("Click the \"Feedback\" button")
    public void enterFeedback() {
        Feedback.click();
        switchTo().window(1);
    }

    @Step("Click the \"Log in\" button")
    public void clickLogin() {
        buttonLogin.click();
    }
}
