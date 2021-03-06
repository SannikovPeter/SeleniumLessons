import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {

    private static final int TIME = 5;
    WebDriver driver;

    @BeforeTest
    public void WebSettings() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://onliner.by/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TIME, TimeUnit.SECONDS);
    }

    @AfterTest
    void closeBrowser() {
        driver.quit();
    }
}
