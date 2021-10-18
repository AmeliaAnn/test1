package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstPublicationPage extends PageSettings{

    @FindBy(xpath = "//h1")
    private WebElement header;

    public FirstPublicationPage() {
        super();
    }

    public WebElement getHeader() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header;
    }

    public void checkTitles(String title) {
        Assert.assertEquals(title,header.getText());
    }
}
