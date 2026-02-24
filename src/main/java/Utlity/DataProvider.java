package Utlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class DataProvider 
{

	public static String filepath=System.getProperty("user.dir")+"/testdata/LoginData.xlsx";
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	@Test
	public static Map<String,String>  getemail() throws IOException
	{
		
		 Map<String, String> emailMap = new HashMap<>();
		//String filepath=System.getProperty("user.dir")+"/testdata/LoginData.xlsx";
		fis= new FileInputStream(filepath);
		workbook= new XSSFWorkbook(fis);
		sheet= workbook.getSheet("Sheet1");
		String columnName = sheet.getRow(0).getCell(0).getStringCellValue();
		int rowCount=sheet.getLastRowNum();
		
		
		for(int i=1;i<=rowCount;i++)
		{
			String key=columnName+i;
		//	System.out.println(key);
			String email = sheet.getRow(i).getCell(0).getStringCellValue();
			emailMap.put(key,email);
		}
		workbook.close();
        fis.close();
       // System.out.println(emailMap);
        return emailMap;
		
	}
	public static Map<String,String>  getpassword() throws IOException 
	{
		
		Map<String,String> passwordMap=new HashMap<>();
		fis=new FileInputStream(filepath);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("Sheet1");
		String columnName=sheet.getRow(0).getCell(1).getStringCellValue();
		int rowCount=sheet.getLastRowNum();
		for(int i=1;i<=rowCount;i++)
		{
			String key=columnName+i;
			String email = sheet.getRow(i).getCell(1).getStringCellValue();
			passwordMap.put(key, email);
		}
		workbook.close();
        fis.close();
		return passwordMap;
        
	}
	public static int getRowCount() throws IOException {

	    fis = new FileInputStream(filepath);
	    workbook = new XSSFWorkbook(fis);
	    sheet = workbook.getSheet("Sheet1");

	    int rowCount = sheet.getLastRowNum();

	    workbook.close();
	    fis.close();

	    return rowCount;
	}
	
}
