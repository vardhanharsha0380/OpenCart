package com.cts.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */
public class BrowserFactory extends ConfigReader {
	public static WebDriver driver;
	public static ConfigReader config;

	public static WebDriver startBrowser(String browserName, String url) {
		config = new ConfigReader();
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", config.getChromepath());
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", config.getFirefoxpath());
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	/**
	 *  to sleep the application for a specific timeOut in seconds
	 * @param timeout
	 * @throws InterruptedException
	 */
	public static void sleep(int timeout) throws InterruptedException {
		TimeUnit.SECONDS.sleep(timeout);
	}

	/**
	 *  To close the browser
	 */
	public void quit() {
		driver.quit();
	}
}