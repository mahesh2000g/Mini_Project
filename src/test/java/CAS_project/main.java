package CAS_project;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;






public class main 
{
	
	static WebDriver driver;
	static SimpleDateFormat formatter_day ,formatter_year  , having_date , converting_date ,  SYS_date , same_formate;
	static Date date = new Date(System.currentTimeMillis());
	static Date date2 = new Date(System.currentTimeMillis());
	static LocalDate minus_date , loc_date;
	static Actions act;
	static String act_date1 ,act_date2, parent ,child , text;
	public SoftAssert sa = new SoftAssert();
//	public Logger logger;
	
	
	
	
	
	
			
	@Parameters({"browser" , "url"})
	        @BeforeClass(groups = {"first"})
//	        @BeforeClass
			public void setUp(String brw , String url)
			{
//	        	logger = LogManager.getLogger(this.getClass());
	        	if(brw.equalsIgnoreCase("chrome"))
	        	{
				driver=new ChromeDriver();
	        	}
	        	else if(brw.equalsIgnoreCase("edge"))
	        	{
	        		driver=new EdgeDriver();
	        	}
	        	
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize();
			
				
				
			 
				//home page set up.............................................................
				System.out.println("\n"+"home page set up.............................................................");
				driver.get(url);
				
//				logger.debug("*******home page*******************");
				 text = driver.getTitle();
				System.out.println(text);
				
				
//				Assert.assertEquals(text, "Be.Cognizant - Home" , "HomePage title is wrong");
//				Assert.assertTrue(text.contains("Homee") , "HomePage title is wrong");
				sa.assertTrue(text.contains("Home") , "HomePage title is wrong");
				
				System.out.println("testing is continuing");
				
			}
				
				
				
			@Test(priority=2 ,groups= {"first"})
//			@Test(priority=2 )
			public void ClickOneCognzt()
			{
				//switching to one cognizant  page set up.............................................................
		
				try 
				{
					new ScreenShots().captureScreen("Home Page");
				}
				catch 
				(IOException e) 
				{
					System.out.println(e);
				}
				driver.findElement(By.xpath("//a[@href='https://onecognizant.cognizant.com/Home?GlobalAppId=926']")).click();
				
			}
				
				
			@Test(priority=3, dependsOnMethods = {"ClickOneCognzt"},groups= {"first"})
//			@Test(priority=3, dependsOnMethods = {"ClickOneCognzt"})
			 public void SwitchingHandel()
			{
				
				//getting handels of windows set up.............................................................
		
				Set<String> handles = driver.getWindowHandles();
				
				List<String> list_handels = new ArrayList<String>(handles);
				
				 parent = list_handels.get(0);
				 child =list_handels.get(1);
				
				
				
				
				
				//switching to one cogzt window set up.............................................................
		
				driver.switchTo().window(child);
			}	
				
			@Test(priority=4,groups= {"first"})
//			@Test(priority=4)
			 public void SearchTruTume() throws IOException
			{
				
				//search and select option  set up.............................................................
		//		Actions act = new Actions(driver);
		//		WebElement common =driver.findElement(By.xpath("//*[@id=\"cogNewsID\"]/div[4]/div"));
		//		act.contextClick(common).perform();
		//		act.sendKeys(Keys.ARROW_UP).click();
				
			     new ScreenShots().captureScreen("one-cognizant page");
				
			     JavascriptExecutor js =  (JavascriptExecutor) driver;
				WebElement search_loc = driver.findElement(By.xpath("//*[@id=\"DesktopPlatformBar\"]/nav[1]/div/ul[2]/li"));
				js.executeScript("arguments[0].click();", search_loc);
				
				
		//		WebElement search_loc = driver.findElement(By.xpath("//div[@aria-label='Search']"));
		//		Actions act = new Actions(driver);
		//		act.moveToElement(search_loc).click().build().perform();
				
				 
		//		driver.findElement(By.xpath("//*[@class='searchTopBar']")).click();
				
				driver.findElement(By.xpath("//input[@placeholder='Search this site ...']")).sendKeys("Tru Time");
				driver.findElement(By.xpath("//div[@class='appsResultText']")).click();
				
			}
				
			@Test(priority=5,groups= {"second"})
//			@Test(priority=5)
			 public void TruTimeFrame()
			{
				
				//switch to iframe................................................................
		
				driver.switchTo().frame("appFrame");
				
			}
				
				
		
				
				
				
			@Test(priority=6,groups= {"second"})
//			@Test(priority=6)
			 public void CrrentDetails()
			{
				
				//collecting current week details................................................................
		
		
				System.out.println("\n"+"collecting current week details................................................................");
				List<WebElement> curnt_week_details = driver.findElements(By.xpath("//div[@class='weekContainer']/div/div[1]"));
				System.out.println(curnt_week_details.size());
				
				for(WebElement list : curnt_week_details)
				{
					System.out.println(list.getText());
				}
				
				Assert.assertEquals(curnt_week_details.size(), 7 , "CrrentDetails is invalid");
			}	
				
				
				
			@Test(priority=7,groups= {"second"})
//			@Test(priority=7)
			 public void ScroolDown()
			{
				
				//scroll down to ................................................................
		
		
				 act = new Actions(driver);
		//		act.keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).perform();
				act.sendKeys(Keys.PAGE_DOWN).perform();
				
		//		Thread.sleep(3000);
				
				
				
			}	
				
				
				
			
			
			@Test(priority=8,groups= {"third"})
//			@Test(priority=8)
			 public void CrrentDate()
			{
				
				//get current date................................................................
		
				System.out.println("\n"+"get current date................................................................");
				String current_day = driver.findElement(By.xpath("//div[@class='weekContainer']/div/div[1][contains(@class,'dayHeadr active')]")).getText();
				System.out.println("the current date is:  "+current_day);                               //the current date is:  Fri, 22 Mar
				
				
				formatter_day= new SimpleDateFormat("EEE, dd MMM");
				String system_Day = formatter_day.format(date);
				System.out.println(system_Day);                                                  //Fri, 22 Mar
				
				if(current_day.equals(system_Day))
				{
					System.out.println("validation of current date is : true");
				}
				else
				{
					System.out.println("validation of current date is : false");
				}
					
				Assert.assertEquals(current_day, system_Day , "CrrentDate is invalid");

				
			}
				
				
				
			@Test(priority=9,groups= {"second"})
//			@Test(priority=9)
			 public void ScroolUp()
			{
				//scroll up ................................................................
				
				act.sendKeys(Keys.PAGE_DOWN).perform();
				
			}
				
				
				
			@Test(priority=10,groups= {"third"})
			 public void MonthAndYear()
			{
			
				
				//get current month and year................................................................
				
				
				System.out.println("\n"+"get current month and year................................................................");
				List<WebElement> month_year = driver.findElements(By.xpath("//div[@id='datepicker']/div/div/div/span"));  //March 2024
				
				String act_mont_year = "";
				for(WebElement list2 : month_year)
				{
					act_mont_year += list2.getText();
		//			act_mont_year += "";
				}
				System.out.println(act_mont_year);
				
				
				formatter_year= new SimpleDateFormat("MMMMYYYY");
				String exc_mont_year = formatter_year.format(date);
		        System.out.println(exc_mont_year);
				
				if(exc_mont_year.equals(act_mont_year)) 
				{
					System.out.println("validation of MONTH AND YEAR is : true");
				}
				else
				{
					System.out.println("validation of MONTH AND YEAR is : false");
				}
			
				
				
				Assert.assertEquals(exc_mont_year, act_mont_year , "MonthAndYear is invalid");

		        
			}   
		        
		        
		        
		        
		        
		        
			@Test(priority=11,groups= {"third"})
//			@Test(priority=11)
			 public void BackUpDate() throws ParseException
			{  
		        
		        
				
				//get backdated topup message ................................................................
				
				
				System.out.println("\n"+"get backdated topup message ................................................................");
				 String back_date = driver.findElement(By.xpath("//div[@class='topupavailablefrom']")).getText();
						
				 System.out.println("\n"+back_date);                           //You can apply for backdated TopUp only until: Thu, 08 Mar
				
				 
				 
			 
				 
				 
				 
				 
				 
				 
				 
		//		 int index = back_date.indexOf('0');                            
		////		 System.out.println(index);                                   //51
		//		 int sub_string = Integer.parseInt(back_date.substring(51,53));
		//		 System.out.println(sub_string);                                      //08
		//		 
		//		 
		//		 formatter_date= new SimpleDateFormat("dd");
		//		 String sys_date = formatter_date.format(date);               //23
		//		 System.out.println(sys_date);
		//		 
		//		 
		//		 int act_sys_date  = Integer.parseInt(sys_date);
		////		 System.out.println(act_sys_date);
		//		 int date = (act_sys_date-15);
		//		 System.out.println(date);
		//		 
		//		 if(sub_string==date)
		//		 {
		//			 System.out.println("validation of current date is : true");
		//		 }
		//		 else
		//		 {
		//			 System.out.println("validation of current date is : false");
		//		 }
		
				 
				 
				 
				 
				 
				 
				 
				 
				//converting String date ................................................................
		
				 
				 
				 System.out.println("\n"+"converting String date ................................................................");
				 String sub_string = back_date.substring(51);   
		//		 System.out.println(sub_string); 
				 
				 having_date= new SimpleDateFormat("dd MMM");
				 converting_date = new SimpleDateFormat("dd-MM"); 
				 
				 date = having_date.parse(sub_string);
				  act_date1 = converting_date.format(date);
				 System.out.println(act_date1);                                   //08-03
				 
				 
				 
				 
				 
				 
				 
				 
				 
				//getting system date ................................................................
				 
				 
				 System.out.println("\n"+"getting system date ...............................................................");
				 SYS_date= new SimpleDateFormat("dd-MM-yyyy");
				 String system_date = SYS_date.format(date2); 
				 
				 System.out.println(system_date);                                          //23-03
				 
				 
				 
				 
				 
		
				 
				 
				 
				//15 days back date ................................................................
		
				 
				 System.out.println("\n"+"15 days back date ................................................................");
		//		 SimpleDateFormat minus_date = new SimpleDateFormat("dd-MM-yyyy");
		//		 LocalDate date = SimpleDateFormat.parse("23-03-2024" , minus_date);
				 
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				 loc_date = LocalDate.parse(system_date , dtf);
				 minus_date = loc_date.minusDays(15); 
				 String act_minusDate = minus_date.format(dtf);
				 System.out.println(act_minusDate); 
				  act_date2 = act_minusDate.substring(0, 5);
				 
				 

				  
			}	 
				 
				 
				 
			@Test(priority=12,groups= {"second"})
//			@Test(priority=12)
			 public void Verification_BakUpDate()
			{ 
				 
				 
				//comparing the system and trutime dates ................................................................
		
				 
				 
				 System.out.println("\n"+"comparing the system and trutime dates ................................................................");
				 if(act_date1.equals(act_date2))
				 {
					 System.out.println("validation of backdated TopUp date is : true");
				 }
				 else
				 {
					 System.out.println("validation of backdated TopUp date is : false");
				 }
				 
				 
 
				 Assert.assertEquals(act_date2, act_date1 , "BackUpDate is invalid");
				 
				 
			} 
				 
				 
				 
			
			
			
				 
			@Test(priority=13,groups= {"third"})
//			@Test(priority=13)
			 public void ValidationLegends()
			{	 
				 
				 
		 		//comparing the system and trutime dates ................................................................
		
				 
				 System.out.println("\n comparing the system and trutime dates ................................................................");
				 List<WebElement> legends = driver.findElements(By.xpath("//*[@id='legendListID']/ul/li"));
				 System.out.println(legends.size());
				 
				 int i=0;
				 while(i<legends.size())
				 {
					 i+=2;
					 String legend = driver.findElement(By.xpath("//*[@id='legendListID']/ul/li["+i+"]")).getText();
					 System.out.println(legend);
				 }
				 
				 
				 
					Assert.assertEquals(legends.size(), 30 , "ValidationLegends is invalid");

				 
				 
			} 
				
			
			
			
				
				
			@AfterClass (groups= {"first"})
//			@AfterClass 
			 public void CloseBrowser()
			{ 
				 
				 
				 
				//close browser................................................................
				
				 System.out.println("\n"+"close browser................................................................");
				 driver.quit();
		
				 sa.assertAll();
			}	 
       
			 
//			public void data() throws FileNotFoundException
//			{
//			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Excel.xlsx"); 
////			FileOutputStream file = new FileOutputStream(".\\testData\\Excel.xlsx");
//			
//			XSSFWorkbook worrkbook = new XSSFWorkbook();
//			XSSFSheet sheet =  worrkbook.getSheet("sheet0");
//			
//			for(int r=0 ; r<=2 ; r++)
//			{
//				XSSFRow row =  sheet.getRow(r);
//				
//				for(int c=0 ; c<=2 ; c++)
//				{
//					XSSFCell cell =  row.getCell(c);
//					String val =cell.toString();
//				}
//			}
//		
//
//			}
}



