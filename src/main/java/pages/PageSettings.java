package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSettings {
    WebDriver driver;
    WebDriverWait wait;

    public PageSettings(){
        this.driver = Settings.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    public void start(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
