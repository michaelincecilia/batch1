package externalFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearningDataProvider {
@DataProvider
	public String[][] testdata() throws EncryptedDocumentException, IOException{
		File file = new File("./dataExcel.xlsx");
		FileInputStream fis= new FileInputStream(file);
		Workbook wb= WorkbookFactory.create(fis);
		int noOfRow = wb.getSheet("Sheet2").getPhysicalNumberOfRows();
		int noOfCol = wb.getSheet("Sheet2").getRow(0).getPhysicalNumberOfCells();
		String[][] data= new String[noOfRow-1][noOfCol];
		for(int i=1;i<noOfRow;i++) {
			for(int j=0;j<noOfCol;j++) {
				data[i-1][j]=wb.getSheet("Sheet2").getRow(i).getCell(j).toString();
				System.out.println("sheet: "+data[i-1][j]);
			}
		}
		return data;
	}

@Test(dataProvider = "testdata")
public void register(String[] testdata) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.linkText("Register")).click();
	if(testdata[0].equalsIgnoreCase("female")) {
		driver.findElement(By.id("gender-female")).click();
	}
	else {
		driver.findElement(By.id("gender-male")).click();
	}
	driver.findElement(By.id("FirstName")).sendKeys(testdata[1]);
	driver.findElement(By.id("LastName")).sendKeys(testdata[2]);
	driver.findElement(By.id("Email")).sendKeys(testdata[3]);
	driver.findElement(By.id("Password")).sendKeys(testdata[4]);
	driver.findElement(By.id("ConfirmPassword")).sendKeys(testdata[5]);
	driver.findElement(By.id("register-button")).click();
}
}
 
