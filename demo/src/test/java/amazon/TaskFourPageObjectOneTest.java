package amazon;

import amazon.pageobject.pages.exemple.AmazonSearchFilterPriceHomePage;
import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TaskFourPageObjectOneTest extends BaseTest {
    @Test
    public void testSearchLego() {
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


    @Test
    public void testFilterByPrice() {

        int min = AmazonSearchFilterPriceHomePage.MIN;
        int max = AmazonSearchFilterPriceHomePage.MAX;

        webDriver.get(AmazonSearchFilterPriceHomePage.URL_FOR_FILTER);

        AmazonSearchFilterPriceHomePage homePage = new AmazonSearchFilterPriceHomePage(webDriver);

        Set<String> prices = homePage.getFilterByPrice();

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

    @Test
    public void testFilterByPriceAndSort() {

        webDriver.get(AmazonSearchFilterPriceHomePage.URL_FOR_FILTER);

        AmazonSearchFilterPriceHomePage homePage = new AmazonSearchFilterPriceHomePage(webDriver);

        //get list prices (String) from the list of all items to buy
        List<String> pricesStr = homePage.getFilterByPriceAndSort();

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