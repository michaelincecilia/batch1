package batchExe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LanchNyk {
	@Test 
	public void nyka() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://nykafashion.com/");
		driver.quit();
	}

}
