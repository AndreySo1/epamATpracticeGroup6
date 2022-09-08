package properties;

import enumeration.SupportedBrowsers1;

import static enumeration.SupportedBrowsers1.LOCAL_CHROME;

public class SupportedBrowserConverter {

    public static SupportedBrowsers1 valueOfWebBrowser(String webBrowserName) {
        return switch(webBrowserName) {
            case "local_chrome" -> LOCAL_CHROME;
            default -> throw new IllegalArgumentException();
        };
    }
}
