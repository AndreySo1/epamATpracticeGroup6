package amazon.pageobject.pages.exemple;

import amazon.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonSearchFilterPriceHomePage extends BasePage {

    public static final String LEGO = "LEGO";
    private static final String SPAN_CLASS_A_PRICE_WHOLE = "//span[@class='a-price-whole']";
    private static final String URL_FOR_FILTER = "https://www.amazon.com/s?" +
            "k=school+supplies" +
            "&crid=3B2SMJ2SQ64N" +
            "&pd_rd_r=002c7e59-b3e2-4870-9de7-a9c54fb9263c" +
            "&pd_rd_w=9XU4m&pd_rd_wg=DkrTY" +
            "&pf_rd_p=c0f33dcc-b6ee-417c-b438-e358c4a5e8dc" +
            "&pf_rd_r=BSVWZBX1JYQGKW4WR8F4" +
            "&sprefix=school+su%2Caps%2C175" +
            "&ref=pd_gw_unk";

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(xpath = SPAN_CLASS_A_PRICE_WHOLE)
    private List<WebElement> filteredByPrice;

    @FindBy(xpath = "//span[contains(text(),'Sort by:')]")
    private WebElement sortBy;

    @FindBy(xpath = "//a[@id='s-result-sort-select_1']")
    private WebElement sortAsc;

    @FindBy(xpath = SPAN_CLASS_A_PRICE_WHOLE)
    private List<WebElement> filteredByPriceSorted;

    public AmazonSearchFilterPriceHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getLegoSearch() {
        String searchData = LEGO;
        searchField.sendKeys(searchData, Keys.ENTER);
        List<WebElement> webElements = webDriver.findElements(By.xpath("//span[contains(text(),'LEGO')]"));

        return webElements;
    }
}
