package pageElement;

import org.openqa.selenium.By;

public interface createAccountPageElement {
	
	By userName=By.xpath(".//*[@id='username']");
	By eMail=By.xpath(".//div[3]/input[@id='userEmail']");
	By password=By.xpath(".//*[@id='userPassword']");
	By pinCode=By.xpath(".//*[@id='userPincode']");
	By countryDropdown=By.xpath(".//div[@id='countryIsdCode']");
	By countryDropdownOptions=By.xpath(".//li[@class='flagLists']/span[2]");
	By mobileNo=By.xpath(".//div[8]/input[@id='userMobile']");
	By boardDropdown=By.xpath(".//*[@id='userCurriculum']");
	//By boardDropdownOptions=By.xpath(".//*[@id='userCurriculum']/option");
	By classDropdown=By.xpath(".//*[@id='userGrade']");
	//By classDropdownoptions=By.xpath(".//div[10]/select[@id='userGrade']/option");
	By userType=By.xpath(".//div[@id='userType1']/label/span");
	By joinForFreeButton=By.xpath(".//button[@id='subBtn_0']");
	
}
