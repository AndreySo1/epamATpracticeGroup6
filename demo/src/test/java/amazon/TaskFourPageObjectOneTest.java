package amazon;

import amazon.pageobject.pages.exemple.AmazonSearchFilterPriceHomePage;
import com.google.common.collect.Ordering;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskFourPageObjectOneTest extends BaseTest {
    @Test
    public void testSearchLego() {
//        String searchData = LEGO;
//        searchField.sendKeys(searchData, Keys.ENTER);

        webDriver.get("https://www.amazon.com/");

        AmazonSearchFilterPriceHomePage homePage = new AmazonSearchFilterPriceHomePage(webDriver);

        List<WebElement> webElements = homePage.getLegoSearch();

        for (WebElement webElement : webElements) {

            if (webElement.isDisplayed()) {
                String title = webElement.getText();
                Assert.assertTrue(title.contains(AmazonSearchFilterPriceHomePage.LEGO));
            }
        }
    }


//    @Test
//    public void testFilterByPrice() {
//
//        driver.get(URL_FOR_FILTER);
//
//        Integer min = 5;
//        WebElement lowPrice = driver.findElement(By.id("low-price"));
//        lowPrice.sendKeys(min.toString());
//
//        Integer max = 6;
//        WebElement maxPrice = driver.findElement(By.id("high-price"));
//        maxPrice.sendKeys(max.toString(), Keys.ENTER);
//
//        Set<String> prices = filteredByPrice.stream()
//                .map(e -> e.getText())
//                .collect(Collectors.toSet());
//
//        //convert String prices to Integer prices
//        // and check price in filtered range [min, max]
//        for (String price : prices) {
//
//            try {
//                int priceInt = Integer.valueOf(price);
//
//                if (priceInt < min || priceInt > max) {
//                    continue;
//                }
//
//                Assert.assertTrue(priceInt >= min);
//                Assert.assertTrue(priceInt <= max);
//            } catch (NumberFormatException ex) {
//                continue;
//            }
//
//        }
//    }
//
//    @Test
//    public void testFilterByPriceAndSort() {
//
//
//        driver.get(URL_FOR_FILTER);
//
//        Integer min = 5;
//        WebElement lowPrice = driver.findElement(By.id("low-price"));
//        lowPrice.sendKeys(min.toString());
//
//        Integer max = 6;
//        WebElement maxPrice = driver.findElement(By.id("high-price"));
//        maxPrice.sendKeys(max.toString(), Keys.ENTER);
//
//        //click link Sort By:
//        Assert.assertTrue(sortBy.isDisplayed()); // Check/test/assert
//        sortBy.click();
//
//        //select sort from Low to High
//        Assert.assertTrue(sortAsc.isDisplayed()); // Check/test/assert
//        sortAsc.click();
//
//        //get list prices (String) from the list of all items to buy
//        List<String> pricesStr = filteredByPriceSorted.stream()
//                .map(e -> e.getText())
//                .collect(Collectors.toList());
//
//        List<Integer> pricesInt = new ArrayList<>();
//
//        //convert String prices to Integer prices
//        for (String price : pricesStr) {
//            try {
//                int priceInt = Integer.valueOf(price);
//                pricesInt.add(priceInt);
//            } catch (NumberFormatException ex) {
//                //skip empty price
//                continue;
//            }
//
//        }
//
//        //check sorting/ordering
//        Assert.assertTrue(Ordering.natural().isOrdered(pricesInt));
//    }
}