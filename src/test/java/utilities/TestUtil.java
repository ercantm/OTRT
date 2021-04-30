package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.Page;

public class TestUtil extends Page {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
		
		System.out.println("method name: " + m.getName());
		
		String sheetName = m.getName();
		
		int rows = excel.getRowCount(sheetName);
		System.out.println("rows is: " + rows);
		System.out.println("get Row Count is running!");
		
		int cols = excel.getColumnCount(sheetName);
		System.out.println("cols is: " + cols);
		System.out.println("get Row Column is running!");
		
		Object[][] data = new Object[rows - 1][1];
		
		Hashtable<String,String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String,String>();
			System.out.println("First For Loop");
			
			for (int colNum = 0; colNum < cols; colNum++) {
			System.out.println("Second For Loop");
				// data[0][0]
				table.put(excel.getCellData( m.getName(),colNum, 1), excel.getCellData( m.getName(),colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName="test_suite";
		System.out.println("Test Runnable is running!");
		int rows = excel.getColumnCount(sheetName);
		for(int rNum=2; rNum<=rows; rNum++){
			
String testCase = excel.getCellData(sheetName, "TCID", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);
				System.out.println(runmode);
				if(runmode.equalsIgnoreCase("Y"))
					
					return true;
				else if(runmode.equalsIgnoreCase("N")){
					return false;}
			}
			
			
		}
		return false;
	}
	
}

