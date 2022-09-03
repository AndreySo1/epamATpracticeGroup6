package amazon;

import PageObject.Pages.HomePage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliverToTest_Task1 {

    private WebDriver driver;

    @Test
    public void testDeliverTo() {

        By locationButton = By.xpath("//*[@id=\"glow-ingress-line2\"]");

        HomePage test1 = new HomePage(driver)
                .open()
                .clickDeliverTo()
                .selectAmericanCity();

        String result1 = driver.findElement(locationButton).getText();
        Assert.assertEquals(result1, "Juneau 99801");

        driver.close();
        driver.quit();
    }

    @Test
    public void testPolandIsPresent() {

        By polandOnTheList = By.xpath("//*[@id=\"GLUXCountryList_178\"]");

        HomePage test2 = new HomePage(driver)
                .open()
                .clickDeliverTo()
                .checkCountryOnTheList();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", polandOnTheList);
        Thread.sleep(500);

        String result2 = driver.findElement(polandOnTheList).getText();
        Assert.assertEquals(result2, "Poland");

        driver.close();
        driver.quit();
    }

    @Test
    public void testVerifyLocations() {

        By compareLocationButton = By.xpath("//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]/span[2]");

        HomePage test3 = new HomePage(driver)
                .open()
                .clickDeliverTo()
                .checkCountryOnTheList()
                .verifyLocationsAreTheSame();

        String result3 = driver.findElement(compareLocationButton).getText();
        Assert.assertEquals(result3, "Australia");

        driver.close();
        driver.quit();
    }
}
