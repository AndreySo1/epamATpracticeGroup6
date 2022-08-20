package amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchFieldTest {
   protected WebDriver driver;
   protected String searchData = "laptop"; //default

   public SearchFieldTest() {    
      // before before
      System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
      this.driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   }

   @BeforeMethod
   public void before(){
      driver.get("https://www.amazon.com/");
      PageFactory.initElements(driver, this);
   }

   @AfterTest
   public void afterTest() {
      driver.close();
      driver.quit();
   }

   @FindBy(id = "twotabsearchtextbox")
   private WebElement searchField;

   @FindBy(xpath = "//span[@data-component-type='s-search-results']//span[@class='a-size-medium a-color-base']")
   private List<WebElement> searchNoResultElementS;   

   @FindBy(xpath = "//span[@data-component-type='s-result-info-bar']//div[@class='a-section a-spacing-small a-spacing-top-small']//span")
   private List<WebElement> searchResults;

   @FindBy(xpath = "//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']")
   private List<WebElement> searchCardsProduct;


   @DataProvider(name = "searchData")
      public Object[][] searchData() {
         return new Object[][] {
                  {"laptop"},
                  // {"phone"},
                  // {"keyboard"}
         };
      }
   
   @Test
   public void verifyNoResultsSearch(){
      String searchData = "637176486948segsgsgersbvs";
      String searchResult = "No results for";

      searchField.sendKeys(searchData, Keys.ENTER);

      Assert.assertEquals(searchField.getAttribute("value"), searchData); // value search fild contain searchData 
      Assert.assertEquals(
         searchNoResultElementS.get(0).getText(),
         searchResult); // first elem contain text "No results for"
      Assert.assertEquals(
         searchNoResultElementS.get(1).getText(),
         searchData); // second elem contain text searchData
   }

   @Test(dataProvider = "searchData")
   public void verifyCorrectSearch(String searchData){  

      searchField.sendKeys(searchData, Keys.ENTER);

      Assert.assertEquals(searchField.getAttribute("value"), searchData); // value search fild contain searchData 
      Assert.assertEquals(searchResults.get(2).getText(), "\""+searchData+"\""); // line count results contain text searchData
   }

   @Test(dataProvider = "searchData")
   public void verifyResultsSearch(String searchData){
      searchField.sendKeys(searchData, Keys.ENTER);

      Assert.assertEquals(searchField.getAttribute("value"), searchData); // value search fild contain searchData 
      Assert.assertTrue(searchRegistr(searchCardsProduct, searchData, false)); // at least card product contains searchData
   }

   // public boolean searchRegistr(WebElement e, String searchData){
   //    boolean result = false;
   //    String str = e.getText();
   //    String myStr = searchData.substring(0, 1).toUpperCase() + searchData.substring(1);

   //    if(str.matches("^.*"+searchData+".*$") ||
   //    str.matches("^.*(" + searchData.toUpperCase()+").*$") ||
   //    str.matches("^.*(" + myStr+").*$")
   //    ){ result = true; }

   //    return result;
   // }

   public boolean searchRegistr(List<WebElement> list, String searchData, boolean logicEvery){
      /**
       * if logicEvery==true same logic && (return true if EVERY element contain searchData)
       * if logicEvery==false same logic || (return true if AT LEAST element contain searchData)
       */
      boolean result = false;
      if(list.size()==0) return false;

      String myStr = searchData.substring(0, 1).toUpperCase() + searchData.substring(1);

      for(WebElement element : list){
         String text = element.getText();

         if(text.matches("^.*"+searchData+".*$") ||
         text.matches("^.*(" + myStr+").*$") ||
         text.matches("^.*(" + searchData.toUpperCase()+").*$")    
         ){ 
            result = true;
            if(!logicEvery) return true;
         } else {
            if(logicEvery) return false;
         }
      }

      return result;
   }
}