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
import java.util.Set;
import java.util.stream.Collectors;

public class TaskFourPageObjectOneTest {

    private static final String LEGO = "LEGO";

    private WebDriver driver;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> filteredBYPrice;

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


    @Test
    public void testFilterByPrice() {

        driver.get("https://www.amazon.com/s?" +
                "k=school+supplies" +
                "&crid=3B2SMJ2SQ64N" +
                "&pd_rd_r=002c7e59-b3e2-4870-9de7-a9c54fb9263c" +
                "&pd_rd_w=9XU4m&pd_rd_wg=DkrTY" +
                "&pf_rd_p=c0f33dcc-b6ee-417c-b438-e358c4a5e8dc" +
                "&pf_rd_r=BSVWZBX1JYQGKW4WR8F4" +
                "&sprefix=school+su%2Caps%2C175" +
                "&ref=pd_gw_unk");

        Integer min = 5;
        WebElement lowPrice = driver.findElement(By.id("low-price"));
        lowPrice.sendKeys(min.toString());

        Integer max = 6;
        WebElement maxPrice = driver.findElement(By.id("high-price"));
        maxPrice.sendKeys(max.toString(), Keys.ENTER);

        Set<String> prices = filteredBYPrice.stream()
                .map(e -> e.getText())
                .collect(Collectors.toSet());

        //convert String prices to Integer prices
        // and check price in filtered range [min, max]
        for (String price : prices) {

            try {
                int priceInt = Integer.valueOf(price);

                if (priceInt < min || priceInt > max) {
                    continue;
                }

                Assert.assertTrue(priceInt >= min);
                Assert.assertTrue(priceInt <= max);
            } catch (NumberFormatException ex) {
                continue;
            }

        }
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}