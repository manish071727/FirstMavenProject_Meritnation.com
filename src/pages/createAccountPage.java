package pages;

import org.openqa.selenium.WebDriver;

import pageElement.basePageElement;
import pageElement.createAccountPageElement;
import Core.ActionDriver;



public class createAccountPage extends ActionDriver{

	public createAccountPage(WebDriver abc) {
		super(abc);
		
	}
	
	public void joinForFreeButtonPresent() throws Exception{
		if(!IsElementPresent(createAccountPageElement.joinForFreeButton)){
			throw new Exception("This is not a createAccountPage and the page is: "+getTitle());
	}
	}
	public createAccountPage typeUsername(String username){
		type(createAccountPageElement.userName,username);
		return this;
	}
	public createAccountPage typeEmail(String email){
		type(createAccountPageElement.eMail,email);
		return this;
	}
	
	public createAccountPage typePassword(String password){
		type(createAccountPageElement.password,password);
		return this;
	}
	public createAccountPage typePinCode(String pincode){
		type(createAccountPageElement.pinCode,pincode);
		return this;
	}
	public createAccountPage clickCountryDropdown(){
		click(createAccountPageElement.countryDropdown);
		return this;
	}
	public createAccountPage selectOptionFromCountryDropdown(String country){
		selectOptionFromdropDown(createAccountPageElement.countryDropdownOptions,country);
		return this;
	}
	public createAccountPage typeMobileNumber(String mobileNumber){
		type(createAccountPageElement.mobileNo,mobileNumber);
		return this;
	}
	public createAccountPage selectOptionFromBoardDropdown(String board){
		selectOptionFromdropDownMethod2(createAccountPageElement.boardDropdown,board);
		return this;
	}
	public createAccountPage selectOptionFromClassDropdown(String classNumber){
		selectOptionFromdropDownMethod2(createAccountPageElement.classDropdown,classNumber);
		return this;
	}
	public createAccountPage selectUserType(String usertype){
		checkBoxRadioButtonSelection(createAccountPageElement.userType,usertype);
		return this;
	}
	
	public createAccountPage allTypeFields(String username,String email,String password,String pincode,String mobileNumber){
		type(createAccountPageElement.userName,username);
		type(createAccountPageElement.eMail,email);
		type(createAccountPageElement.password,password);
		type(createAccountPageElement.pinCode,pincode);
		type(createAccountPageElement.mobileNo,mobileNumber);
		return this;
	}
	
	public createAccountPage allDropDownFields(String country, String board,String classNumber){
		click(createAccountPageElement.countryDropdown);
		selectOptionFromdropDown(createAccountPageElement.countryDropdownOptions,country);
		selectOptionFromdropDownMethod2(createAccountPageElement.boardDropdown,board);
		selectOptionFromdropDownMethod2(createAccountPageElement.classDropdown,classNumber);
		return this;
	}
	
	public createAccountPage allSelectAndCheckboxOptions(String usertype){
		checkBoxRadioButtonSelection(createAccountPageElement.userType,usertype);
		return this;
	}
	
	public void verifyTitle(String vlaue){
		assert driver.getTitle().equalsIgnoreCase(vlaue):"Title does not match";
	}
	
}
