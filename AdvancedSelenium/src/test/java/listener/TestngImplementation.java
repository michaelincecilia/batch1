package listener;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test Script Excutation stared",true);
	}
	
	//Date time colon will replace hypen for save the file
	LocalDateTime dateTime= LocalDateTime.now();
	String date= dateTime.toString().replace(":", "-");
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Script failed",true); 
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File target= new File("./"+date+"ss.png");
		try {
			FileHandler.copy(file, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Script Passed",true);
	}
}