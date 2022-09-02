package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TaskFourPageObjectOneTest {

    private static final String LEGO = "LEGO";

    private WebDriver driver;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    public TaskFourPageObjectOneTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @BeforeTest
    public void setUp(){
        driver.get("https://www.amazon.com/");
        PageFactory.initElements(driver, this);
    }

    @Test
    public void testSearchLego(){
        String searchData = LEGO;
        searchField.sendKeys(searchData, Keys.ENTER);

        List<WebElement> webElements = driver.findElements(By.xpath("//span[contains(text(),'LEGO')]"));

        for (WebElement webElement : webElements) {

            if (webElement.isDisplayed()) {
                String title = webElement.getText();
                Assert.assertTrue(title.contains(LEGO));
            }
        }
    }


    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}