package ru.pflb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationTest {

    @FindBy(xpath = "//*[text()='Войти']")
    WebElement loginButton;

    @FindBy(xpath = "//*[text()='Зарегистрироваться'")
    WebElement registrationButton;

    @FindBy(xpath = "//*[text()='Стать тестировщиком']")
    WebElement registrationTestButton;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(className = "lk-enter-btn ng-scope")
    WebElement enterRegistration;


}
