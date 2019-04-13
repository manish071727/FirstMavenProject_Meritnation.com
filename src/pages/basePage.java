package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageElement.basePageElement;
import Core.ActionDriver;

public class basePage extends ActionDriver {

	public basePage(WebDriver abc) {
		super(abc);
		
	}
	
	public void createAccountLinkPresent() throws Exception{
		if(!IsElementPresent(basePageElement.creatAccount)){
			throw new Exception("This is not a meritnation base page and the page is: "+getTitle());
	}
	}
		public createAccountPage clickcreateAccountLink(){
			click(basePageElement.creatAccount);
			return new createAccountPage(driver);
		}
		
		public boolean loginLinkPresent(){
			if(!IsElementPresent(basePageElement.loginLink)){
				LOGGER.info("This is not a meritnation base page and the page is: "+getTitle());
				return false;
			}
			else{
				return true;
			}
		}
		
		public loginPage clickLoginLink(){
			click(basePageElement.loginLink);
			return new loginPage(driver);
	}
}

