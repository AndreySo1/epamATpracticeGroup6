package amazon;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskFourPageObjectThreeTest {


    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void testThree(){


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

        //click link Sort By:
        WebElement sortBy = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]")); // find by Xpath
        Assert.assertTrue(sortBy.isDisplayed()); // Check/test/assert
        sortBy.click();

        //select sort from Low to High
        WebElement sortAsc = driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']")); // Find by Xpath
        Assert.assertTrue(sortAsc.isDisplayed()); // Check/test/assert
        sortAsc.click();

        //list prices elements
        List<WebElement> webElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        //get list prices (String) from the list of all items to buy
        List<String> pricesStr = webElements.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());

        List<Integer> pricesInt = new ArrayList<>();

        //convert String prices to Integer prices
        for (String price : pricesStr) {
            try {
                int priceInt = Integer.valueOf(price);
                pricesInt.add(priceInt);
            } catch (NumberFormatException ex) {
                //skip empty price
                continue;
            }

        }

        //check sorting/ordering
        Assert.assertTrue(Ordering.natural().isOrdered(pricesInt));
    }
}

