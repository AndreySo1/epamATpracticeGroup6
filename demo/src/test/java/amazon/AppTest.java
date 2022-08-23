package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppTest {
   @Test
    public void mainPage(){

      System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");

      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.get("https://www.amazon.com/");

      Assert.assertTrue( true );
      driver.close();
      driver.quit();
    }
}
