package test;

import org.testng.annotations.Test;

import dataProvider.dataProviderForLogin;
import pages.basePage;
import pages.homePage;
import pages.loginPage;
import Core.ActionDriver;
import Core.OpenAndCloseBrowser;

public class LoginPageTestWithPOM extends OpenAndCloseBrowser {
	@Test(dataProviderClass=dataProviderForLogin.class,dataProvider="getLoginCredentials")
	public void LoginToSite(String userName, String Password) throws InterruptedException{
		ActionDriver app=new ActionDriver(getDriver());
		app.navigateURL("http://www.meritnation.com");
		basePage BasePage=new basePage(getDriver());
		loginPage LoginPage=BasePage.clickLoginLink();
		LoginPage.enterUserName(userName);
		LoginPage.enterPassword(Password);
		homePage HomePage=LoginPage.clickLoginBtn();
		Thread.sleep(2000);
		HomePage.clickCloseLinkTryCatch();
		//HomePage.getTextForUserName();
		
		
}
}
