package amazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import amazon.factory.WebDriverFactory;

public class BaseTest {
   protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

   @BeforeTest
   protected void setUpDriver() {
      webDriver.manage().window().maximize();
  }

  @AfterTest
  protected void quit() {
      webDriver.close();
      webDriver.quit();
  }
   
}
