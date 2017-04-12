package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility.ExcelData;
import utility.Log;

public class CreateSupplyRegisterRecord {

	WebDriver driver;
	
	@Test
	public void CreateRegister() throws InterruptedException {
		driver = new FirefoxDriver();
		Log.info("打开firefox");
		driver.manage().window().maximize();
		Log.info("最大化窗口");
		driver.get(ExcelData.getMapData("open url"));
		Log.info("打开系统首页");
		driver.findElement(By.name("account")).sendKeys(ExcelData.getMapData("valid_username"));
		Log.info("输入用户名");
		driver.findElement(By.name("password")).sendKeys(ExcelData.getMapData("valid_password"));
		Log.info("输入密码");
		driver.findElement(By.xpath("//div[@id='submit']")).click();
		Log.info("点击登录按钮");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='行政办公']")).click();
		Log.info("点击 行政办公");   
		driver.findElement(By.xpath("//*[@id='m09']/ul/li[1]/div[1]")).click();
		Log.info("点击 办公用品");
		driver.findElement(By.xpath("//*[@id='m09']/ul/li[1]/div[2]/ul/li[3]")).click();
		Log.info("点击 办公用品登记");
		driver.switchTo().frame("context");
		Log.info("切换frame");
		driver.findElement(By.xpath("//*[text()='新增登记']")).click();
		Log.info("点击 新增登记 按钮");
		System.out.println("登记类型=" + ExcelData.getMapData("TestCase2_登记类型"));
		driver.findElement(By.id(ExcelData.getMapData("TestCase2_登记类型"))).click();
		Log.info("点击 登记类型-采购入库");
		Select select = new Select(driver.findElement(By.id("_8_")));
		select.selectByValue(ExcelData.getMapData("TestCase2_办公用品"));
		Log.info("办公用品 选择-马克杯");
		driver.findElement(By.name("trans_qty")).sendKeys(ExcelData.getMapData("TestCase2_数量"));
		Log.info("输入 数量");
		driver.findElement(By.name("price")).sendKeys(ExcelData.getMapData("TestCase2_单价"));
		Log.info("输入 单价");
		driver.findElement(By.name("remark")).sendKeys(ExcelData.getMapData("TestCase2_登记备注"));
		Log.info("输入 登记备注");
		driver.quit();
		Log.info("退出浏览器");
	}
}
