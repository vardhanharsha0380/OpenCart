package com.cts.utility;

import java.io.File;
/**
 @author GALI.HARSHA VARDHAN (853482),NARAHARI.DINESH(853480),KOTHURI.MANJUSHA(853483),CHEBROLU.PRASANNA(853447)
 *
 */

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	Properties pro;
	
	public ConfigReader()
	{
		try {
			File src= new File("./Configuration/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	public String getChromepath()
	{
		String path =pro.getProperty("ChromeDriver");
		return path;
	}
	public String getFirefoxpath()
	{
		String path =pro.getProperty("FirefoxDriver");
		return path;
	}
	public String getExcelPath()
	{
		String path =pro.getProperty("ExcelPath");
		return path;
	}
	public String getApplicationURL()
	{
		return pro.getProperty("URL");
	}
	
}