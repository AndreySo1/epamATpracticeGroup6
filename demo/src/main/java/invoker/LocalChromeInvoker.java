package invoker;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalChromeInvoker implements WebDriverInvoker {


    @Override
    public WebDriver invokeWebDriver() {

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
