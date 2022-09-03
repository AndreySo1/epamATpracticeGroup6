package factory;

import org.openqa.selenium.WebDriver;
import properties.PropertyHolder;
import properties.SupportedBrowserConverter;

public class WebDriverFactory {

    public WebDriver getWebDriver() {
        return SupportedBrowserConverter.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
