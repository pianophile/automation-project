package pagepkg;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WhereToGo {

	WebDriver driver;
	@FindBy(xpath="//li[normalize-space()='Where to go']") //Locators for each sub sections in Where to Go page
	WebElement whereToGo;
	
	@FindBy(xpath="//h6[normalize-space()='Attractions']")
	WebElement attractions;
	
	@FindBy(xpath="//div[@class='css-bprojc']//div[@class='css-1dci1oo']")
	WebElement hills;
	
	@FindBy(xpath="//h6[normalize-space()='Art & Culture']")
	WebElement artandculture;
	
	@FindBy(xpath="//div[@class='css-x6b6ng']//div[@class='css-1dci1oo']")
	WebElement institutions;
	
	@FindBy(xpath="//h6[normalize-space()='Picnic Spots']")
	WebElement picnicspots;
	
	@FindBy(xpath="//div[@class='css-124gqti']//div[@class='css-1dci1oo']")
	WebElement amusementpark;
	
	@FindBy(xpath="//h6[normalize-space()='Regions']")
	WebElement regions;
	
	@FindBy(xpath="//div[@class='css-bprojc']//div[@class='css-1dci1oo']")
	WebElement cities;
	
	@FindBy(xpath="//h6[normalize-space()='Spirituality']")
	WebElement spirituality;
	
	@FindBy(xpath="//div[@class='css-fxxblo']//div[@class='css-1dci1oo']")
	WebElement mosques;
	
	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closeButton;
	
	public WhereToGo(WebDriver driver) //Initialising constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void wheretoGoPage() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // Click "Where to go"
	        wait.until(ExpectedConditions.visibilityOf(whereToGo));
	        whereToGo.click();

	        // Click "Attractions" tab and wait for content
	        attractions.click();
	        wait.until(ExpectedConditions.visibilityOf(hills));
	        Assert.assertTrue(hills.isDisplayed(), "Attractions content not loaded");

	        // Click "Art & Culture" tab and wait for content
	        artandculture.click();
	        wait.until(ExpectedConditions.visibilityOf(institutions));
	        Assert.assertTrue(institutions.isDisplayed(), "Art & Culture content not loaded");

	        // Click "Picnic Spots" tab and wait for content
	        picnicspots.click();
	        wait.until(ExpectedConditions.visibilityOf(amusementpark));
	        Assert.assertTrue(amusementpark.isDisplayed(), "Picnic Spots content not loaded");

	        // Click "Regions" tab and wait for content
	        regions.click();
	        wait.until(ExpectedConditions.visibilityOf(cities));
	        Assert.assertTrue(cities.isDisplayed(), "Regions content not loaded");

	        // Click "Spirituality" tab and wait for content
	        spirituality.click();
	        wait.until(ExpectedConditions.visibilityOf(mosques));
	        Assert.assertTrue(mosques.isDisplayed(), "Spirituality content not loaded");

	        // Close the tab
	        closeButton.click();

	    } catch (Exception e) {
	        Assert.fail("Error in Where To Go method: " + e.getMessage());
	    }
	}

}