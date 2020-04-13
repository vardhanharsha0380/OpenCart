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
public class MP3PlayerPage {
	@FindBy(how = How.LINK_TEXT, using = "MP3 Players")
	@CacheLookup
	public WebElement clickOnMP3;
	@FindBy(how = How.LINK_TEXT, using = "Show All MP3 Players")
	@CacheLookup
	public WebElement clickOnAllMP3;
	@FindBy(how = How.XPATH, using = "//h2[text()='MP3 Players']")
	@CacheLookup
	public WebElement mp3TitleLoc;
	@FindBy(how = How.XPATH, using = "(//span[@class='hidden-xs hidden-sm hidden-md'])[10]")
	@CacheLookup
	public WebElement ipodCartLoc;

	private WebDriver driver;

	public MP3PlayerPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * click on MP3 players
	 */
	public void clickOnMP3Players() {
		driver.findElement((By) clickOnMP3).click();
	}

	/**
	 * click on all MP3 Players
	 */
	public void clickOnAllMP3() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement((By) clickOnAllMP3)).pause(1000).doubleClick().build().perform();
	}

	/**
	 * @return click on all MP3 title
	 */
	public String getAllMP3Title() {
		String actualTitle = driver.findElement((By) mp3TitleLoc).getText();
		return actualTitle;
	}

	/**
	 * Adding ipod model to cart
	 */
	public void clickOnipodCart() {
		driver.findElement((By) ipodCartLoc).click();
	}
}
