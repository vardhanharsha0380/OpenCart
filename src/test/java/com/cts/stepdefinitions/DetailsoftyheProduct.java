package com.cts.stepdefinitions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cts.pages.CamPage;
import com.cts.pages.HomePage;
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
public class DetailsoftyheProduct {
	Logger logger;

	WebDriver driver;

	ConfigReader config;

	LoginpageFactory login;

	public static ExtentReports report = new ExtentReports("./ExtentReports/Details.html");

	ExtentTest test = report.startTest("Details");

	@Given("^I have webpage named opencart$")
	public void i_have_webpage_named_opencart() throws Throwable {

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

	@When("^I click on any product$")
	public void i_click_on_any_product() throws Throwable {

		/**
		 * Click On Cameras
		 */

		HomePage homePage = new HomePage(driver);

		ExcelDataConfig excel = new ExcelDataConfig(config.getExcelPath());

		/**
		 * Click on My Account
		 */
		homePage.clickOnMyAccount();

		/**
		 * Click on Login
		 */
		homePage.clickOnLogin();

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

		test.log(LogStatus.PASS, "Login Details enter succesfully");

		/**
		 * click on cameras
		 */
		homePage.clickOnCameras();

		/**
		 * Click on Camera Model
		 */
		CamPage camPage = new CamPage(driver);

		/**
		 * Click on Product
		 */
		camPage.clickOnCanonEOS5D();

	}

	@Then("^I should get details of the product$")
	public void i_should_get_details_of_the_product() throws Throwable {

		/**
		 * Asserting the actual and expected and Printing the Camera Model description
		 */
		CamPage camPage = new CamPage(driver);

		/**
		 * Assertion
		 */
		String actualTitle = camPage.canon5DDetails();
		Assert.assertEquals("Canon EOS 5D", actualTitle);

		/**
		 * Printing
		 */
		System.out.println(actualTitle);

		String code = camPage.productCode();
		Assert.assertEquals("Product Code: Product 3", code);
		System.out.println(code);

		String reward = camPage.rewardPoints();
		Assert.assertEquals("Reward Points: 200", reward);
		System.out.println(reward);

		String avail = camPage.availability();
		Assert.assertEquals("Availability: 2-3 Days", avail);
		System.out.println(avail);

		/**
		 * It Captures Screenshot
		 */
		Screenshot.capturescreenshot(driver, "Details of the product");

		/**
		 * Creates Logger report
		 */
		logger.info("Got Valid details products sucessfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Got Valid details products sucessfully");

		/**
		 * It Ends ExtenReports
		 */
		report.flush();

		/**
		 * It Quits Driver
		 */
		driver.quit();

	}

}
