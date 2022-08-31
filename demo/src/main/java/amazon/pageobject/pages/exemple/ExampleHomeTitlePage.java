package amazon.pageobject.pages.exemple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import amazon.pageobject.BasePage;

public class ExampleHomeTitlePage extends BasePage{
   @FindBy(xpath = "//exemple")
   private WebElement exempleElemen;

   public ExampleHomeTitlePage(WebDriver webDriver) {
      super(webDriver);
   }

   public ExampleHomeTitlePage open(){
      webDriver.get("https://www.amazon.com/");
      return this;
   }  

   public String getTitle() {     
      return webDriver.getTitle();
  }
}
