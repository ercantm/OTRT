package pages.action;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Page;
import errorcollectors.ErrorCollector;
import pages.locators.LoginPageLocator;

public class LoginPage extends Page {
	LoginPageLocator login;

	public LoginPage() {
		this.login = new LoginPageLocator();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(Page.driver, 20);
		PageFactory.initElements(factory, this.login);
	}

	public void enterFaceBook(String email, String pass) {

		type(login.email, email);
		// login.email.sendKeys(email);
		type(login.password, pass);
		click(login.signup);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ErrorCollector.verifyTrue(isElementPresent(login.verify));
		
	}

}
