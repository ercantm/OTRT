package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.TopMenu;
//import pages.TopMenu;
import utilities.ExcelReader;
import utilities.ExtentManager;

public class Page {

	/*
	 * WebDriver
	 * 
	 * ExcelReader Logs WebDriverWait ExtentReports
	 * 
	 * 
	 * 
	 */
	public static TopMenu menu;
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader("C:\\Users\\ercan\\Documents\\workspaces\\eclipse-ide-for-java-developers\\Facebook\\src\\test\\resources\\excel\\data.xlsx");
			
			
			
			//"user.dir") + "\\src\\test\\resources\\excel\\data.xlsx", "Test_suite");
			// 
			
	
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;

	public static void initConfiguration() {

		if (System.getenv("browser") != null && (!System.getenv("browser").isEmpty())) {
			browser = System.getenv("browser");

		}

		else {
			browser = Constants.browser;
		}

		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxProfile customProfile = new FirefoxProfile();
			customProfile.setPreference("dom.disable_beforeunload", true);
			// customProfile.set_preference("dom.disable_open_during_load", False);
			driver = new FirefoxDriver((Capabilities) customProfile);
			// driver = new FirefoxDriver();
			log.debug(" firefox starting");
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			log.debug(" Crome is  starting");
		} else if (browser.equals("ie")) {

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			WebDriverManager.iedriver().setup();
			// System.setProperty("webdriver.ie.driver",
			// "C:\\Users\\ercan\\Driver\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			log.debug(" Internet Explorer  starting");
		}

		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		/*
		 * driver.manage().timeouts().implicitlyWait(Constants.implicitwait,
		 * TimeUnit.SECONDS); wait = new WebDriverWait()
		 */
		menu = new TopMenu(driver);

	}

	public static void click(WebElement element) {

		element.click();
		log.debug("Clicking on an Element : " + element);
		test.log(LogStatus.INFO, "Clicking on : " + element);
	}

	public static void type(WebElement element, String value) {

		element.sendKeys(value);

		log.debug("Typing in an Element : " + element + " entered value as : " + value);

		test.log(LogStatus.INFO, "Typing in : " + element + " entered value as " + value);

	}

	public static boolean isElementPresent(WebElement element) {
		log.debug("waiting enable of an Element : " + element);
		test.log(LogStatus.INFO, "waiting  in this  : " + element + " elemet to be peresent   ");
		Reporter.log("waiting  in this  : " + element + " elemet to be peresent   ");
		try {

			element.isDisplayed();
			return true;

		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static void select(WebElement element, String text) {
		test.log(LogStatus.INFO, "selecting  in this  : " + element.toString() + "  enter value as the " + text);
		Reporter.log("selecting in this : " + element.toString() + " enter value as the " + text);
		log.debug("selecting Element : " + element + " choosing  value as : " + text);
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public static void selectbyIndex(WebElement element, int text) {
		test.log(LogStatus.INFO,
				"selecting  in this  : " + element.toString() + "  enter index number  as the " + text);
		Reporter.log("selecting in this : " + element.toString() + " enter index number  as the " + text);
		log.debug("selecting Element : " + element + " choosing  value as : " + text);
		Select select = new Select(element);
		select.selectByIndex(text);

	}

	public static void selectbyValue(WebElement element, String text) {
		test.log(LogStatus.INFO,
				"selecting  in this  : " + element.toString() + "  enter index number  as the " + text);
		Reporter.log("selecting in this : " + element.toString() + " enter index number  as the " + text);
		log.debug("selecting Element : " + element + " choosing  value as : " + text);
		Select select = new Select(element);
		select.selectByValue(text);

	}

	public static void quitBrowser() {

		driver.quit();

	}

}
