package enumeration;

import invoker.LocalChromeInvoker;
import invoker.WebDriverInvoker;
import invoker.implementations.LocalChromeInvoker;
import invoker.implementations.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers1 {
    LOCAL_CHROME(new LocalChromeInvoker());

    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers1(WebDriverInvoker webDriverInvoker) {

        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {

        return webDriverInvoker.invokeWebDriver();
    }

}
