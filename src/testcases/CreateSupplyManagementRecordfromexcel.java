package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utility.ExcelData;
import utility.Log;
import utility.utills;

public class CreateSupplyManagementRecordfromexcel {
	
	WebDriver driver;

	@Test
	public void createSupply() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(utills.getTestData("open url"));
		Log.info("打开系统首页");
//		driver.findElement(By.name("account")).sendKeys(utills.getTestData("valid_username"));
		driver.findElement(By.name("account")).sendKeys(ExcelData.getMapData("valid_username"));
		Log.info("输入用户名");
		driver.findElement(By.name("password")).sendKeys(utills.getTestData("valid_password"));
		Log.info("输入密码");
		driver.findElement(By.xpath("//div[@id='submit']")).click();
		Log.info("点击登录");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='行政办公']")).click();
//		driver.findElement(By.xpath(".//*[@id='r1']/ul/li[5]/table/tbody/tr/td[2]")).click();
		Log.info("点击 行政办公");      
		driver.findElement(By.xpath("//*[@id='m09']/ul/li[1]/div[1]")).click();
		Log.info("点击 办公用品");
		driver.findElement(By.xpath("//*[@id='m09']/ul/li[1]/div[2]/ul/li[4]/span")).click();
		Log.info("点击 办公用品管理");
		driver.switchTo().frame("context");
		driver.findElement(By.xpath("//div[@class='wrapper']/div[2]/span[1]")).click();
		Log.info("点击 新增按钮");
		driver.findElement(By.name("pro_name")).sendKeys(utills.getTestData("TestCase1_办公用品名称"));
		Log.info("输入办公用品名称");
		driver.findElement(By.name("pro_unit")).sendKeys(utills.getTestData("TestCase1_计量单位"));
		Log.info("输入计量单位");
		Select se = new Select(driver.findElement(By.id("_3_")));
		se.selectByVisibleText("书写修正");
		Log.info("选择 办公用品类型");
		driver.findElement(By.name("pro_supplier")).sendKeys(utills.getTestData("TestCase1_供应商"));
		Log.info("输入供应商");
		driver.findElement(By.name("pro_stock")).sendKeys("20");
		Log.info("输入当前库存");
		driver.findElement(By.name("pro_lowstock")).sendKeys("5");
		Log.info("输入警戒库存");
		driver.findElement(By.name("pro_desc")).sendKeys("办公用品描述信息");
		Log.info("输入办公用品描述");
		driver.findElement(By.xpath("//*[@id='_4_']/div[1]/span[1]")).click();
		Log.info("点击 管理人员 添加按钮");
		String oriwhandle = driver.getWindowHandle();
		utills.driver = driver;
		//静态方法不需要实例化，可以直接使用
		utills.switchWindow(oriwhandle);
//		switchWindow(oriwhandle);
        Log.info("切换到人员选择窗口");
        driver.switchTo().frame("right");
		driver.findElement(By.xpath("//*[@id='admin']/td/span")).click();
		driver.close();
		Log.info("添加管理人员");		
		driver.switchTo().window(oriwhandle);
		Log.info("切换到原来窗口");
		driver.switchTo().frame("context");
		driver.findElement(By.xpath("//*[@id='_5_']/div[1]/span[1]")).click();
		Log.info("点击 归属部门 添加按钮");
		utills.switchWindow(oriwhandle);
//		switchWindow(oriwhandle);
		Log.info("切换到添加归属部门窗口");
		driver.switchTo().frame("head");
		driver.findElement(By.linkText("总经理室")).click();
		driver.close();
		Log.info("添加归属部门");
		driver.switchTo().window(oriwhandle);
		Log.info("切换到原来窗口");
		driver.switchTo().frame("context");
		driver.findElement(By.xpath("//div[@class='wrapper']/div[2]/span[1]")).click();
		Log.info("点击 保存按钮");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id='r3']/span[4]")).click();
		Log.info("点击 退出");
		driver.quit();
	}
	
//	public void switchWindow(String cwindow) {
//		Set<String> allhandles = driver.getWindowHandles();
//		Iterator<String> its = allhandles.iterator();
//        while (its.hasNext()) {
//            String cuwhdle = its.next();
//            if (!cuwhdle.equals(cwindow)) { //窗口句柄不等于原来的窗口句柄
//                driver.switchTo().window(cuwhdle);
//                break;
//            }
//        }
//	}
	
}
