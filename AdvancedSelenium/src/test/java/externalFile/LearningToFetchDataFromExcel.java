package externalFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearningToFetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//dataExcel.xlsx is a file with below value in 4th row and 2nd col
		//https://demowebshop.tricentis.com/
		//wb.getSheet("Sheet1").getRow(4).getCell(2).getStringCellValue(); will give the above value
		
		//1)create a file
		File file= new File("./dataExcel.xlsx");
		
		//2)create a FileInputStream
		FileInputStream fis=new FileInputStream(file);
		
		//3)Create a object for Workbook
		Workbook wb= WorkbookFactory.create(fis);
		
		
		String Url = wb.getSheet("Sheet1").getRow(4).getCell(2).getStringCellValue();
		System.out.println(Url);
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		//The program will wait 5 sec
		Thread.sleep(5000);
		//After 5 sec, screen will close automatically
		driver.quit();
	}
}