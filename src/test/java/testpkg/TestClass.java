package testpkg;
import basepkg.BaseClass;
import utilities.Excel;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestClass extends BaseClass 
{
	@DataProvider(name="newsletterData")
	public Object[][] getNewsletterData() throws Exception {
	    String excelPath = "D:\\Luminar\\Automation Project\\config.xlsx";
	    String sheetName = "Email";  
	    return Excel.getData(excelPath, sheetName); // To read from Excel
	}

	
	@Test (priority=1)
	public void logoCheck() 
	{
		try
		{
		//test=extent.createTest("Home Page Logo Check");
		home.logoCheck();
		}
		catch(Exception e)
		{
			Assert.fail("Error in Logo Check call method:"+e.getMessage());
		}

	}
	@Test (priority=2)
	public void titleCheck()
	{
		try
		{
		//test=extent.createTest("Title Check");
		home.titleCheck("Welcome to Kerala Tourism - Official Website of Department of Tourism, Government of Kerala");
		}
		catch(Exception e)
		{
			Assert.fail("Error in Title Check call method: "+e.getMessage());
		}
	}
	@Test (priority=3)
	public void scrollButtonCheck()
	{
		try
		{
	//	test=extent.createTest("Scroll Button Check");
		home.scrollButtonCheck();
		}
		catch(Exception e)
		{
			Assert.fail("Error in Scroll call method: "+e.getMessage());
		}
	}
	@Test (priority=4)
	public void navigationMenuCheck()
	{
		try
		{
		//test=extent.createTest("Navigation Menu Check");
		home.navigationMenuCheck();
		}
		catch(Exception e)
		{
			Assert.fail("Error in Navigation Menu call method: "+e.getMessage());
		}
	}
	@Test (priority=5)
	public void searchCheck()
	{
		try
		{
		//test=extent.createTest("Search Check");
		home.searchCheck("Munnar");
		}
		catch(Exception e)
		{
			Assert.fail("Error in Search Check call method: "+e.getMessage());
		}
	}
	@Test(priority=6, dataProvider="newsletterData")
	public void newsCheck(String name, String email)
	{
		try
		{
		//test=extent.createTest("News Letter Check");
		home.newsLetter(name,email);
		}
		catch(Exception e)
		{
			Assert.fail("Error in News Letter Test call method: "+e.getMessage());
		}
	}
	@Test(priority=7)
	public void goingUp()
	{
		try
		{
			home.goUp();
		}
		catch(Exception e)
		{
			System.out.println("Scroll up call failed: "+e.getMessage() );
		}
	}
	@Test(priority=9)
	public void experiences() //Experiences Page
	{
		try
		{
		exp.experienceClick();
		}
		catch(Exception e)
		{
			Assert.fail("Error in Experiences Call:"+e.getMessage());
		}
	}
	@Test(priority=10)
	public void plan() //Plan Your Trip Page
	{
		try
		{
		plan.planYourTrip();
		}
		catch(Exception e)
		{
			Assert.fail("Error in Plan Your Trip Call:"+e.getMessage());
		}
	}
	@Test(priority=8)
	public void where() //Experiences Page
	{
		try
		{
		where.wheretoGoPage();
		}
		catch(Exception e)
		{
			Assert.fail("Error in Where to Go Call:"+e.getMessage());
		}
	}
	
}
