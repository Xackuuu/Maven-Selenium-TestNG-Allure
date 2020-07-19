package tests.authorization;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.pflb.DriverManager;
import ru.pflb.pages.AuthorizationPage;

@Listeners(AuthorizationPage.class)
public class AuthorizationPageTest{

    String email = "asdfg@1secmail.net";
    String password = "X1lWrA";

    private AuthorizationPage authorizationPage = new AuthorizationPage();

    @Test(groups = {"authorization"})
    public void authorizationPageTest(){
        authorizationPage.openTestStand();
        authorizationPage.openWindowAuthorization();
        authorizationPage.inputEmail(email);
        authorizationPage.inputPassword(password);
        authorizationPage.clickEnterButton();
        authorizationPage.clickLogOutButton();
    }
    @AfterTest
    public void quit(){
        DriverManager.getDriver().quit();
    }
}
