package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utility.Log;


public class test1 {
	
	WebDriver driver;

	@Test
	public void testa(){
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Log.info("Firefox is open");
		driver.get("http://www.baidu.com");
		Log.info("Baidu page is open");
		driver.quit();
	}
}
