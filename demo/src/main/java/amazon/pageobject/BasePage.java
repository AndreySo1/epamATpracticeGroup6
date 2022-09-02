package amazon.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
   protected WebDriver webDriver;

   public BasePage(WebDriver webDriver) {
      this.webDriver = webDriver;
      PageFactory.initElements(webDriver, this);
   }
   
   public WebElement waitElement(WebElement element){
      new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

      return element;
   }

   public List<WebElement> waitElementS(List<WebElement> elements){
      new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(elements));

      return elements;
   }
}
