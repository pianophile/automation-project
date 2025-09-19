KERALA TOURISM AUTOMATION PROJECT
----------------------------------
This project is an automated testing framework for the Kerala Tourism website. It uses Java, Selenium WebDriver, and TestNG, following the Page Object Model (POM) design pattern to keep the tests clean, maintainable, and reusable. The framework covers core functionalities of the website and generates detailed reports for test results.

Functionalities Covered in this Project
-----------------------
--> Automates testing for Home, Where to Go, Plan Your Trip, and Experiences sections of the website.
--> Verifies elements like logos, navigation menus, scroll buttons, search functionality, and newsletter subscriptions.
--> Implements data-driven testing for newsletter subscriptions using Excel spreadsheets.
--> Fetches and prints currency conversion rates from the Plan Your Trip section.
--> Generates detailed HTML test reports using ExtentReports.
--> Handles dynamic page interactions like pop-ups, tabs, and scrolling.

Project Structure
-----------------
basepkg
    BaseClass.java       -> Browser setup, teardown, and reporting
pagepkg
    Home.java            -> Home page interactions
    WhereToGo.java       -> Where to Go page interactions
    PlanYourTrip.java    -> Plan Your Trip page interactions
    Experiences.java     -> Experiences page interactions
testpkg
    TestClass.java       -> TestNG test methods and DataProviders; All classes in pagepkg are called here.
utilities
    Excel.java           -> Reads data from Excel for tests
Reports
    TestReport.html      -> Generated HTML test report is stored in this folder

How to Use
----------
--> Clone the repository to your local machine.
--> Make sure ChromeDriver is installed and added to your system PATH.
--> Update the Excel file path in TestClass.java if needed.
--> Run tests via TestNG XML or directly from your IDE.
--> Open ./Reports/TestReport.html to check test results.

Technologies Used
-----------------
--> Java
--> Selenium WebDriver
--> TestNG
--> ExtentReports
--> Apache POI (for Excel integration)
