package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import amazon.factory.WebDriverFactory;

public class BaseTest {
    protected final WebDriver webDriver;

    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        this.webDriver = new ChromeDriver();
    }

    @BeforeTest
    protected void setUpDriver() {
        webDriver.manage().window().maximize();
    }

    @AfterTest
    protected void quit() {
        webDriver.close();
        webDriver.quit();
    }
}
