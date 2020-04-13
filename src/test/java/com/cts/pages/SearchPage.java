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
public class SearchPage {
	@FindBy(how = How.XPATH, using = "//input[@type='text']")
	@CacheLookup
	public WebElement searchLoc;
	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[4]")
	@CacheLookup
	public WebElement searchBoxLoc;
	@FindBy(how = How.XPATH, using = "//a[text()='Samsung SyncMaster 941BW']")
	@CacheLookup
	public WebElement searchTitleLoc;
	@FindBy(how = How.XPATH, using = "//a[text()='Samsung Galaxy Tab 10.1']")
	@CacheLookup
	public WebElement searchTitleLoc2;
	@FindBy(how = How.XPATH, using = "//p[text()='There is no product that matches the search criteria.']")
	@CacheLookup
	public WebElement invalidSearchLoc;

	private WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param productName
	 */
	public void searchText(String productName) {
		driver.findElement((By) searchLoc).sendKeys(productName);
	}

	/**
	 * search for invalid products
	 */
	public void searchBox() {
		driver.findElement((By) searchBoxLoc).click();
	}

	/**
	 * @return printing valid search text
	 */
	public String getSearchRelatedTitle() {
		String actualTitle = driver.findElement((By) searchTitleLoc).getText();
		return actualTitle;
	}

	/**
	 * @return printing invalid search text
	 */
	public String getSearchRelatedTitle2() {
		String actualTitle = driver.findElement((By) searchTitleLoc2).getText();
		return actualTitle;
	}

	public String getinvalidSearchRelatedTitle() {
		String actualTitle = driver.findElement((By) invalidSearchLoc).getText();
		return actualTitle;
	}

}
