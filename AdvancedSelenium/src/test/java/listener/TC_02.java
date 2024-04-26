package listener;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_02 extends BaseClass {

	@Test
	public void register() throws InterruptedException  {
		//Register value is to pass the program - onTestSuccess method will execute
		//Reg value is to fail the program - onTestFailure method will execute
		//driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.linkText("Reg")).click();
		Thread.sleep(10000);
	}
}
