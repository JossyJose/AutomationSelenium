package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotCapture {

	public void captureScreenShotFailures(WebDriver driver, String name) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);

		File file = new File(System.getProperty("user.dir" )+ "\\Output\\Screenshots"); 
		if (!file.exists()) {
			file.mkdirs();
		}

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		File finalDestination = new File(System.getProperty("user.dir") + "\\Output\\Screenshots" + name + timeStamp + ".png");
		FileHandler.copy(screenShot, finalDestination);
	}

}
