package CAS_project;

import java.util.Date;
import java.util.Iterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.checkerframework.checker.units.qual.min;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class a {
	
	static WebDriver driver;
	static SimpleDateFormat formatter_day ,formatter_year  , having_date , converting_date ,  SYS_date , same_formate;
	static Date date = new Date(System.currentTimeMillis());
	static Date date2 = new Date(System.currentTimeMillis());
	static LocalDate minus_date , loc_date;
	
	public static void main(String[] args) throws InterruptedException, ParseException
	{
		
		
		//driver set up...........................................................................
		
//		WebDriverManager.edgedriver().setup();
		WebDriverManager.chromedriver().setup();
//		driver=new EdgeDriver();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		
		
		
		//home page set up.............................................................
		System.out.println("\n"+"home page set up.............................................................");
		driver.get("https://be.cognizant.com");
		String text = driver.getTitle();
		System.out.println(text);
		
		
		
		
		
		//switching to one cognizant  page set up.............................................................

		driver.findElement(By.xpath("//a[@href='https://onecognizant.cognizant.com/Home?GlobalAppId=926']")).click();
		
		
		
		
		
		
		//getting handels of windows set up.............................................................

		Set<String> handles = driver.getWindowHandles();
		
		List<String> list_handels = new ArrayList<String>(handles);
		
		String parent = list_handels.get(0);
		String child =list_handels.get(1);
		
		
		
		
		
		//switching to one cogzt window set up.............................................................

		driver.switchTo().window(child);
		
		
		
		
		//search and select option  set up.............................................................
//		Actions act = new Actions(driver);
//		WebElement common =driver.findElement(By.xpath("//*[@id=\"cogNewsID\"]/div[4]/div"));
//		act.contextClick(common).perform();
//		act.sendKeys(Keys.ARROW_UP).click();
		
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		WebElement search_loc = driver.findElement(By.xpath("//*[@id=\"DesktopPlatformBar\"]/nav[1]/div/ul[2]/li"));
		js.executeScript("arguments[0].click();", search_loc);
		
		
//		WebElement search_loc = driver.findElement(By.xpath("//div[@aria-label='Search']"));
//		Actions act = new Actions(driver);
//		act.moveToElement(search_loc).click().build().perform();
		
		 
//		driver.findElement(By.xpath("//*[@class='searchTopBar']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search this site ...']")).sendKeys("Tru Time");
		driver.findElement(By.xpath("//div[@class='appsResultText']")).click();
		
		
		
		
		
		//switch to iframe................................................................

		driver.switchTo().frame("appFrame");
		
		
		
		

		
		
		
		
		
		//collecting current week details................................................................


		System.out.println("\n"+"collecting current week details................................................................");
		List<WebElement> curnt_week_details = driver.findElements(By.xpath("//div[@class='weekContainer']/div/div[1]"));
		System.out.println(curnt_week_details.size());
		
		for(WebElement list : curnt_week_details)
		{
			System.out.println(list.getText());
		}
		
		
		
		
		
		
		
		//scroll down to ................................................................


		Actions act = new Actions(driver);
//		act.keyDown(Keys.PAGE_DOWN).keyUp(Keys.PAGE_DOWN).perform();
		act.sendKeys(Keys.PAGE_DOWN).perform();
		
//		Thread.sleep(3000);
		
		
		
		
		
		
		
		
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
			
			
		
		
		
		
		
		
		//scroll up ................................................................
		
		act.sendKeys(Keys.PAGE_DOWN).perform();
		
		
		
		
		
		
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
		 String act_date1 = converting_date.format(date);
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
		 String act_date2 = act_minusDate.substring(0, 5);
		 
		 
		 
		 
		 
		 
		 
		 
		 
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
		 
		 
		
		
		
		 
		 
		 
		 
		//close browser................................................................
		
		 System.out.println("\n"+"close browser................................................................");
		driver.quit();
		
	}
//	

}
