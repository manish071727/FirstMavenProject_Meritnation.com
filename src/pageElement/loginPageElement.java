package pageElement;

import org.openqa.selenium.By;

public interface loginPageElement {
	By username=By.xpath("//*[@id='username_login']");
	By password=By.xpath("//*[@id='password_login']");
	By loginBtn=By.xpath("//*[@id='loginBtn_1']");
	
}
