package com.TestCase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Base_Test_Cases_Class {

	public static WebDriver driver;
	public Logger logger;
	Properties prop;
	
	

	@BeforeClass(groups ={"Sanity","Regression","Master","DataDrivenGroups"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException   {
		
		
		// Loading configuration Properties file
		
		 FileReader file=new FileReader(".//src//test//resources//Config.properties");
		 prop=new Properties();
		 prop.load(file);
	
		logger= LogManager.getLogger("OpenCart_Project");
		
		switch (br.toLowerCase()) 
		{
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid Broswer Name");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();

	}

	/*
	 * @AfterClass public void tearDown() {
	 *  driver.quit(); }
	 */
	
	// Method for Random Data
	
	public String randomString() {
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		return genratedString;

	}
	

	public String randomNumber() {
		String genratedNumber = RandomStringUtils.randomNumeric(10);
		return genratedNumber;

	}
	
	public String randomAlphaNumberic() {
		String genratedString = RandomStringUtils.randomAlphabetic(5);
		String genratedNumber = RandomStringUtils.randomNumeric(3);
		
		return (genratedString+"@"+genratedNumber);
	}
	
	
	public String captureScreenShot(String testName) throws IOException {
		
		String timestamp = new SimpleDateFormat("yyyy.mmmm.dd.hh.mm.ss").format(new Date());
		

		TakesScreenshot takescreenshot = ((TakesScreenshot) driver);

		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		 	

		String targetFilePath = System.getProperty("user.dir")+ "\\ScreenShorts_Folder\\" + testName + "_"+ timestamp + ".png";

		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
				return targetFilePath;

	}
}
