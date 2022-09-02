package amazon;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.pageobject.pages.task2_search_field_functionality.HomePage;
import amazon.pageobject.pages.task2_search_field_functionality.SearchResultPage;
import amazon.pageobject.pages.task2_search_field_functionality.helpers.SearchTextInListElements;

public class PObj_SearchFieldTest extends BaseTestV2{
   String searchData = "laptop";

   @DataProvider(name = "searchData")
      public Object[][] searchData() {
         return new Object[][] {
                  {"laptop"},
                  {"phone"},
                  {"keyboard"}
         };
      }

   @Test
   public void verifyNoResultsSearch(){
      String searchData = "637176486948segsgsgersbvs";
      String searchResult = "No results for";

      SearchResultPage pageResult = new HomePage(webDriver)
      .open()
      .searchResult(searchData);

      Assert.assertEquals(pageResult.getSearchField().getAttribute("value"), searchData);
      Assert.assertEquals(pageResult.getSearchNoResultElementS().get(0).getText(),
         searchResult);
      Assert.assertEquals(pageResult.getSearchNoResultElementS().get(1).getText(),
            searchData); 
   }

   @Test
   public void verifyCorrectSearch(){ 
      SearchResultPage pageResult = new HomePage(webDriver)
            .open()
            .searchResult(searchData);

      Assert.assertEquals(pageResult.getSearchField().getAttribute("value"), searchData);
      Assert.assertEquals(pageResult.getSearchResults().get(2).getText(), "\""+searchData+"\"");
   }

   @Test(dataProvider = "searchData")
   public void verifyResultsSearch(String searchData){
      SearchResultPage pageResult = new HomePage(webDriver)
            .open()
            .searchResult(searchData);

      Assert.assertEquals(pageResult.getSearchField().getAttribute("value"), searchData);
      Assert.assertTrue(SearchTextInListElements.searchRegistr(pageResult.getSearchCardsProduct(), searchData, false) , "List elemens don't contains {searchData}");     
   }
   
}
