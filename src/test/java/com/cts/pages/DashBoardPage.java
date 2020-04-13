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
public class DashBoardPage {

	@FindBy(how = How.LINK_TEXT, using = "Logout")
	@CacheLookup
	public WebElement logoutLocator;

	private WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * logout
	 */
	public void clickOnLogout() {
		driver.findElement((By) logoutLocator).click();
	}
}
