package amazon;

import PageObject.Pages.HomePage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeliverToTest_Task1 {

    private WebDriver driver;

    @Test
    public void testDeliverTo() {

        String test1 = new HomePage(driver)
                .open()
                .clickDeliverTo()
                .selectAmericanCity();

        Assert.assertEquals(test1, "Juneau 99801");

        driver.close();
        driver.quit();
    }

    @Test
    public void testPolandIsPresent() throws InterruptedException {

        String test2 = new HomePage(driver)
                .open()
                .clickDeliverTo()
                .checkPolandOnTheList();

        Assert.assertEquals(test2, "Poland");

        driver.close();
        driver.quit();
    }

    @Test
    public void testVerifyLocations() {

        String test3 = new HomePage(driver)
                .open()
                .clickDeliverTo()
                .checkAustraliaOnTheList()
                .verifyLocationsAreTheSame();

        Assert.assertEquals(test3, "Australia");

        driver.close();
        driver.quit();
    }
}
