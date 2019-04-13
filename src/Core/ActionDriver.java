package Core;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActionDriver {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected WebDriver driver;
	WebDriverWait wait;
	long smallWait=20;
	long longWait=60;
	long extendedWait=120;
	
	public ActionDriver(WebDriver abc) {
		this.driver=abc;
	}
	public void navigateURL(String baseURL){
		LOGGER.info("Navigating to: "+baseURL);
		driver.get(baseURL);
	}
	
	public void waitForElement(By loc){
		LOGGER.info("Waiting for element: "+loc);
		wait=new WebDriverWait(driver,smallWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
	}
	
	protected void click(By loc){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		WebElement element=driver.findElement(loc);
		LOGGER.info("clicking on the element: "+loc);
		element.click();
	}
	protected void type(By loc,String value){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		WebElement element=driver.findElement(loc);
		LOGGER.info("typing in element: "+loc);
		element.sendKeys(value);
	}
	protected void navigateForward(){	
		driver.navigate().forward();
		LOGGER.info("navigated forward");
	}
	protected void navigateBackwaryd(){
		driver.navigate().back();
		LOGGER.info("navigated backward");
	}
	protected void pageRefresh(){
		driver.navigate().refresh();
		LOGGER.info("page refreshed");
	}
	
	protected String getText(By loc){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		WebElement element=driver.findElement(loc);
		LOGGER.info("Text is: "+ element.getText());
		return element.getText();
	}
	
	protected void selectOptionFromdropDown(By loc,String str){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		List<WebElement> options=driver.findElements(loc);
		for(WebElement value:options){
			if(value.getText().equalsIgnoreCase(str)){	
				LOGGER.info("String value found: "+str);
				//waitForElement(loc);
				value.click();
				LOGGER.info("Value is selected: "+str);
				//Thread.sleep(20000);
				break;
			}
		}
	}
	protected void selectOptionFromdropDownMethod2(By loc,String value){
			waitForElement(loc);
			LOGGER.info("element found: "+loc);
			driver.findElement(loc);
			Select slt=new Select(driver.findElement(loc));
			slt.selectByVisibleText(value);
			LOGGER.info("Value is selected: "+value);
			}
		
	protected void checkBoxRadioButtonSelection(By loc, String str){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		driver.findElement(loc);
		List<WebElement> options=driver.findElements(loc);
		for(WebElement value:options){
			if(value.getText().equalsIgnoreCase(str)){	
				waitForElement(loc);
				value.click();
				LOGGER.info("Value is selected: "+str);
				//Thread.sleep(20000);
				break;
			}
		}
	} 
	public void scrollDown(){
		//waitForElement(loc);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		LOGGER.info("page is scrolled down");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	protected boolean IsElementPresent(By loc){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		WebElement element=driver.findElement(loc);
		LOGGER.info("Verifying if element is enabled");
		return element.isEnabled();
	}
	
	protected String getTitle(){
		return driver.getTitle();
		
	}
	
	protected boolean textIsEqualTo(By loc,String value){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		WebElement element=driver.findElement(loc);
		LOGGER.info("Verifying if text is equal to expected value");
		return element.getText().equals(value);
	}
	
	protected void slider(By loc, By loc1,String RequiredValue){
		waitForElement(loc);
		LOGGER.info("element found: "+loc);
		WebElement pointer=driver.findElement(loc);
		pointer.getLocation();
		LOGGER.info("current pointer location is: "+pointer.getLocation());
		Actions act=new Actions(driver);
		waitForElement(loc1);
		LOGGER.info("element found: "+loc1);
		WebElement currentSelectedValue=driver.findElement(loc1);
		String str1=currentSelectedValue.getAttribute("value");
		System.out.println("Current selected value of pointer is: "+ str1);
		String newStr1=str1.replaceAll(",", "");
		  int a=Integer.parseInt(newStr1);
		  String str2=RequiredValue;
		  String newStr2=str2.replaceAll(",", "");
		  int b=Integer.parseInt(newStr2);
		  for(int m=1;m<400;m++){	  
			  String str3=currentSelectedValue.getAttribute("value");
			  String newStr3=str3.replaceAll(",", "");
			  int c=Integer.parseInt(newStr3);
			  if(c>=b){

	                   break;
			  }
			  else{
				  act.dragAndDropBy(pointer, m, 0).perform();	  
			  }
			  LOGGER.info("pointer reached to required location");
			  }
	  
	}
	  
	  protected void dragAndDrop(By loc, By loc1){
		  waitForElement(loc);
		  LOGGER.info("element found: "+loc);
		  WebElement source=driver.findElement(loc);  
		  Actions act=new Actions(driver);
	      act.moveToElement(source).perform();
	      LOGGER.info("move to Source element");
	      waitForElement(loc1);
	      WebElement target=driver.findElement(loc1);
		  act.dragAndDrop(source, target).build().perform();
		  LOGGER.info("Source element moved to target");
	  }
	  
	  protected void frameSwitching(By loc){
		  waitForElement(loc);
		  LOGGER.info("element found: "+loc);
		  driver.findElement(loc);
		 // driver.switchTo().frame(0); //By index
		 // driver.switchTo().frame("frame Name"); //By frame name
		  driver.switchTo().frame(driver.findElement(loc));//By xpath
		  LOGGER.info("Switched to desired frame");
	  }
	  
	  protected void JsAlert(By loc){
		  waitForElement(loc);
		  driver.findElement(loc).click();
		  Alert alt=driver.switchTo().alert();
		  alt.accept();
		  //alt.dismiss();//to click on the cancel button
		  //alt.sendKeys("");//in case of prompt alert		  
	  }
	  
	  protected void SwitchToChildWindow(String title){
		  String parentWin=driver.getWindowHandle();
		  Set<String> allWin=driver.getWindowHandles();
		  for(String childWin:allWin){
			  if(!childWin.equals(parentWin) && driver.switchTo().window(childWin).getTitle().equals(title)){
				  driver.switchTo().window(childWin);
				  System.out.println(driver.switchTo().window(childWin).getTitle());				  
			}
		}
		  assert driver.getTitle().equals(title) : "Title for Child window does not match";
	  }
	  
	  protected void switchBackToParentWindow(String title){
		  String parentWin=driver.getWindowHandle();
			driver.switchTo().window(parentWin);
			assert driver.getTitle().equals(title):"Fail to switch on parent window";		
		}
	  protected void focusOnCurrentTab(String title){
		  driver.switchTo().defaultContent();
		  assert driver.getTitle().equals(title):"title did not match and required page not found";
	  }
	  
	  protected void verifyErrorMessageMethod1(By loc, String ExpectedErrorMessage){
		  waitForElement(loc);
		  WebElement erroeMsg=driver.findElement(loc);
		  Assert.assertEquals(erroeMsg.getText(), ExpectedErrorMessage);	  
	  }
	  protected void verifyErrorMessageMethod2(String ExpectedErrorMessage){
		  String errorMessage=driver.getPageSource();
		  assert errorMessage.contains(ExpectedErrorMessage):"Not getting expected error message";
		  
	  }
	  protected void verifyErrorMessageMethod3(String ExpectedErrorMessage){
		  WebElement errorMessage=driver.findElement(By.tagName("body"));
		  assert errorMessage.getText().contains(ExpectedErrorMessage):"Not getting expected error message";
		  
	  }
	 protected void mousehoverAndSingleClick(By loc, By loc1){
		driver.findElement(loc);
		driver.findElement(loc1);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(loc)).perform();
		act.click(driver.findElement(loc1)).perform();
		//driver.findElement(loc1).click();
			 
	 }
	 
	 protected void mousehoverAndDoubleClick(By loc, By loc1){
		driver.findElement(loc);
		driver.findElement(loc1);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(loc)).perform();
		act.doubleClick(driver.findElement(loc1)).perform();
			 
	 }
	  
}


