package com.cts.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cts.pages.LapTopPage;
import com.cts.pages.LoginPage;
import com.cts.pages.LoginpageFactory;
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
public class Comparision {
	Logger logger;

	WebDriver driver;

	ConfigReader config;

	LoginpageFactory login;

	/**
	 * Method to get ExtentReports
	 */
	public static ExtentReports report = new ExtentReports("./ExtentReports/Comparision.html");

	ExtentTest test = report.startTest("Comparision");

	/**
	 * @throws Throwable ^I had a webpage openacart$
	 */

	/**
	 * 
	 */
	@Given("^I had a webpage openacart$")
	public void i_had_a_webpage_openacart() throws Throwable

	{
		/**
		 * Configuring log4J properties file from./Resources/log4j.properties
		 */

		PropertyConfigurator.configure("./Resources/log4j.properties");

		/**
		 * Creating Logger report as Search
		 */

		logger = Logger.getLogger("Comparision");

		/**
		 * Reading ConfigReader from utility
		 */
		config = new ConfigReader();

		/**
		 * Launching Browser using BrowserFactory
		 */
		driver = BrowserFactory.startBrowser("chrome", config.getApplicationURL());

		/**
		 * 
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

	@When("^I click on comparission$")
	public void i_click_on_comparission() throws Throwable {

		/**
		 * To get the configuration properties
		 */
		config = new ConfigReader();

		/**
		 * To get the values from Excelsheet
		 */
		ExcelDataConfig excel = new ExcelDataConfig(config.getExcelPath());

		LoginPage loginPage = new LoginPage(driver);

		/**
		 * Enter Email
		 */
		loginPage.enterEmail(excel.getData(0, 1, 0));

		/**
		 * Enter Password
		 */
		loginPage.enterPassword(excel.getData(0, 1, 1));

		loginPage.clickOnLogin();

		/**
		 * Creates Logger report
		 */
		logger.info("Login Details enter succesfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Login Details enter succesfully");

		LapTopPage laptopPage = new LapTopPage(driver);

		/**
		 * Click on Laptops and notebooks
		 */
		laptopPage.clickOnLaptopsandNotebooks();

		/**
		 * Click on showall
		 */
		laptopPage.clickOnShowAll();

		/**
		 * Click on hp laptop compare icon
		 */
		laptopPage.hpCompare();

		/**
		 * Click on mac laptop compare icon
		 */
		laptopPage.macCompare();

	}

	@Then("^I should get thecomparision among the product$")
	public void i_should_get_thecomparision_among_the_product() throws Throwable {

		LapTopPage laptopPage = new LapTopPage(driver);

		/**
		 * Getting Comparision Table for selected products
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * Click on ComPareTable
		 */
		laptopPage.compareTable();

		/**
		 * It Captures Screenshots
		 */
		Screenshot.capturescreenshot(driver, "comparision of the products");

		/**
		 * Creates Logger report
		 */
		logger.info("Comparision among products Succesfull");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Comparision among products Succesfull");

		/**
		 * It Ends ExtentREports
		 */
		report.flush();

		// It Quits the driver
		driver.quit();
	}

}
