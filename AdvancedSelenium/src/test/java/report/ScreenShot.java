package report;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import freemarker.core.ReturnInstruction.Return;

public class ScreenShot {

	public String takeScreenShot(WebDriver driver) {
		LocalDateTime dateTime= LocalDateTime.now();
		String date = dateTime.toString().replace(":", "-");
		String ScreenShotPath = "./screenShot/"+date+".png";
		TakesScreenshot ts= (TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		File trg= new File(ScreenShotPath);
		try {
			FileHandler.copy(scr, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return "." + ScreenShotPath;
	}
}
