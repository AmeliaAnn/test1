package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends PageSettings{

    @FindBy(xpath = ".//input")
    private WebElement searchString;

    public StartPage(){
        super();
        this.driver = Settings.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        start("https://www.google.com/");
    }

    public WebElement getSearchString() {
        return searchString;
    }

    public void searchInput(String search) {
        searchString.sendKeys(search);
    }

    public void searchClick() {
        searchString.submit();
    }
}
