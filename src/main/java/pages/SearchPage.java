package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageSettings{
    @FindBy(xpath = ".//a[contains(@href,'https://dokhodchivo.ru/')]//h3")
    private WebElement searchLink;

    public SearchPage() {
        super();
    }

    public WebElement getSearchLink() {
        return searchLink;
    }

    public void checkLink(WebElement searchLink) {
        Assert.assertTrue(searchLink.isDisplayed());
    }
}
