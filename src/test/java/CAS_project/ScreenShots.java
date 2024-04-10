package CAS_project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShots extends main {
	
	public static void captureScreen(String tname) throws IOException {
		 
		
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
               
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
       
        String targetFilePath=System.getProperty("user.dir")+"\\screenShots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);
       
        sourceFile.renameTo(targetFile);
           
//        return targetFilePath;
 
    }

}
