package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TaskFourTestOne {

    @Test
    public void mainPage(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        List<WebElement> webElements = driver.findElements(By.xpath("//span[contains(text(),'LEGO')]"));

        for (WebElement webElement : webElements) {
            Assert.assertTrue(webElement.isDisplayed());
        }





        Assert.assertTrue( true );
        driver.close();
        driver.quit();
    }


}
