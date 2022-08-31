package amazon.invoker.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import amazon.invoker.WebDriverInvoker;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalChromeInvoker implements WebDriverInvoker{

   @Override
   public WebDriver invokeWebDriver() {
      WebDriverManager.chromedriver().setup();
      return new ChromeDriver();
   }
   
}
