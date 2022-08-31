package amazon.enumeration;

import org.openqa.selenium.WebDriver;

import amazon.invoker.WebDriverInvoker;
import amazon.invoker.implementations.LocalChromeInvoker;
import amazon.invoker.implementations.LocalFirefoxInvoker;

public enum SupportedBrowsers {
   LOCAL_FIREFOX(new LocalFirefoxInvoker()),
   LOCAL_CHROME(new LocalChromeInvoker());

   private WebDriverInvoker webDriverInvoker;

   SupportedBrowsers(WebDriverInvoker webDriverInvoker){
      this.webDriverInvoker = webDriverInvoker;
   }

   public WebDriver getWebDriver(){
      return webDriverInvoker.invokeWebDriver();
   }
}
