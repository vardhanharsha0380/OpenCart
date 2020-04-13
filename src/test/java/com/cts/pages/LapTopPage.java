package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
public class LapTopPage {
	@FindBy(how = How.LINK_TEXT, using = "Laptops & Notebooks")
	@CacheLookup
	public WebElement lapTopClick;
	@FindBy(how = How.LINK_TEXT, using = "Show All Laptops & Notebooks")
	@CacheLookup
	public WebElement allLapTopClickLoc;
	@FindBy(how = How.XPATH, using = "//div[@class='caption']//a[contains(text(),'HP LP3065')]")
	@CacheLookup
	public WebElement hplaptopclick;
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-exchange']")
	@CacheLookup
	public WebElement hpCompareLoc;
	@FindBy(how = How.XPATH, using = "(//button[@type='button'])[14]")
	@CacheLookup
	public WebElement macCompareLoc;
	@FindBy(how = How.XPATH, using = "//a[text()='product comparison']")
	@CacheLookup
	public WebElement comparisionListLoc;
	@FindBy(how = How.XPATH, using = "//button[@id='button-cart']")
	@CacheLookup
	public WebElement CartClick;

	private WebDriver driver;

	public LapTopPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Click on Laptops and Notebooks
	 */
	public void clickOnLaptopsandNotebooks() {
		driver.findElement((By) lapTopClick).click();
	}

	/**
	 * click on show all laptops and desktops
	 */
	public void clickOnShowAll() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement((By) allLapTopClickLoc)).pause(1000).doubleClick().build().perform();
	}

	/**
	 * click on hp model laptop compare icon
	 */
	public void hpCompare() {
		driver.findElement((By) hpCompareLoc).click();
	}

	/**
	 * click on macbook model laptop compare icon
	 */
	public void hplaptop() {
		driver.findElement((By) hplaptopclick).click();
	}

	/**
	 * click on sony model laptop compare icon
	 */
	public void macCompare() {
		driver.findElement((By) macCompareLoc).click();
	}

	public void cartClick() {
		driver.findElement((By) CartClick).click();

	}

	/**
	 * Comparision table for selected model laptops
	 */
	public void compareTable() {

		for (int i = 0; i <= 2; i++) {
			try {
				driver.findElement((By) comparisionListLoc).click();
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
