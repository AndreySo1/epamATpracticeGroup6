package PageObject.Pages;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    By deliverToButton = By.xpath ("//*[@id=\"glow-ingress-line1\"]");
    By enterButton = By.xpath ("//*[@id=\"GLUXZipUpdateInput\"]");
    By applyButton = By.xpath ("//*[@id=\"//*[@id=\"GLUXZipInputSection\"]/div[2]");
    By continueButton = By.xpath ("//div[@class='a-popover-footer']/span[@class='a-button a-column a-button-primary a-button-span4']");

    By dropDownMenuButton = By.xpath ("//*[@id=\"GLUXCountryListDropdown\"]/span/span");
    By radioButton = By.xpath ("//*[@role='radiogroup']");

    By australiaOnTheList = By.xpath ("//*[@id=\"GLUXCountryList_0\"]");
    By doneButton = By.xpath ("//*[@id=\"a-autoid-3-announce\"]");
    By categoryButton = By.xpath ("//*[@aria-label='Computers & Accessories']");
    By productButton = By.xpath ("//*[contains(text(),'2755e')]");



    public HomePage (WebDriver driver) {
        super(driver);
    }

    public HomePage open() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/test/IdeaProjects/epamATpracticeGroup6@/demo/src/test/resources/webdriver/chromedriver"
        );
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public HomePage clickDeliverTo() {

        driver.findElement(deliverToButton).click();
        return this;
    }

    public HomePage selectAmericanCity() {

        driver.findElement(enterButton).sendKeys("99801");
        driver.findElement(applyButton).click();
        driver.findElement(continueButton).click();
        return this;
    }

    public HomePage checkCountryOnTheList() {
        driver.findElement(dropDownMenuButton).click();
        driver.findElement(radioButton).click();
        return this;
    }

    public HomePage verifyLocationsAreTheSame() {
        driver.findElement(australiaOnTheList).click();
        driver.findElement(doneButton).click();
        driver.findElement(categoryButton).click();
        driver.findElement(productButton).click();
        return this;
    }

}
