package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {
	
	public static String captureScreenshot(WebDriver driver,String screenshotName){
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = "./Screenshots/"+screenshotName+System.currentTimeMillis()+"png";
		try {
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture the Screenshots "+e.getMessage());
		}
		return destination;
	}

}
