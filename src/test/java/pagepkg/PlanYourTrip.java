package pagepkg;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlanYourTrip {
	
	
	WebDriver driver;
	
	@FindBy(xpath="//li[normalize-space()='Plan your trip']")
	WebElement planYourTrip;
	
	@FindBy(xpath="//a[normalize-space()='Yathri Nivas - Book Online']")
	WebElement yathriNivas;
	
	@FindBy(xpath="//div[@class='css-ezrlju']")
	WebElement currency;
	
	 //List<WebElement> currencyList = driver.findElements(By.xpath("//div[@class='css-ezrlju']")); //Get currency values and store to list
	
	@FindBy(xpath = "//div[@class='css-ezrlju']")
	List<WebElement> currencyList;

	
	
	public PlanYourTrip(WebDriver driver) //Constructor to initialise web elements
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void planYourTrip()
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(planYourTrip));
			planYourTrip.click(); 
			wait.until(ExpectedConditions.visibilityOf(yathriNivas));
			Assert.assertTrue(yathriNivas.isDisplayed()); //Check if Plan your Trip has loaded
			
			for (WebElement currency : currencyList) //Print currency conversion rates one by one
			{
			    System.out.println(currency.getText());
			}
		}
		catch(Exception e)
		{
			Assert.fail("Plan your Trip method failed"+e.getMessage());
		}
	}

}
