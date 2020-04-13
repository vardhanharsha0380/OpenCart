package com.cts.stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
public class Search extends BrowserFactory {
	Logger logger;

	WebDriver driver;

	ConfigReader config;

	ExcelDataConfig excel;

	LoginpageFactory login;

	public static ExtentReports report = new ExtentReports("./ExtentReports/search.html");

	ExtentTest test = report.startTest("Search criteria");

	@Given("^I have browser withopencartpage$")
	public void i_have_browser_withopencartpage() throws Throwable {

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

	@When("^Isearch for the product with 'samsung'$")
	public void isearch_for_the_product_with_samsung() throws Throwable {

		LoginPage loginPage = new LoginPage(driver);

		/**
		 * Read Excel from OpenCart.xlxx
		 */
		excel = new ExcelDataConfig(config.getExcelPath());

		loginPage.enterEmail(excel.getData(0, 1, 0));

		/**
		 * Enter Password
		 */
		loginPage.enterPassword(excel.getData(0, 1, 1));

		/**
		 * Click Login
		 */
		loginPage.clickOnLogin();

		/**
		 * Creates Logger Report
		 */
		logger.info("Login Succesful");

		/**
		 * Creates ExtentReports report
		 */
		test.log(LogStatus.PASS, "Login Details enter succesfully");

		SearchPage searchPage = new SearchPage(driver);

		/**
		 * Enter Product Name
		 */
		searchPage.searchText("samsung");

		/**
		 * Click on Search Box
		 */
		searchPage.searchBox();

		logger.info("Searched for the product");
	}

	@Then("^Ishould get all the search related products$")
	public void ishould_get_all_the_search_related_products() throws Throwable {

		SearchPage searchPage = new SearchPage(driver);

		/**
		 * Asserting for actual and expected
		 */
		String actualTitle = searchPage.getSearchRelatedTitle();
		Assert.assertEquals("Samsung SyncMaster 941BW", actualTitle);
		System.out.println(actualTitle);

		/**
		 * Asserting for actual and expected
		 */
		String actualTitle2 = searchPage.getSearchRelatedTitle2();
		Assert.assertEquals("Samsung Galaxy Tab 10.1", actualTitle2);
		System.out.println(actualTitle2);

		/**
		 * Captures ScreenShot
		 */
		Screenshot.capturescreenshot(driver, "Search valid product");

		/**
		 * Creates Logger Report
		 */
		logger.info("Searching for valid products Succesful");

		/**
		 * Creates ExtentReports
		 */
		test.log(LogStatus.PASS, "Searching valid products sucessfully");

		/**
		 * It ends ExtentReports report
		 */
		report.flush();

		/**
		 * Quits the driver
		 */
		driver.quit();

	}

}
