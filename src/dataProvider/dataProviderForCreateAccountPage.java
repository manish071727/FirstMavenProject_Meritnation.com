package dataProvider;

import java.io.File;

import org.testng.annotations.DataProvider;

import utility.ExcelHandler;

public class dataProviderForCreateAccountPage {


@DataProvider
public static Object[][] credentialsProvider() throws Exception{
	File location=new File("./Resource/DataProvider.xls");
	ExcelHandler excel=new ExcelHandler(location);
	excel.selectSheet("Sheet1");
	String username=excel.getCellData(2,3).getContents();
	String email=excel.getCellData(3,3).getContents();
	String password=excel.getCellData(4,3).getContents();
	String pincode=excel.getCellData(5,3).getContents();
	String mobileNumber=excel.getCellData(6,3).getContents();
	return new Object[][]{{username,email,password,pincode,mobileNumber}};
}
}