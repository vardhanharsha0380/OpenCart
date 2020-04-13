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
public class CamPage {

	@FindBy(how = How.XPATH, using = "//a[text()='Canon EOS 5D']")
	@CacheLookup
	public WebElement canon5DclickLoc;

	@FindBy(how = How.XPATH, using = "//h1[text()='Canon EOS 5D']")
	@CacheLookup
	public WebElement canon5DTitleLoc;

	@FindBy(how = How.XPATH, using = "//li[text()='Product Code: Product 3']")
	@CacheLookup
	public WebElement productCodeLoc;

	@FindBy(how = How.XPATH, using = "//li[text()='Reward Points: 200']")
	@CacheLookup
	public WebElement rewardLoc;

	@FindBy(how = How.XPATH, using = "//li[text()='Availability: 2-3 Days']")
	@CacheLookup
	public WebElement availLoc;

	private WebDriver driver;

	public CamPage(WebDriver driver) {
		this.driver = driver;
	}

	//

	/**
	 * @camera model click
	 */

	public void clickOnCanonEOS5D() {
		driver.findElement((By) canon5DclickLoc).click();
	}

	/**
	 * @return To print model name as
	 */
	public String canon5DDetails() {
		String canonTitle = driver.findElement((By) canon5DTitleLoc).getText();
		return canonTitle;
	}

	/**
	 * @return To print model code
	 */
	public String productCode() {
		String productName = driver.findElement((By) productCodeLoc).getText();
		return productName;
	}

	/**
	 * @return To print model Reward points
	 */
	public String rewardPoints() {
		String rewardPoints = driver.findElement((By) rewardLoc).getText();
		return rewardPoints;
	}

	/**
	 * @return print Availability of products
	 */
	public String availability() {
		String availability = driver.findElement((By) availLoc).getText();
		return availability;
	}

}
