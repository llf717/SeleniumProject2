package utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class utills {

	public static WebDriver driver; //静态变量：类初始化时，就需要给该变量赋值

	/**
	 * This method implements how to switch window.
	 * @author liulf
	 * @param cwindow
	 */
	
	
	public static void switchWindow(String cwindow) {
		Set<String> allhandles = driver.getWindowHandles();
		Iterator<String> its = allhandles.iterator();
        while (its.hasNext()) {
            String cuwhdle = its.next();
            if (!cuwhdle.equals(cwindow)) { //窗口句柄不等于原来的窗口句柄
                driver.switchTo().window(cuwhdle);
                break;
            }
        }
	}
	
	public static String getTestData(String key) {
		ExcelData.setPath(Contants.filepath + Contants.filename, Contants.sheetname);
		int rowNum = ExcelData.getRowContains(key, Contants.keycolumn);
		String cellValue = ExcelData.getCellData(rowNum, Contants.column);
		return cellValue;
	}
	
	public static String getCSVTestData(String key) {
		String value = null;
		for(String[] row:ExcelData.getLocatorsFromObjectsFile()) {
			if(row[0].equalsIgnoreCase(key)) {
				value = row[1];
			}
		}
		return value;
		
	}
}
