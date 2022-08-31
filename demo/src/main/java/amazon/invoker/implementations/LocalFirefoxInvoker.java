package amazon.invoker.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import amazon.invoker.WebDriverInvoker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalFirefoxInvoker implements WebDriverInvoker{

   @Override
   public WebDriver invokeWebDriver() {
      WebDriverManager.firefoxdriver().setup();
      return new FirefoxDriver();

   }   
}
