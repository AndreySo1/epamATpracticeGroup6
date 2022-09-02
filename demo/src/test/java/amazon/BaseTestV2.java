package amazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import amazon.factory.WebDriverFactory;

public class BaseTestV2 {
   protected WebDriver webDriver = null;

  @BeforeClass
  protected void beforeClass() {
   webDriver = new WebDriverFactory().getWebDriver();
   webDriver.manage().window().maximize();
  }

  @AfterClass
  protected void quitAfterClass() {
   webDriver.close();
  }

  @AfterTest
  protected void quit() {
      webDriver.quit();
  }
   
}
