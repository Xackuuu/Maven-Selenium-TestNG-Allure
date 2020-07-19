package ru.pflb.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.pflb.DriverManager;

import static io.qameta.allure.Allure.step;
import static org.junit.Assert.assertTrue;

public class StartPage extends AbstractPage{

    @FindBy(xpath = "//*[text()='Войти']")
    WebElement loginButton;

    @FindBy(xpath = "//*[text()='О продукте']")
    WebElement productInformationButton;

    @FindBy(className = "nl-about__start-img-people")
    WebElement picturePeople;

    @FindBy(xpath = "//*[text()='Цены']")
    WebElement priceButton;

    @FindBy(xpath = "//*[text()='10 тестов в месяц']")
    WebElement priceCard;

    @FindBy(xpath = "//*[text()='FAQ']")
    WebElement faqButton;

    @FindBy(xpath = "//*[text()='Как создать тест на UXCrowd?']")
    WebElement question;

    @FindBy(xpath = "//*[text()='Хочу тестировать сайты']")
    WebElement iWantTestSitesButton;

    @FindBy(name = "email")
    WebElement emailField;


    @Step("Открываем тестовый стенд и проверяем активна ли кнопка 'Войти'")
    public void openTestStand(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        assertTrue(loginButton.isEnabled());
    }

    @Step()
    public void clickProductInformationButtonAndCheckPictureElement(){
        productInformationButton.click();
        step("Нажимаем кнопку 'О продукте' и проверяем есть ли картинка с Людьми", ()->
                assertTrue(picturePeople.isEnabled()));
    }
    @Step()
    public void clickPriceButtonAndScrollPageAndCheckButtonContactToUs(){
        priceButton.click();
        step("Нажимаем кнопку 'Цены' прокручиваем страницу вниз и проверяем активна ли кнопка '10 тестов в месяц'", ()->
                assertTrue(priceCard.isEnabled()));
    }
    @Step()
    public void clickFAQButtonAndScrollPageAndCheckButtonDownloadBook(){
        faqButton.click();
        step("Нажимаем кнопку 'FAQ' и проверяем есть ли текст 'Скачать учебник'", ()->
                assertTrue(question.isEnabled()));
    }
    @Step()
    public void clickIWantTestSitesButtonAndCheckLoginField(){
        iWantTestSitesButton.click();
        step("Нажимаем кнопку 'Хочу тестировать сайты' и проверяем поле 'Введите почту'", ()->
                emailField.isEnabled());
    }


}
