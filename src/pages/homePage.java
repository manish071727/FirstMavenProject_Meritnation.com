package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Core.ActionDriver;
import pageElement.basePageElement;
import pageElement.homePageElements;

public class homePage extends ActionDriver {

	public homePage(WebDriver abc) {
		super(abc);
		// TODO Auto-generated constructor stub
	}
	
	public homePage clickCloseLink()
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//i[@class='we_close']")));
		click(homePageElements.closeLink);
		return this;
	}
	
	public homePage getTextForUserName(){
		getText(homePageElements.studentName);
		return this;
	}
	
	public homePage clickCloseLinkTryCatch()
	{
		try{
			clickCloseLink();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			getTextForUserName();
		}
		return this;
		
	}

		
	}

