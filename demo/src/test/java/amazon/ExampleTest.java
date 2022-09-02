package amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import amazon.pageobject.pages.exemple.ExampleHomeTitlePage;

public class ExampleTest extends BaseTest{


   @Test
      public void checkTitle() {
         ExampleHomeTitlePage homePage = new ExampleHomeTitlePage(webDriver);

         String pageTitle = homePage.open()
          .getTitle();

          Assert.assertEquals( pageTitle, "Amazon.com. Spend less. Smile more.",
                  "This title is not HomePage");
         }
}
