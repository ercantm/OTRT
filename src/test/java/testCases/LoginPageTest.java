package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Page;
import pages.action.LoginPage;
import utilities.TestUtil;

public class LoginPageTest extends Page {
	
	
	@BeforeMethod
	public void setUp(){
		
		Page.initConfiguration();
	}
	
	
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void loginPageTest(Hashtable<String, String> data) {
		if (data.get("runmode").equalsIgnoreCase("N")) {

			throw new SkipException("Skipping the test as the Run mode is NO");

		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LoginPage lp = new LoginPage();
		lp.enterFaceBook(data.get("email"), data.get("password"));

	}

	@AfterMethod
	public void tearDown() {
		if (Page.driver != null) {
			Page.quitBrowser();
		}
	}

//	@AfterMethod
//	
//	public void tearDown(){
//		if(TestBase.driver!=null){
//		TestBase.quitBrowser();
//		}
	// }

}
