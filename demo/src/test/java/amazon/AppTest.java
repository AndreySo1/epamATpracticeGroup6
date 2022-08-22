package amazon;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AppTest {



    @Test
    public void testDeliverTo() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/test/IdeaProjects/epamATpracticeGroup6/demo/src/test/resources/webdriver/chromedriver"
        );

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement deliverToButton =
                driver.findElement(By.xpath("//*[@id=\"glow-ingress-line1\"]"));
        deliverToButton.click();

        WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"GLUXZipUpdateInput\"]"));
        enterButton.sendKeys("99801");

        WebElement applyButton =
                driver.findElement(By.xpath("//*[@id=\"GLUXZipInputSection\"]/div[2]"));
        applyButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement continueButton =
                driver.findElement(By.xpath("//div[@class='a-popover-footer']/span[@class='a-button a-column a-button-primary a-button-span4']"));
        continueButton.click();

        WebElement cityButton =
                driver.findElement(By.xpath("//*[@id=\"glow-ingress-line2\"]"));

        Assert.assertEquals(cityButton.getText(), "Juneau 99801");

        driver.close();
        driver.quit();
    }

    @Test
    public void testPolandIsPresent () {
        System.setProperty("webdriver.chrome.driver",
                "/Users/test/IdeaProjects/epamATpracticeGroup6/demo/src/test/resources/webdriver/chromedriver"
        );

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement deliverToButton =
                driver.findElement(By.xpath("//*[@id=\"glow-ingress-line1\"]"));
        deliverToButton.click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"GLUXCountryListDropdown\"]/span/span"))).click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"GLUXCountryListDropdown\"]/span/span"))).click();
        new WebDriverWait(driver, 5)
                 .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='radiogroup']"))).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Poland = driver.findElement(By.xpath("//*[@id=\"GLUXCountryList_178\"]"));
        js.executeScript("arguments[0].scrollIntoView();", Poland);
        Assert.assertEquals(Poland.getText(), "Poland");

        driver.close();
        driver.quit();
    }


    @Test
    public void testCompareCountry() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/test/IdeaProjects/epamATpracticeGroup6/demo/src/test/resources/webdriver/chromedriver"
        );

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        WebElement deliverToButton =
                driver.findElement(By.xpath("//*[@id=\"glow-ingress-line1\"]"));
        deliverToButton.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"GLUXCountryListDropdown\"]/span/span"))).click();

        WebElement selectAustralia = driver.findElement(By.xpath("//*[@id=\"GLUXCountryList_0\"]"));
        selectAustralia.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement doneButton = driver.findElement(By.xpath("//*[@id=\"a-autoid-3-announce\"]"));
        doneButton.click();

        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
        }

        WebElement categoryButton =
                driver.findElement(By.xpath("//*[@aria-label='Computers & Accessories']"));
        categoryButton.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement productButton =
                driver.findElement(By.xpath("//*[contains(text(),'2755e')]"));
                productButton.click();

        WebElement lastButton =
                driver.findElement(By.xpath("//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]/span[2]"));

        Assert.assertEquals(lastButton.getText(), "Australia");


        driver.close();
        driver.quit();
    }

}


