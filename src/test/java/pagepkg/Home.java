package pagepkg;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Home {
	
	WebDriver driver;
	@FindBy(xpath="//*[@alt=\"Kerala Tourism\"]")
	WebElement img_Logo; //Kerala Tourism Logo
	
	@FindBy(xpath="//*[@class=\"progress-wrap css-1dqfubg active-progress\"]")
	WebElement scrollButton; //Dynamic Scroll Button
	
	@FindBy(xpath="//*[@role=\"list\"]")
	List<WebElement> nav_Menus; //List of navigation menus
	
	@FindBy(xpath="//*[@aria-label=\"Search In Application\"]") //Search button
	WebElement searchButton;
	
	@FindBy(id="searchKeyword") //Search bar
	WebElement searchBar;
	 
	@FindBy(xpath="//*[@class=\"chakra-modal__close-btn css-1w1kb9i\"]") //Search bar close button
	WebElement searchButtonClose;
	
	@FindBy(xpath="//button[normalize-space()='Subscribe']") //Subscribe Newsletter button
	WebElement subscribeButton;
	
	@FindBy(xpath="//p[normalize-space()='Name and Email are required.']") //Newsletter error message popup
	WebElement newsLetterError;
	
	@FindBy(xpath="(//header[normalize-space()='Success'])[1]") //Newsletter success message popup
	WebElement newsLetterSuccess;
	
	@FindBy(xpath="//button[normalize-space()='Close']") //Newsletter close button
	WebElement newsLetterClose;
	
	@FindBy(xpath="//*[@placeholder=\"Email\"]") //Newsletter Email field
	WebElement newsLetterEmailField;
	
	@FindBy(xpath="//*[@placeholder=\"Name\"]") //Newsletter name field
	WebElement newsLetterNameField;
	
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this); //Links driver with Page class, Initializes all web elements
	}

	public void logoCheck() //To check whether Logo is present in Home page
	{
		try
		{
			Assert.assertTrue(img_Logo.isDisplayed(),"Logo not found!");
			img_Logo.click();
			Assert.assertTrue(driver.getCurrentUrl().contains("keralatourism.org"));
			System.out.println("Completed Logo check.");
		}
		catch(Exception e)
		{
			Assert.fail("Error in Logo Check method:"+e.getMessage());
		}
	}
	
	public void titleCheck(String exp_Title) //To check the title matches the expected title
	{
		try
		{
			String actual_Title=driver.getTitle();
			Assert.assertTrue(true, actual_Title);
			Assert.assertEquals(actual_Title,exp_Title,"Title mismatch!");
			System.out.println("Completed Title check.");
		}
		catch(Exception e)
		{
			Assert.fail("Error in Title Check:"+e.getMessage());
		}
	}
	public void scrollButtonCheck() // To check if scroll up button is present and working
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3)); //Adding 3 s delay
	        wait.until(ExpectedConditions.visibilityOf(scrollButton));
	        scrollButton.click();
	        System.out.println("Completed Scroll Button check");
		} 
		catch(Exception e)
		{
			Assert.fail("Error in Scroll Button check method:"+e.getMessage());
		}
	}
	public void navigationMenuCheck() //Check whether Navigation Menu elements are present
	{
	    try {
	        Assert.assertTrue(nav_Menus.size() > 0, "Navigation menus not found!");
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	        System.out.println("Total Menus: " + nav_Menus.size());

	        for (WebElement menu : nav_Menus) {
	        	wait.until(ExpectedConditions.visibilityOf(menu));
	            Assert.assertTrue(menu.isDisplayed(), "Menu not visible: " + menu.getText());
	            System.out.println("Menu found: " + menu.getText());
	        }
	        System.out.println("Completed Navigation Menu check");
	    } catch (Exception e) {
	        Assert.fail("Error in Navigation Menu Check: " + e.getMessage());
	    }
	}

	public void searchCheck(String searchText) { 
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        // Wait for search button and click
	        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
	        searchButton.click();

	        // Wait for search bar
	        wait.until(ExpectedConditions.visibilityOf(searchBar));
	        searchBar.sendKeys(searchText);

	        // Press Enter to submit search
	        searchBar.sendKeys(Keys.ENTER);

	        // Store the main window handle
	        String mainWindow = driver.getWindowHandle();

	        // Wait until a new tab is opened
	        wait.until(driver -> driver.getWindowHandles().size() > 1);

	        // Switch to new tab
	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(mainWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        // Verify results page in new tab
	        wait.until(ExpectedConditions.urlContains("search"));
	        System.out.println("Search executed successfully with keyword: " + searchText);
	        
	        // Switch back to main tab
	        driver.close(); // Optional: close the search tab
	        driver.switchTo().window(mainWindow);
	        System.out.println("Switched back to Home page.");
	        System.out.println("Completed Search check.");
	        searchButtonClose.click();

	    } catch (Exception e) {
	        Assert.fail("Error in Search Check: " + e.getMessage());
	    }
	}


	public void newsLetter(String newsLetterName, String newsMail) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        System.out.println("News Letter Name:"+newsLetterName);
	        System.out.println("News Letter Mail:"+newsMail);

	        // Check inputs
	        if (newsLetterName == null || newsLetterName.trim().isEmpty()) {
	           // Assert.fail("Newsletter Name is null or empty.");
	        	newsLetterName="default";
	        }
	        if (newsMail == null || newsMail.trim().isEmpty()) {
	           // Assert.fail("Newsletter Email is null or empty.");
	        	newsMail="default@default.com";
	        }

	        // Open newsletter modal
	        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
	        wait.until(ExpectedConditions.elementToBeClickable(newsLetterClose)).click();

	        // Fill the newsletter form
	        wait.until(ExpectedConditions.visibilityOf(newsLetterNameField));
	        newsLetterNameField.clear();
	        newsLetterNameField.sendKeys(newsLetterName);

	        newsLetterEmailField.clear();
	        newsLetterEmailField.sendKeys(newsMail);

	        // Submit form
	        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();

	        // Verify success
	        wait.until(ExpectedConditions.visibilityOf(newsLetterSuccess));
	        newsLetterClose.click();

	        System.out.println("Completed News Letter check successfully");

	    } catch (Exception e) {
	        Assert.fail("Error in News Letter: " + e.getMessage());
	    }
	}

	 
	 public void goUp()
	 {
		 try
		 {
		 scrollButton.click();
		 }
		 catch( Exception e)
		 {
			 Assert.fail("Going up failed");
		 }
	 }

	

	
}