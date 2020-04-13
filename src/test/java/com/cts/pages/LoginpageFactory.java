package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
public class LoginpageFactory {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'My Account')]")
	@CacheLookup
	public WebElement Myacclocator;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	@CacheLookup
	public WebElement Loginlocator;
	@FindBy(how = How.XPATH, using = "//input[@id='input-email']")
	@CacheLookup
	public WebElement Emaillocator;
	@FindBy(how = How.XPATH, using = "//input[@id='input-password']")
	@CacheLookup
	public WebElement passwordlocator;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary']")
	@CacheLookup
	public WebElement buttonloginlocator;

	public LoginpageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String uid, String pass) {
		Myacclocator.click();
		Loginlocator.click();
		Emaillocator.sendKeys(uid);
		passwordlocator.sendKeys(pass);
		buttonloginlocator.click();
	}

}
