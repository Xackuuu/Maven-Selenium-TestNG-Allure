package tests.func;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.pflb.pages.StartPage;

@Listeners(StartPage.class)
public class StartPageTest {
    StartPage step = new StartPage();

    @Test(groups = {"functional"})
    public void startPageTest(){
        step.openTestStand();
        step.clickProductInformationButtonAndCheckPictureElement();
        step.clickPriceButtonAndScrollPageAndCheckButtonContactToUs();
        step.clickFAQButtonAndScrollPageAndCheckButtonDownloadBook();
        step.clickIWantTestSitesButtonAndCheckLoginField();
    }
}
