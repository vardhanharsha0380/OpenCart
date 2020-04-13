package com.cts.stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cts.pages.HomePage;
import com.cts.pages.LoginPage;
import com.cts.pages.LoginpageFactory;
import com.cts.pages.SearchPage;
import com.cts.utility.BrowserFactory;
import com.cts.utility.ConfigReader;
import com.cts.utility.ExcelDataConfig;
import com.cts.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
public class InvalidSearch extends BrowserFactory {
	Logger logger;

	WebDriver driver;

	ConfigReader config;

	LoginpageFactory login;

	public static ExtentReports report = new ExtentReports("./ExtentReports/Invalid Search.html");

	ExtentTest test = report.startTest("Search criteria");

	@Given("^I had a opencart webpage$")
	public void i_had_a_opencart_webpage() throws Throwable {

		/**
		 * Configuring log4J properties file from./Resources/log4j.properties
		 */
		PropertyConfigurator.configure("./Resources/log4j.properties");

		/**
		 * Creating Logger report as Search
		 */
		logger = Logger.getLogger("Search");

		/**
		 * Reading ConfigReader from utility
		 */
		config = new ConfigReader();

		/**
		 * Launching Browser using BrowserFactory
		 */
		driver = BrowserFactory.startBrowser("chrome", config.getApplicationURL());

		/**
		 * Calling LoginpageFactory class using Pagefactory
		 */
		login = PageFactory.initElements(driver, LoginpageFactory.class);

		/**
		 * click on Myaccount
		 */
		login.Myacclocator.click();

		/**
		 * click on Login
		 */
		login.Loginlocator.click();

		/**
		 * Creates Logger report
		 */
		logger.info("WebPage Launched");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "WebPage Launched succesfully");

	}

	@When("^I search for invalid product$")
	public void i_search_for_invalid_product() throws Throwable {

		/**
		 * To get the configuration properties
		 */
		config = new ConfigReader();

		/**
		 * To get the values from Excelsheet
		 */
		ExcelDataConfig excel = new ExcelDataConfig(config.getExcelPath());

		/**
		 * Luanch the Homepage
		 */
		HomePage homePage = new HomePage(driver);

		/**
		 * Click on My Account
		 */
		homePage.clickOnMyAccount();

		/**
		 * Click on Login
		 */
		homePage.clickOnLogin();

		/**
		 * launching the homepage
		 */
		LoginPage loginPage = new LoginPage(driver);

		/**
		 * Enter Email
		 */
		loginPage.enterEmail(excel.getData(0, 1, 0));

		/**
		 * Enter Password
		 */
		loginPage.enterPassword(excel.getData(0, 1, 1));

		/**
		 * CLick on login button
		 */
		loginPage.clickOnLogin();

		/**
		 * Creates Logger report
		 */
		logger.info("Login Details enter succesfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Login Details enter succesfully");

		/**
		 * launching the searchpage
		 */
		SearchPage searchPage = new SearchPage(driver);

		/**
		 * Enter Product Name
		 */
		searchPage.searchText("productname");

		/**
		 * Click on Search Box
		 */
		searchPage.searchBox();
	}

	@Then("^print  There is no product that matches the search criteria$")
	public void print_There_is_no_product_that_matches_the_search_criteria() throws Throwable {

		SearchPage searchPage = new SearchPage(driver);

		/**
		 * Asserting and Printing the Actual message
		 */
		String actualTitle = searchPage.getinvalidSearchRelatedTitle();
		Assert.assertEquals("There is no product that matches the search criteria.", actualTitle);
		System.out.println(actualTitle);

		Screenshot.capturescreenshot(driver, "Invalid Search criteria");

		/**
		 * Creates Logger report
		 */
		logger.info("Invalid Search for product has done");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.FAIL, "Invalid Search ");

		/**
		 * Adds Screenshot to ExtentReport
		 */
		test.addScreenCapture("C:\\Users\\HP PC\\Desktop\\Invalid Search criteria.png");

		/**
		 * It Ends Extent Reports
		 */
		report.flush();

		/**
		 * It Quits the driver
		 */
		driver.quit();

	}
}
