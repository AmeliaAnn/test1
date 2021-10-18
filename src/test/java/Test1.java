import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class Test1 extends Settings {
    @Test
    public void newTest() throws InterruptedException {
        StartPage startPage = new StartPage();
        startPage.searchInput("https://dokhodchivo.ru/ ");
        startPage.searchClick();

        SearchPage searchPage = new SearchPage();
        searchPage.checkLink(searchPage.getSearchLink());
        searchPage.getSearchLink().click();

        MainPage mainPage = new MainPage();
        mainPage.moveTo(mainPage.getTitleMain());
        mainPage.checkPublicationsNumber(6);
        mainPage.viewMorePublications();
        mainPage.checkPublicationsNumber(12);
        mainPage.goToFirstPublication();

        FirstPublicationPage firstPublicationPage = new FirstPublicationPage();
        firstPublicationPage.checkTitles(mainPage.getTitleText().getText());
    }
}
