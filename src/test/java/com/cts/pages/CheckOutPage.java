package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
public class CheckOutPage {
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout')]")
	@CacheLookup
	public WebElement checkOutClickLoc;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Shopping Cart')]")
	@CacheLookup
	public WebElement shoppingCartClickLoc;
	@FindBy(how = How.XPATH, using = "//input[@id='button-payment-address']")
	@CacheLookup
	public WebElement billContinueLoc;
	@FindBy(how = How.XPATH, using = "//input[@id='button-shipping-address']")
	@CacheLookup
	public WebElement deliveryContinueLoc;
	@FindBy(how = How.XPATH, using = "//input[@id='button-shipping-method']")
	@CacheLookup
	public WebElement delMethodLoc;
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[2]/div[1]/input[1]")
	@CacheLookup
	public WebElement termsLoc;
	@FindBy(how = How.XPATH, using = "//input[@id='button-payment-method']")
	@CacheLookup
	public WebElement payMethodLoc;
	@FindBy(how = How.XPATH, using = "//input[@id='button-confirm']")
	@CacheLookup
	public WebElement confirmOrderLoc;
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your order has been placed!')]")
	@CacheLookup
	public WebElement thanksLoc;

	private WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Click on shopping cart
	 */
	public void shoppingCartClick() {
		driver.findElement((By) shoppingCartClickLoc).click();
	}

	/**
	 * click on checkout
	 */
	public void checkOutClick() {
		driver.findElement((By) checkOutClickLoc).click();
	}

	/**
	 * click on billing details
	 */
	public void billDetailsClick() {
		driver.findElement((By) billContinueLoc).click();
	}

	/**
	 * click on delivery details
	 */
	public void deliveryDetailsClick() {
		driver.findElement((By) deliveryContinueLoc).click();
	}

	/**
	 * click on delivery method
	 */
	public void deliveryMethodClick() {
		driver.findElement((By) delMethodLoc).click();
	}

	/**
	 * accepting terms and conditions click
	 */
	public void termsClick() {
		driver.findElement((By) termsLoc).click();
	}

	/**
	 * Selecting Payment method
	 */
	public void paycontinueClick() {
		driver.findElement((By) payMethodLoc).click();
	}

	/**
	 * click on confirm order
	 */
	public void confirmOrderClick() {
		driver.findElement((By) confirmOrderLoc).click();
	}

	/**
	 * @returnPrint thanks for shopping
	 */
	public String thanks() {
		String thanks = driver.findElement((By) thanksLoc).getText();
		return thanks;
	}

}
