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
public class HomePage {
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Account')]")
	@CacheLookup
	public WebElement myAccLocator;
	@FindBy(how = How.XPATH, using = "//a[text()='Register']")
	@CacheLookup
	public WebElement registerLocator;
	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	@CacheLookup
	public WebElement loginLocator;
	@FindBy(how = How.LINK_TEXT, using = "My Account")
	@CacheLookup
	public WebElement accTitleLoc;
	@FindBy(how = How.LINK_TEXT, using = "Cameras")
	@CacheLookup
	public WebElement camClickLoc;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Account click
	 */
	public void clickOnMyAccount() {
		driver.findElement((By) myAccLocator).click();
	}

	/**
	 * click on login
	 */
	public void clickOnLogin() {
		driver.findElement((By) loginLocator).click();
	}

	/**
	 * @return Printing the text that appear after login
	 */
	public String getCurrentTitle() {
		String actualTitle = driver.findElement((By) accTitleLoc).getText();
		return actualTitle;
	}

	/**
	 * Click on cameras
	 */
	public void clickOnCameras() {
		driver.findElement((By) camClickLoc).click();
	}

}
