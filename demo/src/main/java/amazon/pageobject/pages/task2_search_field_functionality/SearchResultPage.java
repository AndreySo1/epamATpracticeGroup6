package amazon.pageobject.pages.task2_search_field_functionality;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import amazon.pageobject.BasePage;

public class SearchResultPage extends BasePage{
   @FindBy(id = "twotabsearchtextbox")
   private WebElement searchField;

   @FindBy(xpath = "//span[@data-component-type='s-search-results']//span[@class='a-size-medium a-color-base']")
   private List<WebElement> searchNoResultElementS; 

   @FindBy(xpath = "//span[@data-component-type='s-result-info-bar']//div[@class='a-section a-spacing-small a-spacing-top-small']//span")
   private List<WebElement> searchResults;

   @FindBy(xpath = "//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']")
   private List<WebElement> searchCardsProduct;

   public SearchResultPage(WebDriver webDriver) {
      super(webDriver);
   }

   public WebElement getSearchField() {
      return waitElement(searchField);
   }

   public List<WebElement> getSearchNoResultElementS() {
      return waitElementS(searchNoResultElementS);
   }

   public List<WebElement> getSearchResults() {
      return waitElementS(searchResults);
   }

   public List<WebElement> getSearchCardsProduct() {
      return waitElementS(searchCardsProduct);
   }
    
}
