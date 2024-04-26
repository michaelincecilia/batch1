package listener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestngImplementation.class)

public class BaseClass {
public static WebDriver driver;

	@BeforeClass
	public void launch() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
}