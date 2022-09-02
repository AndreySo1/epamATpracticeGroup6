package amazon.pageobject.pages.task2_search_field_functionality.helpers;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SearchTextInListElements {
   
   public static boolean searchRegistr(List<WebElement> list, String searchData, boolean logicEvery){
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
