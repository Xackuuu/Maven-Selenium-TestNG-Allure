package ru.pflb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.pflb.DriverManager;

import static io.qameta.allure.Allure.step;
import static org.junit.Assert.assertTrue;

public class AuthorizationPage extends AbstractPage{

    @FindBy(id = "header-lk-button")
    WebElement loginButton;


    @FindBy(className = "link-lk")
    WebElement forgotPasswordButton;

    @FindBy(name = "login")
    WebElement loginField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(className = "lk-enter-btn")
    WebElement enterButton;

    @FindBy(id = "logout")
    WebElement accountExitButton;

    @Step()
    public void openTestStand() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        step("Открываем тестовый стенд и проверяем активна ли кнопка 'Войти'", () ->
        assertTrue(loginButton.isEnabled()));
    }
    @Step()
    public void openWindowAuthorization(){
        loginButton.click();
        step("Открывает окно авторизации и проверяем активна ли кнопка 'Забыли пароль'", () ->
                assertTrue(forgotPasswordButton.isEnabled()));
    }
    @Step()
    public void inputEmail(String email){
        loginField.sendKeys(email);
        step("Вводим 'email' в поле 'почта' и проверяем правильность ввода", () ->
                assertTrue(email.equals(loginField.getAttribute("value")))
        );
    }
    @Step()
    public void inputPassword(String password){
        passwordField.sendKeys(password);
        step("Вводим 'password' в поле 'пароль' и проверяем правильность ввода",() ->
                assertTrue(passwordField.getAttribute("value").equals(password)));

    }
    @Step()
    public void clickEnterButton(){
        enterButton.click();
        step("Нажимаем кнопку 'Войти' и проверяем активность кнопки 'Выйти'", () ->
                assertTrue(accountExitButton.isEnabled()));
    }
    @Step()
    public void clickLogOutButton(){
        accountExitButton.click();
        step("Нажимаем кнопку 'Выйти' и проверяем активность кнопки 'Войти'", () ->
                assertTrue(loginButton.isEnabled()));
    }

}