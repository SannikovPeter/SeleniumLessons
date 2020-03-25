package pageObject.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.Base;
import pageObject.BasePage.SearchPage.SearchPage;
import pageObject.BasePage.header.Header;

import java.time.Duration;

public class BasePage extends Base {

    private static final By searchFrameLocator = By.cssSelector(".modal-iframe");

    private LoginPage loginPage;
    private SearchPage searchPage;
    private Header header;
    private WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public SearchPage getSearchPage() {
        searchPage = new SearchPage(driver);
        return searchPage;
    }

    public Header getHeader() {
        header = new Header(driver);
        return header;
    }

    public void switchFrame() {
        driver.switchTo().frame(driver.findElement(searchFrameLocator));
    }

    public void scrollPageDown(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + 0 + "," + pixels + ");");
    }
}
