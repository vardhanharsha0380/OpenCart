package com.cts.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cts.pages.CheckOutPage;
import com.cts.pages.DashBoardPage;
import com.cts.pages.HomePage;
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
 class Integration {

	Logger logger;

	WebDriver driver;

	ConfigReader config;

	LoginpageFactory login;

	ExcelDataConfig excel;

	public static ExtentReports report = new ExtentReports("./ExtentReports/Integration.html");

	ExtentTest test = report.startTest("Integration");

	@Given("^I had a webpage opencart$")
	public void i_had_a_webpage_opencart() throws Throwable {

		/**
		 * Configuring log4J properties file from./Resources/log4j.properties
		 */
		PropertyConfigurator.configure("./Resources/log4j.properties");

		/**
		 * Creating Logger report as Search
		 */
		logger = Logger.getLogger("Integration");

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

	@When("^I enter valid credentials in login pag$")
	public void i_enter_valid_credentials_in_login_pag() throws Throwable {

		/**
		 * To get the configuration properties
		 */
		config = new ConfigReader();

		/**
		 * To get the values from Excelsheet
		 */
		excel = new ExcelDataConfig(config.getExcelPath());

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

		loginPage.clickOnLogin();

		/**
		 * Creates Logger report
		 */
		logger.info("Logged in  sucessfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Logged in  sucessfully");
	}

	@Then("^I have to navigate to laptop page and select product$")
	public void i_have_to_navigate_to_laptop_page_and_select_product() throws Throwable {

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
		laptopPage.hplaptop();

		/**
		 * CLick on Cart
		 */
		laptopPage.cartClick();

		/**
		 * Creates Logger report
		 */
		logger.info("product added cart sucessfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "product added cart sucessfully");

	}

	@When("^I enter the credentials in Checkout page$")
	public void i_enter_the_credentials_in_Checkout_page() throws Throwable {

		CheckOutPage checkoutPage = new CheckOutPage(driver);

		/**
		 * Click on shopping cart
		 */
		// checkoutPage.shoppingCartClick();

		/**
		 * Click on Checkout
		 */
		checkoutPage.checkOutClick();

		/**
		 * Wait to find the element
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * click on billing details
		 */
		checkoutPage.billDetailsClick();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * click on delivery details
		 */
		checkoutPage.deliveryDetailsClick();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/**
		 * click on delivery method
		 */
		checkoutPage.deliveryMethodClick();

		/**
		 * Click on bill details
		 */
		// checkoutPage.billDetailsClick();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * Accepting Terms and Conditions
		 */
		checkoutPage.termsClick();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/**
		 * Click on Payment continue icon
		 */
		checkoutPage.paycontinueClick();

		/**
		 * Creates Logger report
		 */
		logger.info("Check out   sucessfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Check out   sucessfully");

	}

	@Then("^I should navigate to payment's page$")
	public void i_should_navigate_to_payment_s_page() throws Throwable {

		CheckOutPage checkoutPage = new CheckOutPage(driver);

		/**
		 * Click on confirm order
		 */
		checkoutPage.confirmOrderClick();

		/**
		 * Asserting actual and expected
		 */
		String thanks = checkoutPage.thanks();

		/**
		 * It checks given value matches with output
		 */
		Assert.assertEquals("Your order has been placed!", thanks);

		/**
		 * Captures Screenshot
		 */
		Screenshot.capturescreenshot(driver, "Product has been placed");

		/**
		 * Printing the actual message
		 */
		System.out.println(thanks);

		/**
		 * Creates Logger report
		 */
		logger.info("Order Placed  sucessfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "Order Placed  sucessfully");
	}

	@Then("^I have to logout$")
	public void i_have_to_logout() throws Throwable {

		HomePage homePage = new HomePage(driver);

		/**
		 * Click on Myaccount
		 */
		homePage.clickOnMyAccount();

		DashBoardPage dashboard = new DashBoardPage(driver);

		/**
		 * Click On Logout
		 */
		dashboard.clickOnLogout();

		/**
		 * Creates Logger report
		 */
		logger.info("LogOut sucessfully");

		/**
		 * Creates ExtentReport report
		 */
		test.log(LogStatus.PASS, "LogOut sucessfully");

		/**
		 * It Ends ExtentReports
		 */
		report.flush();

		/**
		 * It Quits driver
		 */
		driver.quit();
	}

}
