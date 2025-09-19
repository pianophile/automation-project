package basepkg;
import pagepkg.Home;
import pagepkg.Experiences;
import pagepkg.PlanYourTrip;
import pagepkg.WhereToGo;
import utilities.Excel;
import java.lang.reflect.Method;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme; //Importing Packages


public class BaseClass {
	
public static WebDriver driver;
public ExtentSparkReporter reporter;
public ExtentReports extent;
public ExtentTest test; //Reporter class objects

public Home home;
public Experiences exp;
public PlanYourTrip plan;
public Excel excel;
public WhereToGo where;//Created objects of subclasses
@BeforeTest
public void setUp() //Initialising Report Settings
{
	try
	{
	reporter=new ExtentSparkReporter("./Reports/TestReport.html");
	reporter.config().setDocumentTitle("Kerala Tourism - Automation Report");
	reporter.config().setReportName("Kerala Tourism");
	reporter.config().setTheme(Theme.DARK);
	
	extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("OS", "Windows 11"); //Report Headers
	extent.setSystemInfo("Tester", "Jeswin Raju");
	extent.setSystemInfo("Browser", "Google Chrome");
}
	catch(Exception e)
	{
		System.out.println("Error in Report Initialisation: "+e.getMessage());
	}
}

@BeforeClass
public void open()
{
	try
	{
	driver=new ChromeDriver(); //Initialise Chrome
	driver.get("https://www.keralatourism.org"); //Open URL
	driver.manage().window().maximize(); //Maximise Window
	}
	catch(Exception e)
	{
		System.out.println("Error in opening URL: "+e.getMessage());
	}
}

@BeforeMethod
public void createTest(Method method) 
{
	try
	{
	test=extent.createTest(method.getName());
	home=new Home(driver);
	exp=new Experiences(driver);
	plan=new PlanYourTrip(driver);
	where=new WhereToGo(driver);
	}
	catch(Exception e)
	{
		System.out.println("Error in Create Test: "+e.getMessage());
	}
}

@AfterTest
public void tearDown() throws Exception
{
	try
	{
	extent.flush();
	driver.quit(); //Close everything
	}
	catch(Exception e)
	{
	System.out.println("Error in Tear Down:"+e.getMessage());
	}
}

@AfterMethod
public void browserClose(ITestResult result) throws Exception //Marking TestCases for report
{
	try
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL,"Test case failed:"+result.getName());
		test.log(Status.FAIL, "Test case failed:"+result.getThrowable());
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, "Test case skipped:"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, "Test case passed:"+result.getName());
	}
	
} catch(Exception e)
	
	{
	System.out.println("Error in Browser Close: "+e.getMessage());
	}

}
}