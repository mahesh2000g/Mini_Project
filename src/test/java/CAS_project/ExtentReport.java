package CAS_project;

import java.awt.DefaultKeyboardFocusManager;
import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver.Window;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport implements ITestListener
{
	
	
		 
		public ExtentSparkReporter sparkReporter;

		public ExtentReports extent;

		public ExtentTest test;

		String reportName;

		public void onStart(ITestContext context)

		{

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	    	reportName = "Test-Report-"+timeStamp+".html";

			sparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);

			sparkReporter.config().setDocumentTitle("One_Cognizant truetime ");

			sparkReporter.config().setReportName("One_cognizant Testing");

			sparkReporter.config().setTheme(Theme.DARK);

			extent = new ExtentReports();

			extent.attachReporter(sparkReporter);

			extent.setSystemInfo("Application", "One_Cognizant");

			extent.setSystemInfo("Module", "Tru Time");

			extent.setSystemInfo("User Name", System.getProperty("user.name"));

			extent.setSystemInfo("Environment", "QA");
			

			String browser =context.getCurrentXmlTest().getParameter("browser");

			extent.setSystemInfo("Browser", browser);

		}

		public void onTestSuccess(ITestResult result)

		{

//			test=  extent.createTest(result.getTestClass().getName());
			test=  extent.createTest(result.getName());
			
			test.assignCategory(result.getMethod().getGroups());

			test.log(Status.PASS, result.getName()+" got successfully executed");

		}

		public void onTestFailure(ITestResult result)

		{

//			test = extent.createTest(result.getTestClass().getName());
			test=  extent.createTest(result.getName());

			test.assignCategory(result.getMethod().getGroups());

			test.log(Status.FAIL,result.getName()+" got failed");

			test.log(Status.INFO,result.getThrowable().getMessage());

//			try {
//
//				String imagePath = new BaseClass().captureScreen(result.getName());
//
//				test.addScreenCaptureFromPath(imagePath);
//
//			}catch(Exception e)
//
//			{
//
//				e.printStackTrace();
//
//			}

		}

		public void onTestSkipped(ITestResult result)

		{

//			test = extent.createTest(result.getTestClass().getName());
			test=  extent.createTest(result.getName());

			test.assignCategory(result.getMethod().getGroups());

			test.log(Status.SKIP, result.getName()+" got skipped");

			test.log(Status.INFO, result.getThrowable().getMessage());

		}
		

		public void onFinish(ITestContext context)

		{

			extent.flush();
			
			
			

//			String extentReportPath = System.getProperty("user.dir")+"/reports/"+reportName;
//
//			File extentReport = new File(extentReportPath);
//
//			try 
//			{
//
//				Desktop.getDesktop().browse(extentReport.toURI());
//				Thread.sleep(3000);
//				
//				 
//
//			} 
//			catch (IOException e)
//			{
//
//				e.printStackTrace();
//
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		}



}
