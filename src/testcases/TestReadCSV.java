package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utility.Log;
import utility.utills;

public class TestReadCSV {

	WebDriver driver;
	
	@Test
	public void ReadCSV() {
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Log.info("打开firefox.");
		utills.getCSVTestData("TestCase1_办公用品名称");
		System.out.println(utills.getCSVTestData("TestCase1_办公用品名称"));
		Log.info("办公用品名称：" + utills.getCSVTestData("TestCase1_办公用品名称"));
		driver.quit();
	}
}
