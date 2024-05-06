package TestCases;

import org.testng.annotations.Test;

import HKPages.LoginPage;
import Utils.ExcelApiTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class LoginTestcaseWithDpProvider {
	static WebDriver driver;
	static LoginPage lp;
	static HKPages.Landingpage Landingpage;
	boolean res;
	String xlFilePath = "C:\\Users\\Administrator\\Downloads\\maven.xlsx";
	String sheetName = "Sheet1";
	ExcelApiTest eat = null;

	@AfterClass
	public void closeDriver()
	{
		
		driver.quit();
	}

	@BeforeClass
	public void initDriver()
	{
		
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/login");
		lp = new LoginPage(driver);
		Landingpage = new HKPages.Landingpage(driver);  	
	}


	@Test
	public void chkTitleOfLoginPage () {
	  
	 res= lp.chkTitle("The Internet");
	  
	AssertJUnit.assertEquals(true,res);  
	}
	@Test
	public void chkToSeeIfFooterIsThere ()
	{
		
		AssertJUnit.assertEquals(true, lp.chkPageFooter());
		
	}

	@Test
	public void chkToSeePasswordMasked()
	{
		AssertJUnit.assertEquals(true, lp.isPasswordMasked());
	}
		
		@Test (dataProvider = "dp")
		   	
	  public void Login (String u , String p) {
			
			System.out.println("Username:" + u + " Password " + p);
	  
		res = u.equals("tomsmith") ? true : false;
		
		AssertJUnit.assertEquals(true,res);	
	}
		@DataProvider(name="dp")
	    public Object[][] userdata() throws Exception {
	     	Object [][] data = readfromexcel(xlFilePath, sheetName);
	          return data;
	      
	     }     
		 
	public Object[][] readfromexcel(String xlFilePath, String sheetName) throws Exception
	{
	    Object[][] excelData = null;
	    eat = new ExcelApiTest(xlFilePath);
	    int rows = eat.getRowCount(sheetName);
	    int columns = eat.getColumnCount(sheetName);
	             
	    excelData = new Object[rows-1][columns];
	     
	    for(int i=1; i<rows; i++)
	    {
	        for(int j=0; j<columns; j++)
	        {
	            excelData[i-1][j] = eat.getCellData(sheetName, j, i);
	        }
	         
	    }
	    return excelData;
	}


	}
