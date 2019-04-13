package Core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utility.MyLogger;

public class OpenAndCloseBrowser {
	
	//protected static WebDriver driver;
	static ThreadLocal<WebDriver> driver;
	DesiredCapabilities caps;
	@BeforeSuite
	public void initializeDriver(){
		driver=new ThreadLocal<WebDriver>();
		 try {
		      MyLogger.setup();
		    } catch (IOException e) {
		      e.printStackTrace();
		      throw new RuntimeException("Problems with creating the log files");
		 }
	}
	@Parameters({"browser","grid"})
	@BeforeMethod
	public void openBrowser(String browser,String grid) throws MalformedURLException{
		if(grid.equals("yes")){
		if(browser.equalsIgnoreCase("firefox")){
			caps=DesiredCapabilities.firefox();
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			caps=DesiredCapabilities.chrome();
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
		}
		else{
			caps=DesiredCapabilities.firefox();
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		
		}
		}
		else{
		if(browser.equalsIgnoreCase("firefox")){
			driver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver.set(new InternetExplorerDriver(caps));
		}
		else{
			driver.set(new FirefoxDriver());	
		}
		}
		getDriver().manage().window().maximize();
	}
	public static WebDriver getDriver(){
		return driver.get();
	}
	@AfterMethod
	public void closeBrowser(){
		getDriver().quit();
	}

}
