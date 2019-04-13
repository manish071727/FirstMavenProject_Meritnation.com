package dataProvider;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;

public class dataProviderForLogin {

	@DataProvider
	//To read data from excel from column and rows both
	public static Object[][] getLoginCredentials() throws BiffException, IOException{
		File location=new File("./Resource/LoginCredentials.xls");
		Workbook excel=Workbook.getWorkbook(location);
		Sheet sheet=excel.getSheet("Sheet1");
		int colLength=sheet.getColumns();
		int rowLength=sheet.getRows();
		Object[][] obj=new Object[rowLength][colLength];
		for(int i=0;i<rowLength;i++){
			for(int k=0;k<colLength;k++){
				obj[i][k]=sheet.getCell(k,i).getContents();
			}
		}
			return obj;

			}
		
}
