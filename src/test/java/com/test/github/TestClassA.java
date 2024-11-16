package com.test.github;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassA {
	
	WebDriver driver;	
	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().clearResolutionCache();
		//WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().clearDriverCache();
		WebDriverManager.chromedriver().setup();
		
		HashMap<String,Object> chromePrefs = new HashMap<String, Object>(); 
    	chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.prompt_for_download", false); 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-web-security");
		
		options.addArguments("--disable-gpu");
    	options.addArguments("enable-automation");
    	options.addArguments("--headless");
    	options.addArguments("--no-proxy-server");
    	options.addArguments("--proxy-server='direct://'");
    	options.addArguments("--proxy-bypass-list=*");
		
		// Set Browser to ThreadLocalMap
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void testUntitled() {
		
		driver.get("https://www.google.com/");
	}

}
