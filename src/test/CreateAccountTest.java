package test;

import org.testng.annotations.Test;

import Steps.createAccountPageSteps;
import dataProvider.dataProviderForCreateAccountPage;
import pageElement.basePageElement;
import pageElement.createAccountPageElement;
import pages.basePage;
import pages.createAccountPage;
import Core.ActionDriver;
import Core.OpenAndCloseBrowser;

public class CreateAccountTest extends OpenAndCloseBrowser {
	/*@Test //Keyword driven
  public void createAccount() {
	  ActionDriver app=new ActionDriver(driver);
	  app.navigateURL("http://www.meritnation.com");
	  app.click(basePageElement.creatAccount);
	  app.type(createAccountPageElement.userName, "Manish");
	  app.type(createAccountPageElement.eMail,"manish0727@gmail.com");
	  app.type(createAccountPageElement.password,"Manish123");
	  app.type(createAccountPageElement.pinCode, "122001");
	  app.click(createAccountPageElement.countryDropdown);
	  app.selectOptionFromdropDown(createAccountPageElement.countryDropdownOptions, "Algeria");
	  app.type(createAccountPageElement.mobileNo, "9891861167");
	  //app.click(createAccountPageElement.boardDropdown);
	  app.selectOptionFromdropDownMethod2(createAccountPageElement.boardDropdown, "Gujarat");
	  app.selectOptionFromdropDownMethod2(createAccountPageElement.classDropdown, "V");
	  
	  app.scrollDown();
	  app.checkBoxRadioButtonSelection(createAccountPageElement.userType, "Teacher");*/
	  
	/* @Test //using design pattern POM(page object model)
	 public void verify_createAccount(){
		 ActionDriver app=new ActionDriver(driver);
		 app.navigateURL("http://www.meritnation.com");
		 basePage BasePage=new basePage(driver);
		 createAccountPage CreateAccountPage=BasePage.clickcreateAccountLink();
		 CreateAccountPage.typeUsername("Manish");
		 CreateAccountPage.typeEmail("manish0727@gmail.com");
		 CreateAccountPage.typePassword("Manish123");
		 CreateAccountPage.typePinCode("122001");
		 CreateAccountPage.clickCountryDropdown();
		 CreateAccountPage.selectOptionFromCountryDropdown("Algeria");
		 CreateAccountPage.typeMobileNumber("9891861167");
		 CreateAccountPage.selectOptionFromBoardDropdown("Gujarat");
		 CreateAccountPage.selectOptionFromClassDropdown("V");
		 CreateAccountPage.scrollDown();
		 CreateAccountPage.selectUserType("Teacher");
		 
		 CreateAccountPage.allTypeFields("Manish", "manish0727@gmail.com", "Manish123", "122001", "9891861167");
		 CreateAccountPage.allDropDownFields("Algeria", "Gujarat", "V");
		 CreateAccountPage.scrollDown();
		 CreateAccountPage.allSelectAndCheckboxOptions("Teacher");	 
		 */
	//@Test(dataProviderClass=DataProviderForLoginPage.class,dataProvider="credentialsProvider")
	
	
	/*	 @Test(description="1.Type valid entries in text boxes<br>2.Veirfy the title<br>",dataProviderClass=dataProviderForCreateAccountPage.class,dataProvider="credentialsProvider")
			public void createAccount(String username,String email,String password,String pincode, String mobileNumber) throws Exception{
				ActionDriver app=new ActionDriver(getDriver());
				app.navigateURL("http://www.meritnation.com");
				basePage BasePage=new basePage(getDriver());
				createAccountPage CreateAccountPage=BasePage.clickcreateAccountLink();
				 CreateAccountPage.allTypeFields(username,email,password,pincode,mobileNumber);
				 //CreateAccountPage.allDropDownFields("Algeria", "Gujarat", "V");
				 //CreateAccountPage.scrollDown();
				 CreateAccountPage.allSelectAndCheckboxOptions("Teacher");
				 CreateAccountPage.verifyTitle("Meritnation: The     No.1 Education Site with Study Material & Live Classes for CBSE, ICSE, CPT, IITJEE, AIPMT & more");
				 
			}*/

		 
		 @Test(description=createAccountPageSteps.stepsForCreateAccount,dataProviderClass=dataProviderForCreateAccountPage.class,dataProvider="credentialsProvider")
			public void createAccount(String username,String email,String password,String pincode, String mobileNumber) throws Exception{
				ActionDriver app=new ActionDriver(getDriver());
				app.navigateURL("http://www.meritnation.com");
				basePage BasePage=new basePage(getDriver());
				createAccountPage CreateAccountPage=BasePage.clickcreateAccountLink();
				 CreateAccountPage.allTypeFields(username,email,password,pincode,mobileNumber);
				 //CreateAccountPage.allDropDownFields("Algeria", "Gujarat", "V");
				 //CreateAccountPage.scrollDown();
				 CreateAccountPage.allSelectAndCheckboxOptions("Teacher");
				 CreateAccountPage.verifyTitle("Meritnation: The     No.1 Education Site with Study Material & Live Classes for CBSE, ICSE, CPT, IITJEE, AIPMT & more");
				 
			}
  }

