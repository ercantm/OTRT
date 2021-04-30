package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Page;

public class TopMenu {
	WebDriver driver;

	public TopMenu(WebDriver driver) { //// creating consractor
		this.driver = driver;

	}

	public static By quote = By.xpath("//span[contains(text(),'Quotes')]");
	public static By manufacturer = By.xpath("//span[contains(text(),'Manufacturers')]");
	public static By fabric = By.xpath("//span[contains(text(),'Fabrics')]");

	public static By stockCurtain = By.xpath("//span[contains(text(),'Stocked Curtains')]");
	public static By tracks = By.xpath("//span[contains(text(),'Tracks')]");
	public static By hardware = By.xpath("//span[contains(text(),'Hardware')]");

	public static By curves = By.xpath("//span[contains(text(),'Curves')]");
	public static By customer = By.xpath("//span[contains(text(),'Customers')]");
	public static By user = By.xpath("//span[contains(text(),'Users')]");

	public static void gotoQuote() {
		Page.driver.findElement(quote).click();
	}

	public static void gotoManufacturer() {
		Page.driver.findElement(manufacturer).click();

	}

	public static void gotoFabrics() {
		Page.driver.findElement(fabric).click();
	}

	public static void gotoStockedCurtains() {
		Page.driver.findElement(stockCurtain).click();
	}

	public static void gotoQTracks() {
		Page.driver.findElement(tracks).click();
	}

	public static void gotoHardware() {
		Page.driver.findElement(hardware).click();
	}

	public static void gotoCurves() {
		Page.driver.findElement(curves).click();
	}

	public static void gotoCustomers() {
		Page.driver.findElement(customer).click();
	}

	public static void gotoUsers() {
		Page.driver.findElement(user).click();
	}

}
