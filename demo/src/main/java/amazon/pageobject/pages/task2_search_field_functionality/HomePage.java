package amazon.pageobject.pages.task2_search_field_functionality;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.pageobject.BasePage;

public class HomePage extends BasePage{

   @FindBy(id = "twotabsearchtextbox")
   private WebElement searchField;

   public HomePage(WebDriver webDriver) {
      super(webDriver);
   }

   public HomePage open(){
      webDriver.get("https://www.amazon.com/");
      waitElement(searchField);
      return this;
   } 

   public SearchResultPage searchResult(String searchData){
      waitElement(searchField).sendKeys(searchData, Keys.ENTER);
      return new SearchResultPage(webDriver);
   }
   
}
