package pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Experiences {

	WebDriver driver;
	
	@FindBy(xpath="//li[normalize-space()='Experiences']")
	WebElement experiences;
	
	@FindBy(xpath="//div[@class='chakra-linkbox css-jzeuao']//div[@class='css-1dci1oo']")
	WebElement munnar;
	
	@FindBy(xpath="//h6[normalize-space()='Responsible Tourism']")
	WebElement responsible;
	
	@FindBy(xpath="//div[@class='chakra-linkbox css-wjk6cb']//div[@class='css-1dci1oo']")
	WebElement neyyar;
	
	@FindBy(xpath="//h6[normalize-space()='Eco Tourism']")
	WebElement ecotourism;
	
	@FindBy(xpath="//h6[normalize-space()='Artforms']")
	WebElement artforms;
	
	@FindBy(xpath="//div[@class='css-x6b6ng']//div[@class='css-1dci1oo']")
	WebElement theyyam;
	
	@FindBy(xpath="//h6[normalize-space()='Cuisine']")
	WebElement cuisine;
	
	@FindBy(xpath="//div[@class='css-1hyuo62']//div[@class='css-1dci1oo']")
	WebElement desserts;
	
	@FindBy(xpath="//button[@aria-label='Close']")
	WebElement closeButton;
	
	public Experiences(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void experienceClick() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        // Click Experiences
	        wait.until(ExpectedConditions.visibilityOf(experiences)).click();

	        // Responsible Tourism
	        wait.until(ExpectedConditions.visibilityOf(responsible)).click();
	        wait.until(ExpectedConditions.visibilityOf(munnar));
	        Assert.assertTrue(munnar.isDisplayed(), "Responsible Tourism selected");

	        // Eco Tourism
	        wait.until(ExpectedConditions.visibilityOf(ecotourism)).click();
	        wait.until(ExpectedConditions.visibilityOf(neyyar));
	        Assert.assertTrue(neyyar.isDisplayed(), "Eco Tourism selected");

	        // Artforms
	        wait.until(ExpectedConditions.visibilityOf(artforms)).click();
	        wait.until(ExpectedConditions.visibilityOf(theyyam));
	        Assert.assertTrue(theyyam.isDisplayed(), "Artforms selected");

	        // Cuisine
	        wait.until(ExpectedConditions.visibilityOf(cuisine)).click();
	        wait.until(ExpectedConditions.visibilityOf(desserts));
	        Assert.assertTrue(desserts.isDisplayed(), "Cuisine selected");

	        // Close
	        wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();

	    } catch (Exception e) {
	        Assert.fail("Error in Experiences Click: " + e.getMessage());
	    }
	}

} 
