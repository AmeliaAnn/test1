package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends PageSettings{

    @FindBy(xpath = "//h2[contains(text(),'Главное')]")
    private WebElement titleMain;

    @FindBy(xpath = "//h2[contains(text(),'Главное')]//following-sibling::ul/li")
    private List<WebElement> publicationsList;

    @FindBy(xpath = "//h2[contains(text(),'Главное')]//following-sibling::ul/li[1]//descendant::p")
    private WebElement titleText;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[1]/div[2]/main/div[4]/div/button")
    private WebElement morePublicationsButton;

    private int expectedNumberOfPublications;

    public MainPage() {
        super();
    }

    public WebElement getTitleMain() {
        return titleMain;
    }

    public void moveTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public List<WebElement> getPublicationsList() {
        return publicationsList;
    }

    public int getExpectedNumberOfPublications() {
        return expectedNumberOfPublications;
    }

    public WebElement getTitleText() {
        return titleText;
    }

    public void setExpectedNumberOfPublications(int expectedNumberOfPublications) {
        this.expectedNumberOfPublications = expectedNumberOfPublications;
    }

    public void checkPublicationsNumber(int expectedNumber) {
        setExpectedNumberOfPublications(expectedNumber);
        Assert.assertEquals(getExpectedNumberOfPublications(),getPublicationsList().size());
    }

    public void viewMorePublications() throws InterruptedException {
       moveTo(getPublicationsList().get(getPublicationsList().size() - 1));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",morePublicationsButton);

        Thread.sleep(5000);
    }

    public void goToFirstPublication() {
        getPublicationsList().get(0).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
