package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;




import pageElement.basePageElement;
import pageElement.loginPageElement;
//import pageElement.BasePageElement;
//import pageElement.LoginPageElement;
import Core.ActionDriver;
import Core.OpenAndCloseBrowser;

public class LoginPageTest extends OpenAndCloseBrowser {
	@Test
	public void browserTest(){
		ActionDriver app=new ActionDriver(getDriver());
/*		app.navigateURL("http://www.meritnation.com");
		app.click(basePageElement.loginLink);
		app.type(loginPageElement.username, "sunaina@test.com");
		app.type(loginPageElement.password, "12345678");
		app.click(loginPageElement.loginBtn);*/

	}

}
