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
public class LoginPage {
	@FindBy(how = How.ID, using = "input-email")
	@CacheLookup
	public WebElement emailLocator;
	@FindBy(how = How.ID, using = "input-password")
	@CacheLookup
	public WebElement passwordLocator;
	@FindBy(how = How.ID, using = "//input[@value='Login']")
	@CacheLookup
	public WebElement loginLocator;

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param Enter Username for login
	 */
	public void enterEmail(String email) {
		driver.findElement((By) emailLocator).sendKeys(email);
	}

	/**
	 * @param enter password for login
	 */
	public void enterPassword(String password) {
		driver.findElement((By) passwordLocator).sendKeys(password);
	}

	/**
	 * click on login
	 */
	public void clickOnLogin() {
		driver.findElement((By) loginLocator).click();
	}
}
