package pages;

import org.openqa.selenium.WebDriver;

import pageElement.basePageElement;
import pageElement.loginPageElement;
import Core.ActionDriver;

public class loginPage extends ActionDriver {

	public loginPage(WebDriver abc) {
		super(abc);
		
	}
	
    public void enterUserName(String userName){
    	type(loginPageElement.username, userName);
		
	}
    
    public void enterPassword(String password){
    	type(loginPageElement.password, password);
		
	}
    public homePage clickLoginBtn(){
    	click(loginPageElement.loginBtn);
		return new homePage(driver);
	}

	}


