package report;

import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestScript01 {

	@Test
	public void launch() {
		WebDriver driver;
		LocalDateTime dateTime= LocalDateTime.now();
		String date = dateTime.toString().replace(":", "-");
		ScreenShot ss= new ScreenShot();
		ExtentReports reports= new ExtentReports();
		ExtentSparkReporter extentSparkReporter= new ExtentSparkReporter("./"+date+".html");
		reports.attachReporter(extentSparkReporter);
		ExtentTest test= reports.createTest("login");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		test.log(Status.INFO, "browser is maximised");
		driver.get("https://demowebshop.tricentis.com/");
		test.log(Status.INFO, "demowebshop application is launched");
		driver.findElement(By.partialLinkText("Log in")).click();
		test.log(Status.INFO, "login page is displayed");
		driver.findElement(By.id("Email")).sendKeys("bangalore541@gmail.com");
		test.log(Status.INFO, "user entered email");
		driver.findElement(By.id("Password")).sendKeys("bang123");
		test.log(Status.INFO, "user has entered password");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		test.log(Status.INFO, "user has clicked on login button");
		try {
			if(driver.findElement(By.linkText("Log out")).isDisplayed()) {
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			}
		}catch(Exception e) {
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(ss.takeScreenShot(driver)).build());
			}
		reports.flush();
		}
	
	}
